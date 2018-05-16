package cl.aligare.demo.restcontroller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public List<Product> getProducts() {
        return productService.listAll();
    }
	
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
    public Product addProduct(@RequestBody Product producto) {
        return productService.saveOrUpdate(producto);
    }
	
	@RequestMapping(path = "/product/demo", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
    public Product addProductDemo() {
        Product pr = new Product();
        pr.setId(1L);
        pr.setDescription("CUchi");
        pr.setImageUrl("http://www.google.cl");
        pr.setPrice(new BigDecimal(2000));
		return productService.saveOrUpdate(pr);
    }
	
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE )
    public ResponseProduct deleteProducts(@RequestParam(name="id") Long id) {
        try {
        	productService.delete(id);
            ResponseProduct response = new ResponseProduct();
            response.setCodRes(0L);
            response.setMsjeRes("OK");
            return response;
        }catch (Exception e) {
        	System.out.println(e);
            ResponseProduct response = new ResponseProduct();
            response.setCodRes(-1L);
            response.setMsjeRes("NOK");
            return response;
		} 
		
         
    }
	
}
