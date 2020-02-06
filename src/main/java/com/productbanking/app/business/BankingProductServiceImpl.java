package com.productbanking.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.productbanking.app.models.Bank;
import com.productbanking.app.models.BankingProduct;
import com.productbanking.app.models.ConsultaReporteDTO;
import com.productbanking.app.repository.IBankingProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankingProductServiceImpl implements IBankingProductService {

	@Value("${com.bootcamp.gateway.url}")
	private String gatewayUrlPort;

	@Autowired
	private IBankingProductRepository bankingProductRepo;

	@Override
	public Flux<BankingProduct> findAll() {
		return bankingProductRepo.findAll();
	}

	@Override
	public Mono<BankingProduct> finById(String id) {
		return bankingProductRepo.findById(id);
	}

	@Override
	public Mono<BankingProduct> save(BankingProduct t) {
		return bankingProductRepo.save(t);
	}

	@Override
	public Mono<Void> delete(BankingProduct t) {
		return bankingProductRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return bankingProductRepo.deleteById(id);
	}

	@Override
	public Flux<BankingProduct> buscarPorIdBanco(String idBank) {
		return WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get().uri(idBank)
				.retrieve().bodyToMono(Bank.class).log().flatMapMany(bank -> {
					return bankingProductRepo.findByBank(bank);
				});
	}

	@Override
	public Flux<BankingProduct> reporteCompletoYGeneral(ConsultaReporteDTO dto) {
		System.out.println("[DTO reporte]: "+ dto);
		return bankingProductRepo.buscarPorRangoFechas(dto.getRangoInicio(), dto.getRangoFin());
	}


	@Override
	public Flux<BankingProduct> buscarPorCodigoBanco(Integer codeBank) {
		return bankingProductRepo.buscarPorCodigoBanco(codeBank);
	}
}