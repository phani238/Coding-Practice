package io.inspireinnovations.moviecataloguecervice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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
	private RestTemplate rtemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	private DiscoveryClient discoveryClient;

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
