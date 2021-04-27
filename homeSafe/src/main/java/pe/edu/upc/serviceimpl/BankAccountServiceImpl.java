package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IBankAccountDao;
import pe.edu.upc.entity.BankAccount;
import pe.edu.upc.service.IBankAccountService;

@Named
@RequestScoped
public class BankAccountServiceImpl implements IBankAccountService{
	@Inject	
	private IBankAccountDao bkDao;

public void insert(BankAccount bankaccount) {
	// TODO Auto-generated method stub
	bkDao.insert(bankaccount);
}

public List<BankAccount> list() {
	
	return bkDao.list();
}

public void delete(int ID_BankAccount) {
	bkDao.delete(ID_BankAccount);
	
}
}
