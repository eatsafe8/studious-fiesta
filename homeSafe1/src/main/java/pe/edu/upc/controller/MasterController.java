package pe.edu.upc.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.User;
import pe.edu.upc.entity.UserRol;
import pe.edu.upc.service.IRolService;

@Named
@ViewScoped
public class MasterController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IRolService rS;

	public void verificarSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			User us = (User) context.getExternalContext().getSessionMap().get("user");
			
			if(us == null) {
				context.getExternalContext().redirect("index.xhtml");
			}else {
				//verificacion de roles
				String viewId = context.getViewRoot().getViewId();
				boolean rpta = this.verificarMenu(viewId);
				
				if(!rpta) {
					context.getExternalContext().redirect("./403.xhtml");
				}
			}			
		} catch (Exception e) {

		}
	}
	
	public boolean verificarMenu(String viewId) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		User us = (User) context.getExternalContext().getSessionMap().get("user");

		List<UserRol> roles = rS.findUserRolesByUser(us);

		String rol = "";
		switch (viewId) {
		case "/listRestaurant.xhtml":
			rol = "USER,ADMIN";
			break;
		case "/BankAccount.xhtml":
			rol = "ADMIN";
			break;
		case "/listPromotion.xhtml":
			rol = "USER,ADMIN";
			break;
		case "/panel.xhtml":
			rol = "ADMIN,USER";
			break;
		case "/listDetailPromotion.xhtml":
			rol = "ADMIN,USER";
			break;
		case "/listProduct.xhtml":
			rol = "ADMIN,USER";
			break;
		case "/listBankAccount.xhtml":
			rol = "ADMIN";
			break;
		case "/Card.xhtml":
			rol = "ADMIN";
			break;
		case "/listCard.xhtml":
			rol = "ADMIN";
			break;
		case "/Customer.xhtml":
			rol = "ADMIN";
			break;
		case "/listCustomer.xhtml":
			rol = "ADMIN";
			break;
		case "/Delivery.xhtml":
			rol = "ADMIN";
			break;
		case "/ListDelivery.xhtml":
			rol = "ADMIN";
			break;
		case "/DetailPromotion.xhtml":
			rol = "ADMIN";
			break;
		case "/Order.xhtml":
			rol = "ADMIN";
			break;
		case "/listOrder.xhtml":
			rol = "ADMIN";
			break;
		case "/OrderDetail.xhtml":
			rol = "ADMIN";
			break;
		case "/listOrderDetail.xhtml":
			rol = "ADMIN";
			break;
		case "/OrderProm.xhtml":
			rol = "ADMIN";
			break;
		case "/listOrderProm.xhtml":
			rol = "ADMIN";
			break;
		case "/Owner.xhtml":
			rol = "ADMIN";
			break;
		case "/listOwner.xhtml":
			rol = "ADMIN";
			break;
		case "/Restaurant.xhtml":
			rol = "ADMIN";
			break;
		case "/Reservation.xhtml":
			rol = "ADMIN";
			break;
		case "/listReservation.xhtml":
			rol = "ADMIN";
			break;
		case "/Roundsman.xhtml":
			rol = "ADMIN";
			break;
		case "/listRoundsman.xhtml":
			rol = "ADMIN";
			break;
		case "/Vehicle.xhtml":
			rol = "ADMIN";
			break;
		case "/listVehicle.xhtml":
			rol = "ADMIN";
			break;
		case "/Product.xhtml":
			rol = "ADMIN";
			break;
		case "/Promotion.xhtml":
			rol = "ADMIN";
			break;
		case "/listDelivery.xhtml":
			rol = "ADMIN";
			break;
		case "/ProductMod.xhtml":
			rol = "ADMIN";
			break;
		case "/CustomerMod.xhtml":
			rol = "ADMIN";
			break;
			
		default:
			break;
		}

		String arreglo[] = rol.split(",");

		int[] iarr = { 0 };
		roles.forEach(r -> {
			for (String x : arreglo) {
				if (r.getRol().getType().equals(x)) {
					iarr[0]++;
				}
			}
		});

		// System.out.println(iarr[0]);
		if (iarr[0] == 0) {
			return false;
		}
		return true;
	}
	
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
