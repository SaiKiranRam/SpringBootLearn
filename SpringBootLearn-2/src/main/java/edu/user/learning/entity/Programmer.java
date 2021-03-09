package edu.user.learning.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Programmer")
public class Programmer {

	@Id
	@Column(name = "prog_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "first_name")
	private String firstName ;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToMany(targetEntity = Technology.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "prog_Id", referencedColumnName = "prog_Id")
	private List<Technology> technologies = new ArrayList<Technology>();

	public Programmer() {
	}

	public Programmer(String firstName, String lastName, List<Technology> technologies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.technologies = technologies;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		
		this.getTechnologies().clear();
		this.technologies.addAll(technologies);
	}

	@Override
	public String toString() {
		return "Programmer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", technologies="
				+ technologies + "]";
	}
}
