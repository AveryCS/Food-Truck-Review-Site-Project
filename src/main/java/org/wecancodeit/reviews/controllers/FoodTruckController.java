package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.repos.FoodTruckRepository;
import org.wecancodeit.reviews.repos.ReviewRepository;

@Controller
public class FoodTruckController {
    private FoodTruckRepository foodTruckRepo;
    private ReviewRepository reviewRepo;

    public FoodTruckController(FoodTruckRepository foodTruckRepo, ReviewRepository reviewRepo) {
        this.foodTruckRepo = foodTruckRepo;
        this.reviewRepo = reviewRepo;
    }
    @RequestMapping("/FoodTruckTemplate/{foodTruckId}")
    public String showFoodTruckTemplate(Model model, @PathVariable long foodTruckId) {

        model.addAttribute("foodTruck", foodTruckRepo.findById(foodTruckId).get());
        String orderStr = "";
        if (foodTruckRepo.findById(foodTruckId).get().isOrderAhead() == true) {
            orderStr = "Available";
        }else {
            orderStr = "Not Available";
        }
        model.addAttribute("orderAhead", orderStr);
        return "FoodTruckTemplate";
    }

}
