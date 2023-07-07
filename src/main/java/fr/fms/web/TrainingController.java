package fr.fms.web;

import fr.fms.entities.Training;

import fr.fms.service.ITrainingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TrainingController {
@Autowired
private ITrainingServiceImpl iTrainingServiceImpl;

//getAll

@GetMapping("/trainings")
    public List<Training> allTrainings(){
    return iTrainingServiceImpl.getAllTrainings();
}
//delete
    @DeleteMapping("/trainings/{id}")
    public void deleteTraining(@PathVariable("id") Long id){
        iTrainingServiceImpl.deleteTraining(id);
    }

    //get by ID
    @GetMapping("/trainings/{id}")
    public ResponseEntity<Training> getTraining(@PathVariable("id") Long id){
    Optional<Training> training = iTrainingServiceImpl.getTraining(id);
    if(training.isPresent()) return new ResponseEntity<>(training.get(), HttpStatus.OK);
        return null;
    }

    //save
    @PostMapping("/trainings")
    public ResponseEntity<Training> saveTraining(@RequestBody Training t) {
        Training training = iTrainingServiceImpl.saveTraining(t);
        if (Objects.isNull(training)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(training.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

//    @GetMapping("/users?email={email}")
//    public ResponseEntity<Training> getUser(@PathVariable("email") String email){
//        Optional<User> user = iTrainingServiceImpl.getUserByEmail(email);
//        if(user.isPresent()) return new ResponseEntity<>(user.get(), HttpStatus.OK);
//        return null;
//    }
}
