package cl.aligare.demo.services;

import java.util.List;

import cl.aligare.demo.model.Product;

/**
 * Interfaz services para productos
 */
public interface ProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);
}
