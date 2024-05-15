package org.study.showroom.resources;

import java.util.List;

import org.study.showroom.hibernate.entities.BrandEntity;
import org.study.showroom.hibernate.entities.ProductEntity;
import org.study.showroom.services.BrandsService;
import org.study.showroom.services.ProductsService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/showroom/brands")
public class Brands {
	BrandsService service = new BrandsService();
	ProductsService productsService = new ProductsService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = service.getBrands();
		return list;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postBrands(BrandEntity brand) {
		service.addBrand(brand);
	}
	@PUT
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBrands(@PathParam(value = "brandId") int brandId, BrandEntity updatedBrand) {
		updatedBrand.setBrandId(brandId);
		service.updateBrand(updatedBrand);
	}
	@DELETE
	@Path("/{brandId}")
	public void deleteBrands(@PathParam(value = "brandId") int brandId) {
		service.deleteBrand(brandId);
	}
	@GET
	@Path("{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductEntity> getProductsByBrand(@PathParam(value = "brandId") int brandId) {
		List<ProductEntity> productList = productsService.getProductsByBrand(brandId);
		return productList;
	}
}
