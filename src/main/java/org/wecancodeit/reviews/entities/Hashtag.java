package org.wecancodeit.reviews.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue

    private long hashtagId;
    private String hashtag;

    @ManyToMany
    private Collection<FoodTruck> foodTrucks;

    public Hashtag(){

    }

    public Hashtag(String hashtag, FoodTruck...foodTrucks) {
        this.hashtag = hashtag;
        this.foodTrucks = Arrays.asList(foodTrucks);
    }
    public void addFoodTruck(FoodTruck foodTruck){
        foodTrucks.add(foodTruck);
    }
    public long getHashtagId() {
        return hashtagId;
    }

    public String getHashtag() {
        return hashtag;
    }

    public Collection<FoodTruck> getFoodTrucks() {
        return foodTrucks;
    }

    public boolean containsFoodTruck(FoodTruck foodTruck){
        return foodTrucks.contains(foodTruck);
    }
}