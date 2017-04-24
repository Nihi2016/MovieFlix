package io.egen.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Ratings {

	@Id
	@GenericGenerator(name="customUUID", strategy = "uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;
	
	private double avgRating;
	private double userRating;
	private int noOfRatings;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public double getUserRating() {
		return userRating;
	}
	public void setUserRating(double userRating) {
		this.userRating = userRating;
	}
	
	public int getNoOfRatings() {
		return noOfRatings;
	}
	public void setNoOfRatings(int noOfRatings) {
		this.noOfRatings = noOfRatings;
	}
	public void setAvgUserRating(double userRating){
		//noOfRatings +=1;
		
		avgRating = ((avgRating+userRating)/noOfRatings);
	}
	@Override
	public String toString() {
		return "Ratings [id=" + id + ", avgRating=" + avgRating
				+ ", userRating=" + userRating + ", noOfRatings=" + noOfRatings
				+ "]";
	}
	
}
