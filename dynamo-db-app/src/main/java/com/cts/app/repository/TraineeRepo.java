package com.cts.app.repository;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.cts.app.model.Trainee;

@EnableScan
public interface TraineeRepo extends CrudRepository<Trainee, Integer>{
	
	Optional<Trainee> findByTraineeId(int traineeId);

}