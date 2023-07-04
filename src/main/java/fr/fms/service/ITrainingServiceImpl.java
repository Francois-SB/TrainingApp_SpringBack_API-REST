package fr.fms.service;

import fr.fms.dao.AppRoleRepository;
import fr.fms.dao.TrainingRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.AppRole;
import fr.fms.entities.Training;
import fr.fms.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ITrainingServiceImpl implements ITrainingService {
    @Autowired
    TrainingRepository trainingRepository;

    @Override
    public Optional<Training> getTraining(long id) {
        return trainingRepository.findById(id);
    }

    @Override
    public Training saveTraining(Training training) {
return trainingRepository.save(training);
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public void deleteTraining(long id) {
trainingRepository.deleteById(id);
    }

}
