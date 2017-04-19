package io.egen.movieflix.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class MovieAndTV {

	@Id
	@GenericGenerator(name="customUUID", strategy = "uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;
	private String title;
    private int year;
    private String rated;
    private LocalDate released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot; 
    private String language;
    private String country;
    private String  awards;
    private String poster;
    private int metaScore;
    private String type;
    @OneToOne
    private Imdb imdb;
    @OneToOne
    private Ratings rating;
    @OneToMany
    private List<Comments> comments;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public LocalDate getReleased() {
		return released;
	}
	public void setReleased(LocalDate released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Imdb getImdb() {
		return imdb;
	}
	public void setImdb(Imdb imdb) {
		this.imdb = imdb;
	}
	public Ratings getRating() {
		return rating;
	}
	public void setRating(Ratings rating) {
		this.rating = rating;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "MovieAndTV [id=" + id + ", title=" + title + ", year=" + year
				+ ", rated=" + rated + ", released=" + released + ", runtime="
				+ runtime + ", genre=" + genre + ", director=" + director
				+ ", writer=" + writer + ", actors=" + actors + ", plot="
				+ plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metaScore="
				+ metaScore + ", type=" + type + ", imdb=" + imdb + ", rating="
				+ rating + ", comments=" + comments + "]";
	}



}
