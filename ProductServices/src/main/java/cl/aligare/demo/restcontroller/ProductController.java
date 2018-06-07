package cl.aligare.demo.restcontroller;

import static cl.aligare.demo.util.Constants.COD_RES_NOK;
import static cl.aligare.demo.util.Constants.COD_RES_OK;
import static cl.aligare.demo.util.Constants.MSJE_RES_NOK;
import static cl.aligare.demo.util.Constants.MSJE_RES_OK;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
 * @author Miguel Sepúlveda
 * @since 1.0.0
 */
@RestController
public class ProductController {
	
	/**
	 * Service de producto
	 */
	private ProductService productService;
	/**
	 * Logger de la clase
	 */
	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);
	
	/**
	 * Metodo que setea el service de producto
	 * @param productService
	 */
	@Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
	
	/**
	 * Metodo encargado de recuperar todos los productos existentes
	 * @return
	 */
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET )
    public ResponseProduct getProducts() {
		try {
			LOGGER.debug("Ingreso en getProducts");
			ResponseProduct response = new ResponseProduct(COD_RES_OK,MSJE_RES_OK);
            response.setListProduct(productService.listAll());
            return response;
        }catch (Exception e) {
        	LOGGER.error("Error en getProducts",e);
            return new ResponseProduct(COD_RES_NOK,MSJE_RES_NOK);
		} 
    }
	
	/**
	 * Metodo que se encarga de agregar un nuevo producto
	 * @param producto {@link Product} con el objeto a crear
	 * @return {@link ResponseProduct} objeto que contiene el producto nuevo, código y mensaje de control
	 */
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
    public ResponseProduct addProduct(@RequestBody Product producto) {
		try {
			LOGGER.debug("Ingreso en addProduct");
			ResponseProduct response = new ResponseProduct(COD_RES_OK,MSJE_RES_OK);
            response.setProduct(productService.saveOrUpdate(producto));
            return response;
        }catch (Exception e) {
        	LOGGER.error("Error en addProduct",e);
            return new ResponseProduct(COD_RES_NOK,MSJE_RES_NOK);
		} 
    }
	
	/**
	 * Metodo que se encarga de actualizar un producto
	 * @param producto {@link Product} con el objeto a modificar
	 * @return {@link ResponseProduct} objeto que contiene el producto editado, código y mensaje de control
	 */
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT )
    public ResponseProduct editProduct(@RequestBody Product producto) {
		try {
			LOGGER.debug("Ingreso en editProduct");
			ResponseProduct response = new ResponseProduct(COD_RES_OK,MSJE_RES_OK);
            response.setProduct(productService.saveOrUpdate(producto));
            return response;
        }catch (Exception e) {
        	LOGGER.error("Error en editProduct",e);
            return new ResponseProduct(COD_RES_NOK,MSJE_RES_NOK);
		} 
    }
	
	/**
	 * Metodo que se encarga de crear un producto de demostración inicial
	 * @return {@link ResponseProduct} objeto que contiene el objeto creado, código y mensaje de control
	 */
	@RequestMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
    public ResponseProduct addProductDemo() {
		try {
			LOGGER.debug("Ingreso en addProductDemo");
			Product pr = new Product();
	        pr.setId(1L);
	        pr.setDescription("Producto de prueba");
	        pr.setImageUrl("http://www.google.cl");
	        pr.setPrice(new BigDecimal(2000));
	        
			ResponseProduct response = new ResponseProduct(COD_RES_OK,MSJE_RES_OK);
            response.setProduct(productService.saveOrUpdate(pr));
            return response;
        }catch (Exception e) {
        	LOGGER.error("Error en addProductDemo",e);
            return new ResponseProduct(COD_RES_NOK,MSJE_RES_NOK);
		} 
		
    }
	
	/**
	 * Metodo que se encarga de eliminar un producto
	 * @param id identificatorio del producto a eliminar
	 * @return {@link ResponseProduct} objeto que contiene el codigo y mensaje de control de la operación realizada
	 */
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE )
    public ResponseProduct deleteProducts(@RequestParam(name="id") Long id) {
        try {
        	LOGGER.debug("Ingreso en deleteProducts");
        	productService.delete(id);
            return new ResponseProduct(COD_RES_OK,MSJE_RES_OK);
        }catch (Exception e) {
        	LOGGER.error("Error en deleteProducts",e);
            return new ResponseProduct(COD_RES_NOK,MSJE_RES_NOK);
		}
    }
	
	/**
	 * Metodo que se encarga de buscar un producto a partir de su id
	 * @param id identificatorio del producto a buscar
	 * @return {@link ResponseProduct} objeto que contiene el producto buscado, código y mensaje de control
	 */
	@RequestMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseProduct getProduct(@PathVariable(name="id") Long id) {
        try {
        	LOGGER.debug("Ingreso en getProduct");
            ResponseProduct response = new ResponseProduct(COD_RES_OK,MSJE_RES_OK);
            response.setProduct(productService.getById(id));
            return response;
        }catch (Exception e) {
        	LOGGER.error("Error en getProduct",e);
            return new ResponseProduct(COD_RES_NOK,MSJE_RES_NOK);
		} 
    }
	
}
