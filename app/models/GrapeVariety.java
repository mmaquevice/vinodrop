package models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class GrapeVariety {

	@GraphId
	public Long id;

	public String name;

	public GrapeVariety(String name) {
		super();
		this.name = name;
	}

}
