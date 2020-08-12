package com.qa.achord.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class chords {
	
	@Id  //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int chordId;

	@OneToOne
	private courses course;
	
	private String chordTitle;
	private String chordDescription;
	private String chordImg;
	
	
	public int getChordId() {
		return chordId;
	}
	public void setChordId(int chordId) {
		this.chordId = chordId;
	}

	public String getChordTitle() {
		return chordTitle;
	}
	public void setChordTitle(String chordTitle) {
		this.chordTitle = chordTitle;
	}
	public String getChordDescription() {
		return chordDescription;
	}
	public void setChordDescription(String chordDescription) {
		this.chordDescription = chordDescription;
	}
	public String getChordImg() {
		return chordImg;
	}
	public void setChordImg(String chordImg) {
		this.chordImg = chordImg;
	}
	
	

}
