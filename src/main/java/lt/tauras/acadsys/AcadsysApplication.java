package lt.tauras.acadsys;

import lt.tauras.acadsys.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class AcadsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcadsysApplication.class, args);
    }
}
