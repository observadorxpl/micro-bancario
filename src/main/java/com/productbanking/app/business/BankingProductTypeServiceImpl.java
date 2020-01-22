package com.productbanking.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productbanking.app.models.BankingProductType;
import com.productbanking.app.repository.IBankingProductTypeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankingProductTypeServiceImpl implements IBankingProductTypeService {

	@Autowired
	private IBankingProductTypeRepository bankingProductTypeRepo;

	@Override
	public Flux<BankingProductType> findAll() {
		return bankingProductTypeRepo.findAll();
	}

	@Override
	public Mono<BankingProductType> finById(String id) {
		return bankingProductTypeRepo.findById(id);
	}

	@Override
	public Mono<BankingProductType> save(BankingProductType t) {
		return bankingProductTypeRepo.save(t);
	}

	@Override
	public Mono<Void> delete(BankingProductType t) {
		return bankingProductTypeRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return bankingProductTypeRepo.deleteById(id);
	}

}