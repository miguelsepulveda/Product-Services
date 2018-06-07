package cl.aligare.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.math.BigDecimal;

/**
 * Clase que se encarga de mapear los contenidos de la tabla de productos
 * 
 */
@Entity
public class Product {

    @javax.persistence.Id
    @GeneratedValue
    private Long id;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", price=" + price + ", imageUrl=" + imageUrl
				+ "]";
	}
    
}
