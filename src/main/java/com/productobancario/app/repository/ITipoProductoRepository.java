package com.productobancario.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productobancario.app.models.TipoProducto;
@Repository
public interface ITipoProductoRepository extends ReactiveMongoRepository<TipoProducto, String>{

}
