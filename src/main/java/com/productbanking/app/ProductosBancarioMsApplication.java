package com.productbanking.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.productbanking.app.models.Bank;
import com.productbanking.app.models.BankingProduct;
import com.productbanking.app.models.BankingProductType;
import com.productbanking.app.repository.IBankingProductRepository;
import com.productbanking.app.repository.IBankingProductTypeRepository;

import reactor.core.publisher.Flux;
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class ProductosBancarioMsApplication implements CommandLineRunner{

	@Value("${com.bootcamp.gateway.url}")
	private String gatewayUrlPort;
	
	@Autowired
	private ReactiveMongoTemplate template;
	
	@Autowired
	private IBankingProductRepository productRepo;
	@Autowired
	private IBankingProductTypeRepository productTypeRepo;
	public static void main(String[] args) {
		SpringApplication.run(ProductosBancarioMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		template.dropCollection(BankingProduct.class).subscribe();
		template.dropCollection(BankingProductType.class).subscribe();
		// REGISTRO DE TIPO DE PRODUCTOS Y PRODUCTOS
		
		BankingProductType tipP1 = new BankingProductType("Cuentas Bancarias");
		Flux.just(tipP1).flatMap(tipP -> productTypeRepo.save(tipP)).subscribe();
		
		WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get()
		.uri("/code-bank/100").retrieve().bodyToMono(Bank.class).log().flatMap(bank -> {
			return productRepo.save(new BankingProduct("Cuenta Ahorro bancaria", 10, 5, tipP1, 0.05, 1, bank, new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta Corriente bancaria", 9, 3, tipP1, 0.25, 2, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta a Plazo Fijo bancaria", 8, 5, tipP1, 0.15, 3, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta ahorro personal VIP", 7, 5, tipP1, 0.04, 4, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta corriente personal VIP", 6, 2, tipP1, 0.03, 5, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Empresarial PYME", 11, 10, tipP1, 0.09, 6, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Empresarial Corporative", 4, 5, tipP1, 0.08, 7, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta plazo fijo VIP", 3, 1, tipP1, 0.075, 8, pro.getBank(), new Date()));
		}).subscribe();
		
		WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get()
		.uri("/code-bank/101").retrieve().bodyToMono(Bank.class).log().flatMap(bank -> {
			return productRepo.save(new BankingProduct("Cuenta Ahorro bancaria", 10, 5, tipP1, 0.05, 1, bank, new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta Corriente bancaria", 9, 3, tipP1, 0.25, 2, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta a Plazo Fijo bancaria", 8, 5, tipP1, 0.15, 3, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta ahorro personal VIP", 7, 5, tipP1, 0.04, 4, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta corriente personal VIP", 6, 2, tipP1, 0.03, 5, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Empresarial PYME", 11, 10, tipP1, 0.09, 6, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Empresarial Corporative", 4, 5, tipP1, 0.08, 7, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta plazo fijo VIP", 3, 1, tipP1, 0.075, 8, pro.getBank(), new Date()));
		}).subscribe();

		WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get()
		.uri("/code-bank/102").retrieve().bodyToMono(Bank.class).log().flatMap(bank -> {
			return productRepo.save(new BankingProduct("Cuenta Ahorro bancaria", 10, 5, tipP1, 0.05, 1, bank, new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta Corriente bancaria", 9, 3, tipP1, 0.25, 2, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta a Plazo Fijo bancaria", 8, 5, tipP1, 0.15, 3, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta ahorro personal VIP", 7, 5, tipP1, 0.04, 4, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta corriente personal VIP", 6, 2, tipP1, 0.03, 5, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Empresarial PYME", 11, 10, tipP1, 0.09, 6, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Empresarial Corporative", 4, 5, tipP1, 0.08, 7, pro.getBank(), new Date()));
		}).flatMap(pro -> {
			return productRepo
					.save(new BankingProduct("Cuenta plazo fijo VIP", 3, 1, tipP1, 0.075, 8, pro.getBank(), new Date()));
		}).subscribe();
		
		.thenMany(
				Flux.just(
						new BankingProduct("Cuenta Ahorro bancaria", 10, 5, tipP1, 0.05, 1),
						new BankingProduct("Cuenta Corriente bancaria", 9, 3, tipP1, 0.25, 2),
						new BankingProduct("Cuenta a Plazo Fijo bancaria", 8, 5, tipP1, 0.15, 3),
						new BankingProduct("Cuenta ahorro personal VIP", 7, 5, tipP1, 0.04, 4),
						new BankingProduct("Cuenta corriente personal VIP", 6, 2, tipP1, 0.03, 5),
						new BankingProduct("Empresarial PYME", 11, 10, tipP1, 0.09, 6),
						new BankingProduct("Empresarial Corporative", 4, 5, tipP1, 0.08, 7),
						new BankingProduct("Cuenta plazo fijo VIP", 3, 1, tipP1, 0.075, 8)
						)
				).flatMap(pro -> productRepo.save(pro))
		.subscribe(res -> System.out.println("Producto".concat(res.toString().concat(" " + "Registrado"))));
		*/
	}

}
