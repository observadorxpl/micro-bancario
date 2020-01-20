package com.productobancario.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.productobancario.app.models.ProductoBancario;
import com.productobancario.app.models.TipoProducto;
import com.productobancario.app.repository.IProductoBancarioRepository;
import com.productobancario.app.repository.ITipoProductoRepository;

import reactor.core.publisher.Flux;
@EnableEurekaClient
@SpringBootApplication
public class ProductosBancarioMsApplication implements CommandLineRunner{
	@Autowired
	private ReactiveMongoTemplate template;
	
	@Autowired
	private IProductoBancarioRepository productoRepo;
	@Autowired
	private ITipoProductoRepository tipoProductoRepo;
	public static void main(String[] args) {
		SpringApplication.run(ProductosBancarioMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.dropCollection(ProductoBancario.class).subscribe();
		template.dropCollection(TipoProducto.class).subscribe();
		// REGISTRO DE TIPO DE PRODUCTOS Y PRODUCTOS
		
		TipoProducto tipP1 = new TipoProducto("Cuentas Bancarias");
		Flux.just(tipP1)
		.flatMap(tipP -> tipoProductoRepo.save(tipP))
		.thenMany(
				Flux.just(
						new ProductoBancario("Cuenta Ahorro bancaria", 10, 5, tipP1, 0.05, 1),
						new ProductoBancario("Cuenta Corriente bancaria", 9, 3, tipP1, 0.25, 2),
						new ProductoBancario("Cuenta a Plazo Fijo bancaria", 8, 5, tipP1, 0.15, 3),
						new ProductoBancario("Cuenta ahorro personal VIP", 7, 5, tipP1, 0.04, 4),
						new ProductoBancario("Cuenta corriente personal VIP", 6, 2, tipP1, 0.03, 5),
						new ProductoBancario("Empresarial PYME", 11, 10, tipP1, 0.09, 6),
						new ProductoBancario("Empresarial Corporative", 4, 5, tipP1, 0.08, 7),
						new ProductoBancario("Cuenta plazo fijo VIP", 3, 1, tipP1, 0.075, 8)
						)
				).flatMap(pro -> productoRepo.save(pro))
		.subscribe(res -> System.out.println("Producto".concat(res.toString().concat(" " + "Registrado"))));
	}

}
