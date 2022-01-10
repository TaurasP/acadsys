package lt.tauras.acadsys;

import lt.tauras.acadsys.controller.StudentController;
import lt.tauras.acadsys.model.Group;
import lt.tauras.acadsys.model.Student;
import lt.tauras.acadsys.repository.GroupRepository;
import lt.tauras.acadsys.repository.StudentRepository;
import lt.tauras.acadsys.repository.UserRepository;
import lt.tauras.acadsys.service.StudentService;
import lt.tauras.acadsys.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class AcadsysApplication {

    public static void main(String[] args) {

        SpringApplication.run(AcadsysApplication.class, args);

    }
}
