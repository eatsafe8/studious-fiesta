package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Product;
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
	@GetMapping("/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listaRestaurantes", rService.list());
		return "product/product";
	}
	
	//valid permite visualizar la validacion de @Size, @Email, etc...
	@PostMapping("/save")
	public String saveProduct(@Valid @ModelAttribute(value="product") Product product, BindingResult result, 
			Model model, SessionStatus status) throws Exception{
		if(result.hasErrors()) {
			return "product/product";
		}else {
			pService.insert(product);
			model.addAttribute("mensaje","Se realizó bien!");
			status.setComplete();
			return "redirect:/products/list";
		}
	}
	
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
	
	@RequestMapping("/reports")
	public String Report()
	{
		return "reports/reports";
	}
	
	@RequestMapping("/reporte1")
	public String productosXord(Map<String, Object> model) {
		model.put("listProdxImp", pService.prodXord());
		return "reports/productosOrdenados";
	}
}
