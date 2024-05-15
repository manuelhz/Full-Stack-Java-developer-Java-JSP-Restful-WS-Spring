package org.study.showroom.hibernate.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity(name="products")
//@Table(name="products")
public class ProductEntity {
	
	@Id
	@Column(name = "product_id")
	int productId;
	
	@ManyToOne
	@JoinTable(name = "products",
			joinColumns= {@JoinColumn(name = "brand_id")},
			inverseJoinColumns = {@JoinColumn(name="brand_Id")}			
	)
	
	private BrandEntity brandEntity;
	
	@Column(name = "product_name")
	String productName;
	
	@Column(name = "category")
	String category;
	
	@Column(name = "cost")
	String cost;

	public ProductEntity() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public BrandEntity getBrandEntity() {
		return brandEntity;
	}

	public void setBrandEntity(BrandEntity brandEntity) {
		this.brandEntity = brandEntity;
	}
	

}
