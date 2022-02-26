package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.entities.FoodTruck;
import org.wecancodeit.reviews.entities.Hashtag;
import org.wecancodeit.reviews.entities.Review;
import org.wecancodeit.reviews.repos.FoodTruckRepository;
import org.wecancodeit.reviews.repos.ReviewRepository;

@Controller
public class ReviewController {

    private ReviewRepository reviewRepo;
    private FoodTruckRepository foodTruckRepo;

    public ReviewController(ReviewRepository reviewRepo, FoodTruckRepository foodTruckRepo) {
        this.reviewRepo = reviewRepo;
        this.foodTruckRepo = foodTruckRepo;
    }


    @PostMapping("/FoodTruckTemplate/{foodTruckId}")
    public String showSubmitReviewTemplate( @PathVariable long foodTruckId, @RequestParam String review, @RequestParam int starRating){

        FoodTruck theFoodTruck = foodTruckRepo.findById(foodTruckId).get();
        Review theReview = new Review(review, starRating, theFoodTruck);
        reviewRepo.save(theReview);
        float sum =5;
        for(Review currentReview:theFoodTruck.getReviews()){
            sum += currentReview.getStarRating();
        }
        theFoodTruck.setAverageRating(Math.round(sum/(theFoodTruck.getReviews().size()+1)));
        foodTruckRepo.save(theFoodTruck);


        return "redirect:/FoodTruckTemplate/" + foodTruckId;
    }
}
