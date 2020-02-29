package ratings.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table ( name = "Rating" )
@IdClass(CompositeKey.class)
public class Rating {

	@Id
	@Column(name = "itemId", nullable = false) 
    private String itemId = "itemId";
	@Id
	@Column(name = "userId", nullable = false)
	private String userId = "NoUser";

	@Column(name = "rating", nullable = false,columnDefinition = "float default 0")
	@Min(value = 0, message = "Rating can't be less than 0")
	@Max(value = 10, message = "Rating can't be more than 10")
	private float rating;

	public Rating() {}
    
    public Rating(String itemId, int rating) {
        this.itemId = itemId;
        this.rating = rating;
    }
    
    public Rating(String itemId, String userId, float rating) {
		super();
		this.itemId = itemId;
		this.userId = userId;
		this.rating = rating;
	}

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemID) {
		this.itemId = itemID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
