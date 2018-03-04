package com.test;

import java.util.Objects;

import com.test.model.pbom.PBom;
import com.test.model.pbom.PBomEquipment;

public class EstimatesTest {
	
	public static void main(String[] args) {
		EstimatesTest obj = new EstimatesTest();
		System.out.println("Hello word");
	}
	
	protected PBom createPBom() {
		PBom unit = new PBom();
		PBomEquipment equipment = new PBomEquipment();
		
		return unit;
	}
	
	public Double calculateUnitProjectTotalPrice(PBom unitPbom){
        return unitPbom.getEquipments().stream().
                filter(x -> Objects.nonNull(x.getModels()) && !x.getModels().isEmpty()).
                flatMap(y -> y.getModels().stream().
                filter(z -> Objects.nonNull(z.getMaterialsCollections()) && !z.getMaterialsCollections().isEmpty()).
                flatMap(k -> k.getMaterialsCollections().stream().
                filter(m -> Objects.nonNull(m.getMaterials()) && !m.getMaterials().isEmpty()).
                flatMap(n -> n.getMaterials().stream().
                filter(t -> Objects.nonNull(t.getPrice()) && Objects.nonNull(t.getQuantities()))))).
                mapToDouble(m -> m.getPrice() * m.getQuantities()).sum();
    }
	
}
