package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Product;
import pe.edu.upc.entities.Vehicle;
import pe.edu.upc.service.IProductService;
import pe.edu.upc.service.IRestaurantService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private IProductService pService;
	@Autowired
	private IRestaurantService rService;
	
	/*localhost:8082/owner/*/
	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listaRestaurantes", rService.list());
		return "product/product";
	}
	
	//valid permite visualizar la validacion de @Size, @Email, etc...
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String saveProduct(@Valid @ModelAttribute(value="product") Product product, BindingResult result, 
			Model model, SessionStatus status) throws Exception{
		if(result.hasErrors()) {
			model.addAttribute("listaRestaurantes", rService.list());
			return "product/product";
		}else {
			pService.insert(product);
			model.addAttribute("mensaje","Se realizó bien!");
			status.setComplete();
			return "redirect:/products/list";
		}
	}
	@Secured({"ROLE_ADMIN","ROLE_CUSTOMER"})
	@GetMapping("/list")
	public String listProduct(Model model) {
		try {
			model.addAttribute("listaProductos",pService.list());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
			// TODO: handle exception
		}
		return "product/listProduct";
	}
	
	//para editar o modificar es request pero solo lectura se usa get?
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteProduct(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				pService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			// TODO: handle exception
		}
		return "redirect:/products/list";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/detalle/{id}")
	public String viewProduct(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Product> product = pService.listarId(id);
			model.addAttribute("listaRestaurantes", rService.list());
			if(!product.isPresent()) {
				model.addAttribute("mensaje","Producto no existe");
				return "redirect:/products/list";
			}
			else {
				model.addAttribute("product",product.get());
				return "product/updateProduct";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "product/updateProduct";
	}
	@Secured({"ROLE_ADMIN","ROLE_CUSTOMER"})
	@GetMapping("/listFind")
	public String listProductFind(Model model) {
		try {
			model.addAttribute("product", new Product());
			model.addAttribute("listaProductos", pService.list());

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "product/find";
	}
	@Secured({"ROLE_ADMIN","ROLE_CUSTOMER"})
	@RequestMapping("/find")
	public String findByProduct(Model model, @ModelAttribute Product product) throws ParseException {
		List<Product> listaProductos = new ArrayList<Product>();
		product.setNameProduct(product.getNameProduct());
		model.addAttribute("product", new Product());

		if (listaProductos.isEmpty()) {
			listaProductos = pService.searchNameIgnoreCase(product.getNameProduct());
		}
		if (listaProductos.isEmpty()) {
			listaProductos = pService.findByName(product.getNameProduct());
		}
		if (listaProductos.isEmpty()) {
			model.addAttribute("mensaje", "No se encontró");
		}
		
		model.addAttribute("listaProductos", listaProductos);
		return "product/find";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/reports")
	public String Report()
	{
		return "reports/reports";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/reporte1")
	public String productosXord(Map<String, Object> model) {
		model.put("listProdxImp", pService.prodXord());
		return "reports/productosOrdenados";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/reporte5")
	public String ProdVendPrim6Mes(Map<String, Object> model) {
		model.put("listProdVendPrim6Mes", pService.ProdVendPrim6Mes());
		return "reports/ProdVendPrim6Mes";
	}
}
