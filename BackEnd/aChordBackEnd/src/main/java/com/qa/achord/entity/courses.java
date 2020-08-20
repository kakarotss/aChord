package com.qa.achord.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class courses {
	@Id  //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	private int courseLevel;
	private String courseImg;
	
	
	
	public courses() {
		
	}
	
	public courses(int courseId, String courseName, int courseLevel, String courseImg) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseLevel = courseLevel;
		this.courseImg = courseImg;
	}
	
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseLevel() {
		return courseLevel;
	}
	public void setCourseLevel(int courseLevel) {
		this.courseLevel = courseLevel;
	}
	public String getCourseImg() {
		return courseImg;
	}
	public void setCourseImg(String courseImg) {
		this.courseImg = courseImg;
	}
	
	
	

}
