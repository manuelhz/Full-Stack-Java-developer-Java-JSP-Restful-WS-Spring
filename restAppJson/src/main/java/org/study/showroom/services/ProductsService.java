package org.study.showroom.services;

import java.util.List;

import org.study.showroom.hibernate.DAO.ProductsDAO;
import org.study.showroom.hibernate.entities.ProductEntity;

public class ProductsService {
	ProductsDAO dao = new ProductsDAO();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		List<ProductEntity> productList = dao.getProductsByBrand(brandId);
		return productList;
	}

}
