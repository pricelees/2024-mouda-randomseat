package mouda.randomseat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RandomseatApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomseatApplication.class, args);
	}

}
