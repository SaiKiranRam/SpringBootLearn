package edu.user.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Technology")
public class Technology {

	@Id
	@Column(name = "tech_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	long techId;

	@Column(name = "technology")
	String technology;

	@Column(name = "role")
	String role;

	@Column(name = "experiance")
	int experiance;

	public Technology() {
	}
	
	public Technology(String technology, String role, int experiance ) {
		super();
		this.technology = technology;
		this.role = role;
		this.experiance = experiance;
	}

	public long getTechId() {
		return techId;
	}

	public void setTechId(long techId) {
		this.techId = techId;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String tecnology) {
		this.technology = tecnology;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getExperiance() {
		return experiance;
	}

	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}

}
