package edu.javaBrains.practice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Technology {

	@Id
	private int tId;
	private String techno;
	private int exp;
	private String specialization;
	
	public Technology() {
	}

	public Technology(int tId, String technology, int exp, String specialization) {
		super();
		this.tId = tId;
		techno = technology;
		this.exp = exp;
		this.specialization = specialization;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getTechno() {
		return techno;
	}

	public void setTechno(String techno) {
		this.techno = techno;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Technology [tId=" + tId + ", Technology= " + techno + ", exp=" + exp + ", specialization="
				+ specialization + "]";
	}
}
