package io.inspireinnovations.ratingdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.inspireinnovations.ratingdataservice.models.Rating;
import io.inspireinnovations.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingData")
public class RatingDataResource {
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId, "5");
	}

	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("Avengers", "5"), new Rating("Age of Ultron", "5"),
				new Rating("Infinity War", "5"), new Rating("End Game", "5"));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
}
