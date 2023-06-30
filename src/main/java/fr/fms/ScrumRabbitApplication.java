package fr.fms;

import fr.fms.dao.TrainingRepository;
import fr.fms.entities.Training;
import fr.fms.service.ITrainingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrumRabbitApplication implements CommandLineRunner {
	@Autowired
	private TrainingRepository trainingRepository;
	public static void main(String[] args) {
		SpringApplication.run(ScrumRabbitApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		generateDatas();
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
