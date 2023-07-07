package fr.fms;

import fr.fms.dao.AppRoleRepository;
import fr.fms.dao.TrainingRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.AppRole;
import fr.fms.entities.Training;
import fr.fms.entities.User;
import fr.fms.service.AccountServiceImpl;
import fr.fms.service.ITrainingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Arrays;
@CrossOrigin(origins = "*")
@SpringBootApplication
public class ScrumRabbitApplication implements CommandLineRunner {
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder(){return new BCryptPasswordEncoder();}
	@Autowired
	private TrainingRepository trainingRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	AppRoleRepository appRoleRepository;

	@Autowired
	AccountServiceImpl accountService;

	public static void main(String[] args) {
		SpringApplication.run(ScrumRabbitApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		generateDatas();
//		generateRoles();
//		generateUsers();
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}
	private void generateRoles() {
		accountService.saveAppRole(new AppRole(null,"ADMIN"));
		accountService.saveAppRole(new AppRole(null,"USER"));
	}

	private void generateUsers() {
		AppRole admin = accountService.getAppRoleByRolename("ADMIN");
		AppRole user = accountService.getAppRoleByRolename("USER");

		accountService.saveUser(new User( null, "admin@gmail.com","12345",new ArrayList<>(Arrays.asList(user,admin))));
		accountService.saveUser(new User( null, "pierre@gmail.com","12345", new ArrayList<>(Arrays.asList(user))));
	}

	public void generateDatas(){
		trainingRepository.save(new Training(null, "Java", "i",3,3));
	trainingRepository.save(new Training(null, "2", "i",3,3));
	trainingRepository.save(new Training(null, "3", "i",3,3));
	trainingRepository.save(new Training(null, "4", "i",3,3));
	trainingRepository.save(new Training(null, "5", "i",3,3));
	trainingRepository.save(new Training(null, "6", "i",3,3));
	trainingRepository.save(new Training(null, "7", "i",3,3));
	trainingRepository.save(new Training(null, "8", "i",3,3));
	trainingRepository.save(new Training(null, "9", "i",3,3));
	trainingRepository.save(new Training(null, "10", "i",3,3));

}

}
