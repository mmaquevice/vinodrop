package models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class SubRegion {

	@GraphId
	public Long id;

	@RelatedTo(type = "LOCATED_IN")
	public Region region;

}
