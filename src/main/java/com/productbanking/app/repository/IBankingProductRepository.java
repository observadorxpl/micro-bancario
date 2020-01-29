package com.productbanking.app.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.productbanking.app.models.Bank;
import com.productbanking.app.models.BankingProduct;

import reactor.core.publisher.Flux;
@Repository
public interface IBankingProductRepository extends ReactiveMongoRepository<BankingProduct, String>{
	Flux<BankingProduct> findByBank(Bank bank);
	
	@Query("{'createAt' : { $gte: ?0, $lte: ?1 } }")                 
	public Flux<BankingProduct> buscarPorRangoFechas(Date rangoInicio, Date rangoFin); 

}
