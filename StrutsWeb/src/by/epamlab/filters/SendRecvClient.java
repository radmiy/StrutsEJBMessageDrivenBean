package by.epamlab.filters;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import by.epamlab.utilites.PropertiesUtil;

public class SendRecvClient
{
    private QueueConnection conn;
    private QueueSession session;
    private Queue textMDB;
    
    public static class ExListener implements MessageListener {
        public void onMessage(Message msg)
        {
            TextMessage tm = (TextMessage) msg;
            try {
                System.out.println("onMessage, recv text="+tm.getText());
            } catch(Throwable t) {
                t.printStackTrace();
            }
        }
    }
    
    public void setupPTP() throws JMSException, NamingException {
        InitialContext iniCtx = PropertiesUtil.getInitialContext();
        Object tmp = iniCtx.lookup("ConnectionFactory");
        QueueConnectionFactory qcf = (QueueConnectionFactory) tmp;
        conn = qcf.createQueueConnection();
        textMDB = (Queue) iniCtx.lookup("queue/TextMDB");
        session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        conn.start();
    }
    
    public void sendRecvAsync(String textBase) throws JMSException, NamingException, InterruptedException {
        setupPTP();

        // Send a few text msgs to queB
        QueueSender send = session.createSender(textMDB);

        TextMessage tm = session.createTextMessage(textBase);
        send.send(tm);
        System.out.println("Sent text= " + tm.getText());
    }
    
    public void stop() throws JMSException {
        conn.stop();
        session.close();
        conn.close();
    }
    
}
