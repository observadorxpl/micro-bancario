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
				Flux.just(new ProductoBancario("Ahorro", tipP1, 1, "Ahorro"),
						new ProductoBancario("Cuenta Corriente", tipP1, 2, "Cuentas Corrientes"),
						new ProductoBancario("Cuenta a Plazo Fijo", tipP1,3, "Cuenta a Plazo Fijo")
						)
				).flatMap(pro -> productoRepo.save(pro))
		.subscribe(res -> System.out.println("Producto".concat(res.toString().concat(" " + "Registrado"))));
	}

}
