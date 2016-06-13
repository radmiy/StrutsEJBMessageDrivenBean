package by.epamlab.ejbs.jms;

import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TextMDB implements MessageDrivenBean, MessageListener {
	private static final long serialVersionUID = -2856666424314652133L;
	private MessageDrivenContext ctx = null;
    private QueueConnection conn;
    private QueueSession session;
    
    public TextMDB() {
        System.out.println("TextMDB.ctor, this="+hashCode());
    }
    
    public void setMessageDrivenContext(MessageDrivenContext ctx) {
        this.ctx = ctx;
        System.out.println("TextMDB.setMessageDrivenContext");
    }
    
    public void ejbCreate() {
        System.out.println("TextMDB.ejbCreate");
        try {
            setupPTP();
        } catch (Exception e) {
            throw new EJBException("Failed to init TextMDB", e);
        }
    }

    public void ejbRemove() {
        System.out.println("TextMDB.ejbRemove");
        ctx = null;
        try {
            if (session != null) {
                session.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch(JMSException e) {
            e.printStackTrace();
        }
    }
                
    public void onMessage(Message msg) {
        try {
			System.out.println("TextMDB.onMessage, this="+((TextMessage)msg).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
                
    private void setupPTP() throws JMSException, NamingException {
        InitialContext iniCtx = new InitialContext();
        Object tmp = iniCtx.lookup("java:comp/env/jms/QCF");
        QueueConnectionFactory qcf = (QueueConnectionFactory) tmp;
        conn = qcf.createQueueConnection();
        session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        conn.start();
    }
}