package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IReservationDao;
import pe.edu.upc.entity.Reservation;
import pe.edu.upc.service.IReservationService;

@Named
@RequestScoped
public class ReservationServiceImpl implements IReservationService {

	@Inject
	private IReservationDao rsrDao;

	@Override
	public void insert(Reservation reservation) {
		rsrDao.insert(reservation);
	}

	@Override
	public List<Reservation> list() {
		return rsrDao.list();
	}

	@Override
	public void delete(int ID_Reservation) {
		rsrDao.delete(ID_Reservation);
	}

}
