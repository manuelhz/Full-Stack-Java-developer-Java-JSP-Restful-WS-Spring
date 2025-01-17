package org.study.showroom.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.study.showroom.hibernate.entities.BrandEntity;
import org.study.showroom.hibernate.entities.ProductEntity;

public class ProductsDAO {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(ProductEntity.class)
			.addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String sql = "from products where brandEntity=" + brandId;
		List<ProductEntity> productList = session.createQuery(sql).getResultList();
		return productList;
	}

}