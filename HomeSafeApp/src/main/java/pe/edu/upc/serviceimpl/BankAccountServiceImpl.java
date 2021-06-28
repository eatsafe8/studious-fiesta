package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.BankAccount;
import pe.edu.upc.repository.BankAccountRepository;
import pe.edu.upc.service.IBankAccountService;

@Service
public class BankAccountServiceImpl implements IBankAccountService {
	@Autowired
	private BankAccountRepository bR;

	@Override
	public void insert(BankAccount ba) {
		bR.save(ba);
	}

	@Override
	public List<BankAccount> list() {
		// TODO Auto-generated method stub
		return bR.findAll();
	}

	@Override
	public void delete(int id) {
		bR.deleteById(id);
	}

	@Override
	public Optional<BankAccount> listarID(int id) {
		// TODO Auto-generated method stub
		return bR.findById(id);
	}
}
