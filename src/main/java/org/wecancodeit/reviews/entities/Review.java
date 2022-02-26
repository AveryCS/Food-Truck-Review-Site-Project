package org.wecancodeit.reviews.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue

    private long reviewId;
    private String review;
    private int starRating;

    @ManyToOne
    private FoodTruck foodTruck;

    public Review(String review, int starRating, FoodTruck foodTruck) {
        this.review = review;
        this.starRating = starRating;
        this.foodTruck = foodTruck;

    }

    public Review() {
    }

    public long getReviewId() {
        return reviewId;
    }

    public String getReview() {
        return review;
    }

    public int getStarRating() {
        return starRating;
    }



    public FoodTruck getFoodTruck() {
        return foodTruck;
    }
}





