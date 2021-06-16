package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Reservation;
import pe.edu.upc.repository.ReservationRepository;
import pe.edu.upc.service.IReservationService;

@Service
public class ReservationServiceImpl implements IReservationService{

	@Autowired
	private ReservationRepository rp;
	
	@Override
	public void insert(Reservation rv) {
		// TODO Auto-generated method stub
		rp.save(rv);
	}

	@Override
	public List<Reservation> list() {
		// TODO Auto-generated method stub
		return rp.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		rp.deleteById(id);
	}

	@Override
	public Optional<Reservation> listarID(int ID_Reservation) {
		// TODO Auto-generated method stub
		return rp.findById(ID_Reservation);
	}

}
