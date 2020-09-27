package io.inspireinnovations.moviecataloguecervice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.inspireinnovations.moviecataloguecervice.models.CatlogueItem;
import io.inspireinnovations.moviecataloguecervice.models.UserRating;
import io.inspireinnovations.moviecataloguecervice.services.MovieInfo;
import io.inspireinnovations.moviecataloguecervice.services.UserRatingInfo;

@EnableEurekaClient
@EnableHystrixDashboard
@RestController
@RequestMapping("/catalogue")
public class MovieCatlogueResource {

	@Autowired
	MovieInfo movieInfo;

	@Autowired
	UserRatingInfo urInfo;

	@RequestMapping("/{userId}")
	public List<CatlogueItem> getCatlogue(@PathVariable("userId") String userId) {

		UserRating ratings = urInfo.getUserRating(userId);

		return ratings.getUserRating().stream().map(rating -> {
			return movieInfo.getCatlogueItem(rating);

//			**Using WebClient**
//			Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/" + rating.getMovie())
//					.retrieve().bodyToMono(Movie.class).block();
		}).collect(Collectors.toList());
	}

}
