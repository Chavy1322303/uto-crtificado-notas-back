package bo.edu.uto.dtic.certificadonotas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("bo.edu.uto.dtic.certificadonotas.mappers")
public class CertificadoNotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CertificadoNotasApplication.class, args);
	}

}
