package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.dao.IRolDao;
import pe.edu.upc.entity.Rol;
import pe.edu.upc.entity.User;
import pe.edu.upc.entity.UserRol;

@Named
public class RolDaoImpl implements IRolDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;

	public Integer insert(Rol t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	public Integer update(Rol t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	public Integer delete(Rol t) throws Exception {
		em.remove(t);
		return 1;
	}

	@SuppressWarnings("unchecked")
	public List<Rol> findAll() throws Exception {
		List<Rol> roles = new ArrayList<Rol>();

		Query q = em.createQuery("SELECT r FROM Rol r");
		roles = (List<Rol>) q.getResultList();
		return roles;
	}

	@SuppressWarnings("unchecked")
	public Optional<Rol> findById(Rol t) throws Exception {

		Rol rol = new Rol();
		List<Rol> roles = new ArrayList<Rol>();
		Query query = em.createQuery("FROM Rol r where r.id = ?1");
		query.setParameter(1, t.getId());

		roles = (List<Rol>) query.getResultList();

		if (roles != null && !roles.isEmpty()) {
			rol = roles.get(0);
		}

		return Optional.of(rol);
	}

	public Integer insertUserRole(List<UserRol> userRoles) throws Exception {
		try {

			final int[] iarr = { 0 };
			userRoles.forEach(r -> {
				em.persist(r);
				if (iarr[0] % 100 == 0) {
					em.flush();
					em.clear();
				}
				iarr[0]++;
			});
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@SuppressWarnings("unchecked")
	public List<UserRol> findUserRolesByUser(User user) throws Exception {
		List<UserRol> userRoles = new ArrayList<UserRol>();

		try {
			Query query = em.createQuery("FROM UserRol ur where ur.user.customerSecurity.id =?1");
			query.setParameter(1, user.getCustomerSecurity().getId());

			userRoles = (List<UserRol>) query.getResultList();

		} catch (Exception e) {
			throw e;
		}

		return userRoles;
	}

}
