package com.test.model;

import java.util.List;
import java.util.Map;

public class Parameters {
	private double wtgGroupCapacity;
	private double tankCapacity;
	private double wellDepth;
	private double towerCraneNumber;
	private List<Map<String, Object>> estimatesLayers;
	private String surveyingAndMappingType;
	private String surveyType;
	private String costType;
	
	public double getWtgGroupCapacity() {
		return wtgGroupCapacity;
	}
	public void setWtgGroupCapacity(double wtgGroupCapacity) {
		this.wtgGroupCapacity = wtgGroupCapacity;
	}
	public double getTankCapacity() {
		return tankCapacity;
	}
	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}
	public double getWellDepth() {
		return wellDepth;
	}
	public void setWellDepth(double wellDepth) {
		this.wellDepth = wellDepth;
	}
	public double getTowerCraneNumber() {
		return towerCraneNumber;
	}
	public void setTowerCraneNumber(double towerCraneNumber) {
		this.towerCraneNumber = towerCraneNumber;
	}
	public String getSurveyingAndMappingType() {
		return surveyingAndMappingType;
	}
	public void setSurveyingAndMappingType(String surveyingAndMappingType) {
		this.surveyingAndMappingType = surveyingAndMappingType;
	}
	public String getSurveyType() {
		return surveyType;
	}
	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	
}
