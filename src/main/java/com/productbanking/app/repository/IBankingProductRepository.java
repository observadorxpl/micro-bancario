package com.productbanking.app.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productbanking.app.models.Bank;
import com.productbanking.app.models.BankingProduct;

import reactor.core.publisher.Flux;
@Repository
public interface IBankingProductRepository extends ReactiveMongoRepository<BankingProduct, String>{
	Flux<BankingProduct> findByBank(Bank bank);
	Flux<BankingProduct> findByBank_CodeBank(Integer codeBank);
	Flux<BankingProduct> findByCreateAtGreaterThanEqualAndCreateAtLessThanEqual(Date rangoInicio, Date rangoFin); 

}
