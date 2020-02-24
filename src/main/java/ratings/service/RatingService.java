package ratings.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratings.models.Rating;
import ratings.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	public List<Rating> findAll() {
        List<Rating> ratings = new ArrayList<Rating>();
        ratingRepository.findAll().forEach(ratings::add);
        return ratings;
    }

	public Rating getRating(String itemId) {
		return ratingRepository.findById(itemId).orElse(null);
	}

	public Rating addRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	public String deleteRating(Rating rating) {
		ratingRepository.delete(rating);
		return (ratingRepository.findById(rating.getItemId()).orElse(null) == null )?"Item deleted":"Item NOT deleted";
	}

	public Long count() {
        return ratingRepository.count();
    }
	
	public List<Rating> findByUser(String userId) {
		return ratingRepository.findByUser(userId);
	}
	
}
