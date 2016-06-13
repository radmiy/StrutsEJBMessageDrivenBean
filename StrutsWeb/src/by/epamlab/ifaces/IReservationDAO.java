package by.epamlab.ifaces;

import by.epamlab.beans.reservation.ObjectElement;
import by.epamlab.model.exceptions.DaoException;

import java.util.List;

public interface IReservationDAO {
	public List<ObjectElement> getElement(String nameElement, String params) throws DaoException;
}
