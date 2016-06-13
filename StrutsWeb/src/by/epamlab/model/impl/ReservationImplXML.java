package by.epamlab.model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import by.epamlab.beans.reservation.ObjectElement;
import by.epamlab.ejbs.reservation.CustomerSvHome;
import by.epamlab.ejbs.reservation.CustomerSvRemote;
import by.epamlab.ejbs.reservation.FareFamilySvHome;
import by.epamlab.ejbs.reservation.FareFamilySvRemote;
import by.epamlab.ejbs.reservation.ResComponentSvHome;
import by.epamlab.ejbs.reservation.ResComponentSvRemote;
import by.epamlab.ifaces.IReservationDAO;
import by.epamlab.utilites.PropertiesUtil;

public class ReservationImplXML implements IReservationDAO {
	enum Elements {
		RESERVATION,
		CUSTOMER,
		FAREFAMILY;
	}
	
	@Override
	public List<ObjectElement> getElement(String nameElement, String params) {
		InitialContext context;
		List<ObjectElement> result = new ArrayList<ObjectElement>();
		try {
			context = PropertiesUtil.getInitialContext();
		} catch (NamingException e1) {
			e1.printStackTrace();
			return null;
		}
		Object ref = null;
		if(nameElement != null && !nameElement.equals(""))
		{
			try {
				switch (Elements.valueOf(nameElement.toUpperCase())) {
					case RESERVATION:
						final String code = "0004257753";
						final String componentTypeCode = "ANCILLARYAIR";
						ref = context.lookup("ResComponentSv");
						ResComponentSvHome resComponentSvHome = (ResComponentSvHome) PortableRemoteObject.narrow(ref, ResComponentSvHome.class);
						ResComponentSvRemote resComponentSvRemote = resComponentSvHome.create();
						result = resComponentSvRemote.getResComponent(params, code, componentTypeCode);
						break;
					
					case CUSTOMER:
						ref = context.lookup("CustomerSv");
						CustomerSvHome customerSvHome = (CustomerSvHome) PortableRemoteObject.narrow(ref, CustomerSvHome.class);
						CustomerSvRemote customerSvRemote = customerSvHome.create();
						result = customerSvRemote.getCustomer(params);
						break;
						
					case FAREFAMILY:
						ref = context.lookup("FareFamilySv");
						FareFamilySvHome fareFamilySvHome = (FareFamilySvHome) PortableRemoteObject.narrow(ref, FareFamilySvHome.class);
						FareFamilySvRemote fareFamilySvRemote = fareFamilySvHome.create(); 
						result = fareFamilySvRemote.getFareFamily(params);
						break; 
						
					default:
						break;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<ObjectElement>();
			}
		}
		return result;
	}
}
