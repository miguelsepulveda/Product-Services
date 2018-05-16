package cl.aligare.demo.restcontroller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.aligare.demo.dto.ResponseProduct;
import cl.aligare.demo.model.Product;
import cl.aligare.demo.services.ProductService;

/**
 * Clase que se encarga de la interfaz de entrada del servicio rest de productos
 * 
 * @author Aligare
 *
 */
@RestController
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
	
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET )
    public ResponseProduct getProducts() {
		try {
			ResponseProduct response = new ResponseProduct(0L,"OK");
            response.setListProduct(productService.listAll());
            return response;
        }catch (Exception e) {
        	System.err.println(e);
            return new ResponseProduct(-1L,"NOK");
		} 
    }
	
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
    public ResponseProduct addProduct(@RequestBody Product producto) {
		try {
			ResponseProduct response = new ResponseProduct(0L,"OK");
            response.setProduct(productService.saveOrUpdate(producto));
            return response;
        }catch (Exception e) {
        	System.err.println(e);
            return new ResponseProduct(-1L,"NOK");
		} 
    }
	
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT )
    public ResponseProduct editProduct(@RequestBody Product producto) {
		try {
			ResponseProduct response = new ResponseProduct(0L,"OK");
            response.setProduct(productService.saveOrUpdate(producto));
            return response;
        }catch (Exception e) {
        	System.err.println(e);
            return new ResponseProduct(-1L,"NOK");
		} 
    }
	
	@RequestMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
    public ResponseProduct addProductDemo() {
		try {
			Product pr = new Product();
	        pr.setId(1L);
	        pr.setDescription("CUchi");
	        pr.setImageUrl("http://www.google.cl");
	        pr.setPrice(new BigDecimal(2000));
	        
			ResponseProduct response = new ResponseProduct(0L,"OK");
            response.setProduct(productService.saveOrUpdate(pr));
            return response;
        }catch (Exception e) {
        	System.err.println(e);
            return new ResponseProduct(-1L,"NOK");
		} 
		
    }
	
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE )
    public ResponseProduct deleteProducts(@RequestParam(name="id") Long id) {
        try {
        	productService.delete(id);
            return new ResponseProduct(0L,"OK");
        }catch (Exception e) {
        	System.err.println(e);
            return new ResponseProduct(-1L,"NOK");
		}
    }
	
	@RequestMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseProduct getProduct(@PathVariable(name="id") Long id) {
        try {
            ResponseProduct response = new ResponseProduct(0L,"OK");
            response.setProduct(productService.getById(id));
            return response;
        }catch (Exception e) {
        	System.err.println(e);
            return new ResponseProduct(-1L,"NOK");
		} 
    }
	
}
