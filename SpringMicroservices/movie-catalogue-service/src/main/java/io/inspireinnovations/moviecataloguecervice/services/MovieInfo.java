package io.inspireinnovations.moviecataloguecervice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.inspireinnovations.moviecataloguecervice.models.CatlogueItem;
import io.inspireinnovations.moviecataloguecervice.models.Movie;
import io.inspireinnovations.moviecataloguecervice.models.Rating;

@Service
public class MovieInfo {

	@Autowired
	private RestTemplate rtemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatlogueItem")
	public CatlogueItem getCatlogueItem(Rating rating) {
		Movie movie = rtemplate.getForObject("http://movie-info-service/movies/" + rating.getMovie(), Movie.class);
		return new CatlogueItem(movie.getMovieId(), movie.getName(), rating.getRating());
	}

	public CatlogueItem getFallbackCatlogueItem(Rating rating) {
		return new CatlogueItem("0", "Movie Name not found", rating.getRating());
	}
}
