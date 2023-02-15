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
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

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

    /*
     * This method takes a user's hashtag and food truck and first checks to see if the hashtag is valid.
     * If the hashtag is not valid, it shows the user an error message.
     * If the hashtag is valid, it will then check to see if it already exists. If it does exist, it will link the
     * user's food truck to the existing hashtag.
     * If the hashtag does not exist, it will create a new hashtag and save it in the hashtag repo.
     * */
    @PostMapping("/SubmitHashtag")
    public String addHashtag(@RequestParam String userInputHashtag, @RequestParam Long foodTruckId) {
        if (!isValidHashtag(userInputHashtag)) {
            return "InvalidHashtagTemplate";
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

    private boolean isValidHashtag(String userInputHashtag) {
        String regexVerifyHashtag = "[#]{1}+[A-Za-z0-9]{1,25}";
        Pattern pattern = Pattern.compile(regexVerifyHashtag);
        Matcher matcher = pattern.matcher(userInputHashtag);
        return  matcher.matches() ;
    }

}