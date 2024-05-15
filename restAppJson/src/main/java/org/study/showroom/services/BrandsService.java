package org.study.showroom.services;

import java.util.List;

import org.study.showroom.hibernate.DAO.BrandsDAO;
import org.study.showroom.hibernate.entities.BrandEntity;

public class BrandsService {
	BrandsDAO DAO = new BrandsDAO();

	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = DAO.GetBrands();
		return list;
	}

	public void addBrand(BrandEntity brand) {
		DAO.addBrand(brand);
	}

	public void updateBrand(BrandEntity updatedBrand) {
		DAO.updateBrand(updatedBrand);
	}

	public void deleteBrand(int brandId) {
		DAO.deleteBrand(brandId);
	}
}
