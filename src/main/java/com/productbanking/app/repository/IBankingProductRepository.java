package com.productbanking.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productbanking.app.models.BankingProduct;
@Repository
public interface IBankingProductRepository extends ReactiveMongoRepository<BankingProduct, String>{

}
