package io.inspireinnovations.moviecataloguecervice.models;

public class CatlogueItem {

	private String name;
	private String movieId;
	private String rating;

	public CatlogueItem() {
	}

	public CatlogueItem(String name, String movieId, String rating) {
		super();
		this.name = name;
		this.movieId = movieId;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}
