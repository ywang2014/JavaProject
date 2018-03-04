package com.test.model.pbom;

import java.util.List;

public class PBomEquipment {
	private String id;
    private String name;
    private String structureCode;
    private String templateVersion;
    private List<PBomModel> models;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStructureCode() {
		return structureCode;
	}
	public void setStructureCode(String structureCode) {
		this.structureCode = structureCode;
	}
	public String getTemplateVersion() {
		return templateVersion;
	}
	public void setTemplateVersion(String templateVersion) {
		this.templateVersion = templateVersion;
	}
	public List<PBomModel> getModels() {
		return models;
	}
	public void setModels(List<PBomModel> models) {
		this.models = models;
	}
}
