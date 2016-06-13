package by.epamlab.model.utils.xml;

import by.epamlab.ifaces.IReservationDAO;
import by.epamlab.beans.reservation.ObjectElement;
import by.epamlab.model.exceptions.DaoException;
import by.epamlab.model.factories.ReservationFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
	private static int numTab = 0;
	public static void main(String[] args) {
		IReservationDAO reservationDAO = ReservationFactory.getImplFromFactory();
		try {
			List<ObjectElement> objectElementList = reservationDAO.getElement("Reservation", "");
			for(ObjectElement objectElement: objectElementList) {
				printObject(objectElement);
			}

			System.out.println(reservationDAO.getElement("Reservation", ""));
		}catch (DaoException e) {
			e.printStackTrace();
		}
	}

	private static void printObject(ObjectElement objectElement) {
		numTab++;
		String ab = getTabulation();
		System.out.println(ab + objectElement.getNameElement() + " {");
		numTab++;
		ab = getTabulation();
		HashMap<String, List<ObjectElement>> objectElementList = objectElement.getContent();
		HashMap<String, String> attributes = objectElement.getAttributes();

		if(attributes != null) {
			for (Map.Entry<String, String> value: attributes.entrySet()){
				System.out.println(ab + value + ";");
			}
		}
		System.out.println();
		if(objectElementList != null) {
			for (Map.Entry<String, List<ObjectElement>> object : objectElementList.entrySet()) {
				System.out.print(object.getKey());
				if (object.getValue() != null) {
					for(ObjectElement element : object.getValue()) {
						printObject(element);
					}
				}
			}
		}
		numTab--;
		ab = getTabulation();
		System.out.println(ab + "}");
		numTab--;
	}

	private static String getTabulation() {
		String tab = "	";
		String ab = "";
		for(int i = 0; i<numTab; i++) {
			ab += tab;
		}
		return ab;
	}
}
