package models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Region {

	@GraphId
	public Long id;
	
	public String name;

}
