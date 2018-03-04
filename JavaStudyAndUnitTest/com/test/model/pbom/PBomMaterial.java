package com.test.model.pbom;

public class PBomMaterial {
	private String materialGroupId;
    private String materialGroupName;
    private String materialId;
    private String materialName;
    private Double quantities;
    private Double price;
    private Integer unitId;
    
    
	public String getMaterialGroupId() {
		return materialGroupId;
	}
	public void setMaterialGroupId(String materialGroupId) {
		this.materialGroupId = materialGroupId;
	}
	public String getMaterialGroupName() {
		return materialGroupName;
	}
	public void setMaterialGroupName(String materialGroupName) {
		this.materialGroupName = materialGroupName;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public Double getQuantities() {
		return quantities;
	}
	public void setQuantities(Double quantities) {
		this.quantities = quantities;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
}
