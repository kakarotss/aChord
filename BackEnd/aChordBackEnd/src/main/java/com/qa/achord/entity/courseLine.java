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
	
	private int courseId;
	
	private int userId;

	private String courseStatus = "undone";
	
	
	public courseLine() {
		
	}
	
	
	public courseLine(int courseLineId, int courseId, int userId, String courseStatus) {
		super();
		this.courseLineId = courseLineId;
		this.courseId = courseId;
		this.userId = userId;
		this.courseStatus = courseStatus;
	}
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
}
