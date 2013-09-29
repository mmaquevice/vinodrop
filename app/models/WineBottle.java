package models;

import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class WineBottle {

	@GraphId
	public Long id;

	public String name;

	public int vintage;
	public int peak;
	public int keep;

	public float degree;
	public float capacity;

	public float price;

	@RelatedTo(type = "BELONGS_TO")
	public Appellation appellation;

	@RelatedTo(type = "PRODUCED_BY")
	public Producer producer;

	@RelatedToVia(type = "MADE_OF")
	public Set<GrapeVarietyRelation> grapeVarieties;

	public WineBottle() {
		super();
	}

	public WineBottle(String name, int vintage, int peak, int keep, float degree, float capacity, float price) {
		super();
		this.name = name;
		this.vintage = vintage;
		this.peak = peak;
		this.keep = keep;
		this.degree = degree;
		this.capacity = capacity;
		this.price = price;
	}

}
