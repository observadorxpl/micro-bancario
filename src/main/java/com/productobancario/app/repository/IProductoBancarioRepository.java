package com.productobancario.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productobancario.app.models.ProductoBancario;
@Repository
public interface IProductoBancarioRepository extends ReactiveMongoRepository<ProductoBancario, String>{

}
