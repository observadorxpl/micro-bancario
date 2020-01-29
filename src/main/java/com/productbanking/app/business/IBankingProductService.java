package com.productbanking.app.business;
import com.productbanking.app.models.BankingProduct;
import com.productbanking.app.models.ConsultaReporteDTO;
import com.productbanking.app.util.ICRUD;

import reactor.core.publisher.Flux;

public interface IBankingProductService extends ICRUD<BankingProduct>{
	Flux<BankingProduct> buscarPorCodigoBanco(String idBank);
	Flux<BankingProduct> reporteCompletoYGeneral(ConsultaReporteDTO dto);

}
