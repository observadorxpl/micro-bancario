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

import com.productobancario.app.business.ITipoProductoService;
import com.productobancario.app.models.TipoProducto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tipoProductos")
public class TipoProductoRestController {
	@Autowired
	private ITipoProductoService tipoProductoService;

	@GetMapping
	public Flux<TipoProducto> listarAllClientes() {
		return tipoProductoService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<TipoProducto> buscarCliente(@PathVariable String id) {
		return tipoProductoService.finById(id);
	}

	@PostMapping
	public Mono<TipoProducto> registrarCliente(@RequestBody TipoProducto tipoProducto) {
		return tipoProductoService.save(tipoProducto);
	}

	@PutMapping
	public Mono<TipoProducto> actualizarCliente(@RequestBody TipoProducto tipoProducto) {
		return tipoProductoService.save(tipoProducto);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> eliminarCliente(@PathVariable String id){
		return tipoProductoService.deleteById(id);
	}
}
