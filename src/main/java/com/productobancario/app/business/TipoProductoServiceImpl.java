package com.productobancario.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productobancario.app.models.TipoProducto;
import com.productobancario.app.repository.ITipoProductoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService {

	@Autowired
	private ITipoProductoRepository tipoProductoRepo;

	@Override
	public Flux<TipoProducto> findAll() {
		return tipoProductoRepo.findAll();
	}

	@Override
	public Mono<TipoProducto> finById(String id) {
		return tipoProductoRepo.findById(id);
	}

	@Override
	public Mono<TipoProducto> save(TipoProducto t) {
		return tipoProductoRepo.save(t);
	}

	@Override
	public Mono<Void> delete(TipoProducto t) {
		return tipoProductoRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return tipoProductoRepo.deleteById(id);
	}

}