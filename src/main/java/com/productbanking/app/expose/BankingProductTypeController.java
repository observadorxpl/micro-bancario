package com.productbanking.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productbanking.app.business.IBankingProductTypeService;
import com.productbanking.app.models.BankingProductType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(value = "Banking Product Microservice")
@RequestMapping("/products-type")
public class BankingProductTypeController {
	@Autowired
	private IBankingProductTypeService tipoProductoService;

	@GetMapping
	@ApiOperation(value = "List all product's types", notes="Find all product's types")
	public Flux<BankingProductType> findAllProductsType() {
		return tipoProductoService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find a product's type", notes="Find a product's type by id")
	public Mono<BankingProductType> findProductType(@PathVariable String id) {
		return tipoProductoService.finById(id);
	}

	@PostMapping
	@ApiOperation(value = "Save a product's type", notes="Save and return a product's type")
	public Mono<BankingProductType> saveProductType(@RequestBody BankingProductType productType) {
		return tipoProductoService.save(productType);
	}

	@PutMapping
	@ApiOperation(value = "Update a product's type", notes="Update and return a product's type")
	public Mono<BankingProductType> updateProductType(@RequestBody BankingProductType productType) {
		return tipoProductoService.save(productType);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a product's type", notes="Delete a product's type by id")
	public Mono<Void> deleteProductType(@PathVariable String id){
		return tipoProductoService.deleteById(id);
	}
}
