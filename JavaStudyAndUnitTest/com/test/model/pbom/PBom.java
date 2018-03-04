package com.test.model.pbom;

import java.util.List;

public class PBom {
    private String id;
    private String structureCode;
    private String name;
    private String templateVersion;
    private PriceParam priceParam;
    private List<PBomEquipment> equipments;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStructureCode() {
		return structureCode;
	}
	public void setStructureCode(String structureCode) {
		this.structureCode = structureCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTemplateVersion() {
		return templateVersion;
	}
	public void setTemplateVersion(String templateVersion) {
		this.templateVersion = templateVersion;
	}
	public PriceParam getPriceParam() {
		return priceParam;
	}
	public void setPriceParam(PriceParam priceParam) {
		this.priceParam = priceParam;
	}
	public List<PBomEquipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<PBomEquipment> equipments) {
		this.equipments = equipments;
	}
    
    
}
