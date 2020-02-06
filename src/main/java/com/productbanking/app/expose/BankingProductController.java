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
import com.productbanking.app.models.ConsultaReporteDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(value = "Banking Product Microservice")
@RequestMapping("/products")
public class BankingProductController {
	@Autowired
	private IBankingProductService productService;

	@GetMapping
	@ApiOperation(value = "List all products", notes="Find all products, products contains product's type")
	public Flux<BankingProduct> findAllProducts() {
		return productService.findAll();
	}
	
	@GetMapping("/bank/{idBank}")
	@ApiOperation(value = "Find products", notes="Find all products by id Bank")
	public Flux<BankingProduct> findAllProductsByIdBank(@PathVariable String idBank) {
		return productService.buscarPorIdBanco(idBank);
	}
	
	@GetMapping("/code-bank/{codebank}")
	@ApiOperation(value = "Find products", notes="Find all products by id Bank")
	public Flux<BankingProduct> findAllProductsByIdBank(@PathVariable Integer codebank) {
		return productService.buscarPorCodigoBanco(codebank);
	}
	@GetMapping("/{id}")
	@ApiOperation(value = "Find a product", notes="Find product by id")
	public Mono<BankingProduct> findProduct(@PathVariable String id) {
		return productService.finById(id);
	}
	@PostMapping("/reporte-completo")
	@ApiOperation(value = "Generate full report", notes="This report needs a requestBody ConsultaReporteDTO: rango inicio, rango fin")
	public Flux<BankingProduct> reporteCompletoYGeneral(@RequestBody ConsultaReporteDTO dto) {
		return productService.reporteCompletoYGeneral(dto);
	}

	@PostMapping
	@ApiOperation(value = "Save a product", notes="Save and return a product, need bank and product type reference")
	public Mono<BankingProduct> saveProduct(@RequestBody BankingProduct producto) {
		return productService.save(producto);
	}

	@PutMapping
	@ApiOperation(value = "Update a product", notes="Update and return a product, need bank and product type reference")
	public Mono<BankingProduct> updateProduct(@RequestBody BankingProduct producto) {
		return productService.save(producto);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a product", notes="Delete a product by id")
	public Mono<Void> deleteProduct(@PathVariable String id){
		return productService.deleteById(id);
	}
}
