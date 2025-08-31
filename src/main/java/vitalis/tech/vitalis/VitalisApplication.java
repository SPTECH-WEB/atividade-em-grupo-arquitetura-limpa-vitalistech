package vitalis.tech.vitalis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("vitalis.tech.vitalis.infrastructure.persistence.jpa")
@EnableJpaRepositories("vitalis.tech.vitalis.infrastructure.persistence.jpa")
public class VitalisApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalisApplication.class, args);
	}

}