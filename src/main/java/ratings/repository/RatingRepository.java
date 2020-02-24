package ratings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ratings.models.Rating;

public interface RatingRepository extends JpaRepository<Rating , String> {
	
	@Query("SELECT r FROM Rating r WHERE LOWER(r.userId) = LOWER(:userId)")
    public List<Rating> findByUser(@Param("userId") String userId);
	
}