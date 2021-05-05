package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Customer;
import pe.edu.upc.service.ICustomerService;

@Named
@RequestScoped
public class CustomerController {

	@Inject
	private ICustomerService cuService;

	private Customer customer;
	List<Customer> listaCustomer;

	@PostConstruct
	public void init() {
		this.listaCustomer = new ArrayList<Customer>();
		this.customer = new Customer();
		this.Listar();
	}

	public String nuevoCustomer() {
		this.setCustomer(new Customer());
		return "Customer.xhtml";
	}

	public void insertar() {
		try {
			cuService.insert(customer);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de customer");
			// TODO: handle exception
		}
	}

	public void eliminar(Customer customer) {
		try {
			cuService.delete(customer.getID_Customer());
			this.Listar();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de owner");
			// TODO: handle exception
		}
	}
	public void Listar() {
		try {
			listaCustomer = cuService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de owner");
			// TODO: handle exception
		}
	}
	
	public void clean() {
		this.init();
	}
	public void findByName() {
		try {
			
			if(customer.getLastName_Customer().isEmpty()) {
				this.Listar();
			}else {
				listaCustomer=this.cuService.findByNameCustomer(this.getCustomer());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
	public void findByDNI() {
		try {
	
			if(customer.getDNI_Customer().isEmpty()) {
				this.Listar();
			}else {
				listaCustomer=this.cuService.findByDNICustomer(this.getCustomer());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}

	public String modifCus(Customer customer) {
        this.setCustomer(customer);
        return "CustomerMod.xhtml";
    }

    public void modificar() {
        try {
            cuService.update(this.customer);
            this.Listar();
        } catch (Exception e) {
            System.out.println("Error al modificar en el controller de Customer");
            // TODO: handle exception
        }
    }

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getListaCustomer() {
		return listaCustomer;
	}

	public void setListaCustomer(List<Customer> listaCustomer) {
		this.listaCustomer = listaCustomer;
	}

}
