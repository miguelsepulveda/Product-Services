package cl.aligare.demo.repository;

import org.springframework.data.repository.CrudRepository;

import cl.aligare.demo.model.Product;

/**
 * Interfaz de comunicación con el repositorio de datos de productos 
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}
