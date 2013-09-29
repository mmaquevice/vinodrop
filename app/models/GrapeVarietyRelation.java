package models;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "MADE_OF")
public class GrapeVarietyRelation {

	@GraphId
	public Long id;

	public float percent;

	@Fetch
	@StartNode
	public WineBottle wineBottle;
	@Fetch
	@EndNode
	public GrapeVariety grapeVariety;

	public GrapeVarietyRelation(float percent, WineBottle wineBottle, GrapeVariety grapeVariety) {
		super();
		this.percent = percent;
		this.wineBottle = wineBottle;
		this.grapeVariety = grapeVariety;
	}

}
