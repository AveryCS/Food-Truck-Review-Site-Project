package org.wecancodeit.reviews.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class FoodTruck {
    @Id
    @GeneratedValue

    private long foodTruckId;
    private String name;
    private String website;
    private boolean orderAhead;
    private String truckImage;
    private int averageRating;


    @OneToMany (mappedBy = "foodTruck")
    private Collection<Review> reviews;

    @ManyToMany (mappedBy = "foodTrucks")
    private Collection<Category> categories;

    @ManyToMany (mappedBy = "foodTrucks")
    private Collection<Hashtag> hashtags;

    public FoodTruck(String name, String website, boolean orderAhead, String truckImage, int averageRating) {
        this.name = name;
        this.website = website;
        this.orderAhead = orderAhead;
        this.truckImage = truckImage;
        this.averageRating = averageRating;
    }

    private FoodTruck(){
    }

    public long getFoodTruckId() {
        return foodTruckId;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public boolean isOrderAhead() {
        return orderAhead;
    }

    public String getTruckImage() {
        return truckImage;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public int getAverageRating(){
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }
}

