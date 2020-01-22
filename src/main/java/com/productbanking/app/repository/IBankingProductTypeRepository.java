package com.productbanking.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productbanking.app.models.BankingProductType;
@Repository
public interface IBankingProductTypeRepository extends ReactiveMongoRepository<BankingProductType, String>{

}
