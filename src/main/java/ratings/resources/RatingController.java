package ratings.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ratings.models.Rating;
import ratings.service.RatingService;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@RestController
@RequestMapping("/")
public class RatingController {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	private RatingService ratings;

	@GetMapping("/")
	public String Home() {
		if(!apiKey.toString().equals("Ratings-data-service") )
			  System.out.println("Unuccessfully read your api key..." + apiKey.toString()  );
		
		String s = "Go to \"/ratings\" url and make a: \n\n"
				+ "GET to see all the ratings.\n\n"
				+ "POST with Rating in the body to create/update a rating, "
				+ "for example: \n{\n \"itemId\":\"100\",\n \"rating\": 5\n} "	
				+ "\nfor more info see the api at: \"/swagger-ui.html\"  " ;
		return s;
	}
	
	@GetMapping("/ratings")
	@ApiOperation( value = "List of all the items and their ratings", 
	notes = "Find all the items and their ratings", response = Rating.class)
	public List<Rating> getAllItems() {
		if(apiKey.toString().equals("Ratings-data-service") )
  		  System.out.println("GET, successfully read your api key..." + apiKey.toString()  );
		return ratings.findAll();
	}
	
	@PostMapping("/ratings")
	@ApiOperation( value = "Add a rating", 
	notes = "Add a rating to the list", response = Rating.class)
	public Rating addRating(@RequestBody Rating rating) {
		if(apiKey.toString().equals("Ratings-data-service") )
  		  System.out.println("POST, successfully read your api key..." + apiKey.toString()  );
		return ratings.addRating(rating); 
	}
	
	@DeleteMapping("/ratings")
	@ApiOperation(value = "Delete a rating", 
	notes = "Delete a rating fron the list", response = Rating.class)
	public void deleteRating(@RequestBody Rating rating) {
		if(apiKey.toString().equals("Ratings-data-service") )
			System.out.println("DELETE, "+rating +" successfully read your api key..." + apiKey.toString()  );
		
		ratings.deleteRating(rating); 
	}

	@GetMapping("/ratings/{itemId}")
	@ApiOperation( value = "item and rating by the item id", 
	notes = "Find the item and rating by the item id", response = Rating.class)
	public Rating getRating(@PathVariable("itemId") String itemId) {
		if(apiKey.toString().equals("Ratings-data-service") )
  		  System.out.println("GET, successfully read your api key..." + apiKey.toString()  );
		
		return ratings.getRating(itemId);
	}
	
	@GetMapping("/ratings/user/{userId}")
	    public List<Rating> getUserRatings(@PathVariable("userId") String userId) {
		return ratings.findByUser(userId);
	}
	
	@PostMapping("/ratings/user/{userId}")
    public Rating getUserRatings(@PathVariable("userId") String userId,@RequestBody Rating rating) {
		List<Rating> userRatings = ratings.findByUser(userId);
		Rating newRating = userRatings.stream()
			.filter(r -> r.getItemId() == rating.getItemId() ).findAny().orElse(null);
		newRating = rating;
		return ratings.addRating(newRating); 
	}
	
}
