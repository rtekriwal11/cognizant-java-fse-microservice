package com.cts.app.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.cts.app.model.Trainee;
import com.cts.app.repository.TraineeRepo;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

	
	@Autowired
	private AmazonDynamoDB amazonDynamoDb;
	
	@Autowired
	private TraineeRepo repo;
	
	private DynamoDBMapper dbMapper;
	
	//this is written because this need to be executed once everytime
	//table is already created manually so commented below topics
	@PostConstruct
	public void init() {
//		dbMapper=new DynamoDBMapper(amazonDynamoDb);
//		CreateTableRequest createTableRequest=dbMapper.generateCreateTableRequest(Trainee.class);
//		createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		// amazonDynamoDb.createTable(createTableRequest);
	}
	
	
	@GetMapping
	public List<Trainee> getAllTrainees(){
		return (List<Trainee>)repo.findAll();
	}
	
	/*@GetMapping("/{traineeid}")
	public Trainee getTrainee(@PathVariable("traineeid") int id) {
		Optional<Trainee> op=repo.findById(id);
		Trainee d=null;
		if(op.isPresent()) {
			d=op.get();
			System.out.println(d);
		}
		else {
			System.out.println("Didnt get");
		}
		return d;
	}
	*/
	
	
}