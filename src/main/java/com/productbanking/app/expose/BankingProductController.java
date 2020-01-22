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

import com.productbanking.app.business.IBankingProductService;
import com.productbanking.app.models.BankingProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class BankingProductController {
	@Autowired
	private IBankingProductService productService;

	@GetMapping
	public Flux<BankingProduct> findAllProducts() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<BankingProduct> findProduct(@PathVariable String id) {
		return productService.finById(id);
	}

	@PostMapping
	public Mono<BankingProduct> saveProduct(@RequestBody BankingProduct producto) {
		return productService.save(producto);
	}

	@PutMapping
	public Mono<BankingProduct> updateProduct(@RequestBody BankingProduct producto) {
		return productService.save(producto);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteProduct(@PathVariable String id){
		return productService.deleteById(id);
	}
}
