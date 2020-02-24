package ratings.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "Rating" )
public class Rating {

	@Id
	@Column(name = "itemId",unique=true, nullable = false)
    private String itemId = "itemId";
	
	@Column(name = "userId", nullable = false)
	private String userId = "NoUser";

	@Column(name = "rating", nullable = false,columnDefinition = "float default 0")
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

	@Override
	public String toString() {
		return "Rating [itemId=" + itemId + ", userId=" + userId + ", rating=" + rating + "]";
	}
	
}
