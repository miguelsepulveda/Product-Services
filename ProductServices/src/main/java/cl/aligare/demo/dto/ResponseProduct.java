package cl.aligare.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import cl.aligare.demo.model.Product;

/**
 * Clase que contiene los datos de respuesta del servicio
 * @author miguel
 *
 */
public class ResponseProduct {
	
	private Long codRes;
	private String msjeRes;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Product product;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private List<Product> listProduct;
	
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	public ResponseProduct(Long codRes, String msjeRes) {
		this.codRes = codRes;
		this.msjeRes = msjeRes;
	}
	public ResponseProduct(Long codRes, String msjeRes, Product product) {
		this.product = product;
		this.codRes = codRes;
		this.msjeRes = msjeRes;
	}
	public ResponseProduct(Long codRes, String msjeRes, List<Product> products) {
		this.listProduct	= products;
		this.codRes 		= codRes;
		this.msjeRes 		= msjeRes;
	}
	
}
