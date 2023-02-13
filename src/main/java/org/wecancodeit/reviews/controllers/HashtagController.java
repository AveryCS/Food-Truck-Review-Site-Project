package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.entities.FoodTruck;
import org.wecancodeit.reviews.entities.Hashtag;
import org.wecancodeit.reviews.repos.FoodTruckRepository;
import org.wecancodeit.reviews.repos.HashtagRepository;

import java.util.Optional;

@Controller
public class HashtagController {
    private HashtagRepository hashtagRepo;
    private FoodTruckRepository foodTruckRepo;

    public HashtagController(HashtagRepository hashtagRepo, FoodTruckRepository foodTruckRepo) {
        this.hashtagRepo = hashtagRepo;
        this.foodTruckRepo = foodTruckRepo;
    }

    @RequestMapping("/AllHashtagsTemplate")
    public String showAllHashtagTemplate(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "AllHashtagsTemplate";
    }

    @RequestMapping("/SingleHashtagViewTemplate/{hashtagId}")
    public String showFoodTruckTemplate(Model model, @PathVariable long hashtagId) {
        model.addAttribute("hashtag", hashtagRepo.findById(hashtagId).get());
        model.addAttribute("hashtagName", hashtagRepo.findById(hashtagId).get().getHashtag());
        return "SingleHashtagViewTemplate";
    }

    @PostMapping("/SubmitHashtag")
    public String addHashtag(@RequestParam String userInputHashtag, @RequestParam Long foodTruckId) {
        if(!isValidHashtag(userInputHashtag)){
            throw new IllegalArgumentException("Hashtags must begin with a # sign and be less than 20 characters ");
        }

        FoodTruck foodTruck = foodTruckRepo.findById(foodTruckId).get();
        Optional<Hashtag> hashtag = hashtagRepo.findByHashtagIgnoreCase(userInputHashtag);
        if (hashtag.isPresent() && !hashtagIsLinkedToFoodTruck(hashtag.get(), foodTruck)) {
            linkFoodTruckToHashtag(hashtag.get(), foodTruck);
        } else {
            createNewHashtag(userInputHashtag, foodTruck);
        }
        return "redirect:/AllHashtagsTemplate";
    }

    private boolean hashtagIsLinkedToFoodTruck(Hashtag tempHashtag, FoodTruck foodTruck) {
        return tempHashtag.containsFoodTruck(foodTruck);
    }

    private void linkFoodTruckToHashtag(Hashtag tempHashtag, FoodTruck foodTruck) {
        tempHashtag.addFoodTruck(foodTruck);
        hashtagRepo.save(tempHashtag);
    }

    private void createNewHashtag(String userInputHashtag, FoodTruck foodTruck) {
        Hashtag hashtag = new Hashtag(userInputHashtag, foodTruck);
        hashtagRepo.save(hashtag);
    }

    private boolean isValidHashtag(String userInputHashtag){

        int count = StringUtils.countOccurrencesOf(userInputHashtag, "#");
               return count ==1 &&  userInputHashtag.charAt(0) =='#' && userInputHashtag.length() <20;

//
    }

}