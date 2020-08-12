package com.qa.achord.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class courseLine {
	@Id  //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseLineId;
	
	@OneToOne
	private courses course;

	private String courseStatus;
	
	@OneToOne
	private users user;
	
	
	public int getCourseLineId() {
		return courseLineId;
	}
	public void setCourseLineId(int courseLineId) {
		this.courseLineId = courseLineId;
	}

	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	
	
	
}
