package cl.aligare.demo.dto;

import java.util.List;
import java.util.Optional;

import cl.aligare.demo.model.Product;

/**
 * Clase que contiene los datos de respuesta del servicio
 * @author miguel
 *
 */
public class ResponseProduct {
	private Long codRes;
	private String msjeRes;
	private Optional<Product> product;
	private Optional<List<Product>> listProduct;
	
	public Long getCodRes() {
		return codRes;
	}
	public void setCodRes(Long codRes) {
		this.codRes = codRes;
	}
	public String getMsjeRes() {
		return msjeRes;
	}
	public void setMsjeRes(String msjeRes) {
		this.msjeRes = msjeRes;
	}
	public Optional<Product> getProduct() {
		return product;
	}
	public void setProduct(Optional<Product> product) {
		this.product = product;
	}
	public Optional<List<Product>> getListProduct() {
		return listProduct;
	}
	public void setListProduct(Optional<List<Product>> listProduct) {
		this.listProduct = listProduct;
	}
	
	
}
