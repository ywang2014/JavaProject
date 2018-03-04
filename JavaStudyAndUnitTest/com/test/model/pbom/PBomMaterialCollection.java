package com.test.model.pbom;

import java.util.List;

public class PBomMaterialCollection {
	private String id;
    private String structureCode;
    private String name;
    private List<PBomMaterial> materials;
    
    
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
	public List<PBomMaterial> getMaterials() {
		return materials;
	}
	public void setMaterials(List<PBomMaterial> materials) {
		this.materials = materials;
	}
    
}
