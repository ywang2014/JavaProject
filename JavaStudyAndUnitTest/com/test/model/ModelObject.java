package com.test.model;

public class ModelObject {
	private Integer objectId;
	private String objectName;
	private Double score;
	private Double salary;
	
	public ModelObject() {
		// default constructor
	}
	
	public ModelObject(Integer objectId, String objectName, Double score, Double salary) {
		this.objectId = objectId;
		this.objectName = objectName;
		this.score = score;
		this.salary = salary;
	}
	
	
	public Integer getObjectId() {
		return objectId;
	}
	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
