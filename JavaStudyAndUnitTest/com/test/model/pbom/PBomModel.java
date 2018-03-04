package com.test.model.pbom;

import java.util.List;

public class PBomModel {
	private String id;
    private String structureCode;
    private String name;
    private List<PBomMaterialCollection> materialsCollections;
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
	public List<PBomMaterialCollection> getMaterialsCollections() {
		return materialsCollections;
	}
	public void setMaterialsCollections(List<PBomMaterialCollection> materialsCollections) {
		this.materialsCollections = materialsCollections;
	}
    
}
