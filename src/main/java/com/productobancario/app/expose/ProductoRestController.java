package com.productobancario.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productobancario.app.business.IProductoService;
import com.productobancario.app.models.ProductoBancario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {
	@Autowired
	private IProductoService productoService;

	@GetMapping
	public Flux<ProductoBancario> listarAllClientes() {
		return productoService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<ProductoBancario> buscarProducto(@PathVariable String id) {
		return productoService.finById(id);
	}

	@PostMapping
	public Mono<ProductoBancario> registrarProducto(@RequestBody ProductoBancario producto) {
		return productoService.save(producto);
	}

	@PutMapping
	public Mono<ProductoBancario> actualizarProducto(@RequestBody ProductoBancario producto) {
		return productoService.save(producto);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> eliminarProducto(@PathVariable String id){
		return productoService.deleteById(id);
	}
}
