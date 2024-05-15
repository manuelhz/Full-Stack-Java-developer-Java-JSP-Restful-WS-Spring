package org.study.showroom.resources;

import java.util.List;

import org.study.showroom.hibernate.entities.BrandEntity;
import org.study.showroom.services.BrandsService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/showroom")
public class Brands {
	BrandsService service = new BrandsService();
	@GET
	@Path("/brands")
	@Produces(MediaType.APPLICATION_XML)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = service.getBrands();
		return list;
	}
	@POST
	@Path("/brands")
	@Consumes(MediaType.APPLICATION_XML)
	public void postBrands(BrandEntity brand) {
		service.addBrand(brand);
	}
	@PUT
	@Path("/brands/{brandId}")
	@Consumes(MediaType.APPLICATION_XML)
	public void putBrands(@PathParam(value = "brandId") int brandId, BrandEntity updatedBrand) {
		updatedBrand.setBrandId(brandId);
		service.updateBrand(updatedBrand);
	}
	@DELETE
	@Path("/brands/{brandId}")
	public void deleteBrands(@PathParam(value = "brandId") int brandId) {
		service.deleteBrand(brandId);
	}
}
