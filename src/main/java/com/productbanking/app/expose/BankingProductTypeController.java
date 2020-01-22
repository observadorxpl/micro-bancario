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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products-type")
public class BankingProductTypeController {
	@Autowired
	private IBankingProductTypeService tipoProductoService;

	@GetMapping
	public Flux<BankingProductType> findAllProductsType() {
		return tipoProductoService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<BankingProductType> findProductType(@PathVariable String id) {
		return tipoProductoService.finById(id);
	}

	@PostMapping
	public Mono<BankingProductType> saveProductType(@RequestBody BankingProductType productType) {
		return tipoProductoService.save(productType);
	}

	@PutMapping
	public Mono<BankingProductType> updateProductType(@RequestBody BankingProductType productType) {
		return tipoProductoService.save(productType);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteProductType(@PathVariable String id){
		return tipoProductoService.deleteById(id);
	}
}
