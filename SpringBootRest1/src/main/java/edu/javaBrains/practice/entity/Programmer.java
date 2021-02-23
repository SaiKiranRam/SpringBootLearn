package edu.javaBrains.practice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Programmer {

	@Id
	private int id;
	private String first_name;
	private String last_name;
	
	@OneToMany(targetEntity = Technology.class, cascade = CascadeType.ALL/* , mappedBy = "prog" */)
	@JoinColumn(name = "prog_id", referencedColumnName = "id")
	List<Technology> technologies = new ArrayList<Technology>();

	public Programmer() {
	}

	public Programmer(int id, String first_name, String last_name/* , List<Technology> technologies */) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
//		this.technologies = technologies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "Programmer [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", technologies="
				+ technologies + "]";
	}
	
}
