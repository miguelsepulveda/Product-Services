package cl.aligare.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aligare.demo.model.Product;
import cl.aligare.demo.repository.ProductRepository;

/**
 * Clase que se encarga de la logica services de los productos
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);;

    }

}
