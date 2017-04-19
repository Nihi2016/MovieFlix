package io.egen.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Imdb {

	@Id
	@GenericGenerator(name="customUUID", strategy = "uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;
	
	private double imdbRating;
    private int imdbVotes;
    private String imdbId;
   
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public int getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	
	@Override
	public String toString() {
		return "Imdb [imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes
				+ ", imdbId=" + imdbId + "]";
	}
}
