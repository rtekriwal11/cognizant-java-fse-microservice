package com.cts.app.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@DynamoDBTable(tableName = "intcde021_trainee")
public class Trainee {

	
	private int traineeId;
	
	private String traineeName;
	
	private String email;
	
	@DynamoDBHashKey(attributeName = "trainee_id")
	public int getTraineeId() {
		return traineeId;
	}
	
	@DynamoDBAttribute(attributeName = "trainee_name")
	public String getTraineeName() {
		return traineeName;
	}
	
	@DynamoDBAttribute(attributeName = "email")
	public String getEmail() {
		return email;
	}
	
	
	
	
	
}