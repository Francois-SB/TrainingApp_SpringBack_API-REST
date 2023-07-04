package fr.fms.service;

import fr.fms.entities.AppRole;
import fr.fms.entities.Training;
import fr.fms.entities.User;

import java.util.List;
import java.util.Optional;

public interface ITrainingService {
    public Optional<Training> getTraining(long id);
    public Training saveTraining(Training training);
    public List<Training> getAllTrainings();
    public void deleteTraining(long id);

}
