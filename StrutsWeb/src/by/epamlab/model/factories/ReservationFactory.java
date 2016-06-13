package by.epamlab.model.factories;

import by.epamlab.ifaces.IReservationDAO;
import by.epamlab.model.impl.ReservationImplXML;

public class ReservationFactory {
	public static IReservationDAO getImplFromFactory() {
		return new ReservationImplXML();
	}

}
