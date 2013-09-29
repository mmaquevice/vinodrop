package models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Appellation {

	@GraphId
	public Long id;

	public String name;

	@RelatedTo(type = "LOCATED_IN")
	public SubRegion subRegion;

	@RelatedTo(type = "LOCATED_IN")
	public Region region;

	public Appellation(String name) {
		super();
		this.name = name;
	}

}
