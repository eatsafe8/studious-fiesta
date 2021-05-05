package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IBankAccountDao;
import pe.edu.upc.entity.BankAccount;

public class BankAccountDaoImpl implements IBankAccountDao{
	@PersistenceContext(unitName="homeSafe")
	private EntityManager em;
	
	@Transactional
	public void insert(BankAccount bankaccount) {
		try {
			em.persist(bankaccount);
		} catch (Exception e) {
			System.out.println("Error al insertar BankAccount DaoImpl");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<BankAccount> list() {
		List<BankAccount> lista=new ArrayList<BankAccount>();
		try {
			Query q=em.createQuery("from BankAccount m");
			lista=(List<BankAccount>)q.getResultList();
			}
		catch (Exception e) {
			System.out.println("Error al listar las cuentas de banco DaoImpl");
			System.out.println(e.getLocalizedMessage());
		}
		return lista;
	}
	
	@Transactional
	public void delete(int ID_BankAccount) {
		BankAccount bankaccount= new BankAccount();
		try {
			bankaccount=em.getReference(BankAccount.class, ID_BankAccount);
			em.remove(bankaccount);
		} catch (Exception e) {
			System.out.println("Error al eliminar cuenta bancaria DaoImpl");
		}
		
	}
}
