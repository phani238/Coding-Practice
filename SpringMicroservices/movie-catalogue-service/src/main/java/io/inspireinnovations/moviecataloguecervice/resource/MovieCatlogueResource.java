package io.inspireinnovations.moviecataloguecervice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.inspireinnovations.moviecataloguecervice.models.CatlogueItem;
import io.inspireinnovations.moviecataloguecervice.models.Movie;
import io.inspireinnovations.moviecataloguecervice.models.UserRating;

@RestController
@RequestMapping("/catalogue")
public class MovieCatlogueResource {

	@Autowired
	private RestTemplate rtemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/{userId}")
	public List<CatlogueItem> getCatlogue(@PathVariable String userId) {

		UserRating ratings = rtemplate.getForObject("http://rating-data-service/ratingData/users/" + userId,
				UserRating.class);

		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = rtemplate.getForObject("http://movie-info-service/movies/" + rating.getMovie(), Movie.class);

//			**Using WebClient**
//			Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/" + rating.getMovie())
//					.retrieve().bodyToMono(Movie.class).block();

			return new CatlogueItem(movie.getMovieId(), movie.getName(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
