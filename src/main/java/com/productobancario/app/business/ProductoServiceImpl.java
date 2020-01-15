package com.productobancario.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productobancario.app.models.ProductoBancario;
import com.productobancario.app.repository.IProductoBancarioRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoBancarioRepository productoRepo;
	
	@Override
	public Flux<ProductoBancario> findAll() {
		return productoRepo.findAll();
	}

	@Override
	public Mono<ProductoBancario> finById(String id) {
		return productoRepo.findById(id);
	}

	@Override
	public Mono<ProductoBancario> save(ProductoBancario t) {
		return productoRepo.save(t);
	}

	@Override
	public Mono<Void> delete(ProductoBancario t) {
		return productoRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return productoRepo.deleteById(id);
	}
	
	
}