package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//    @RequestMapping("/AllHashtagsTemplate")
//    public String showAllHashtagsTemplate(Model model){
//        model.addAttribute("hashtags", hashtagRepo.findAll());
//        return "AllHashtagsTemplate";
//    }
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
    public String addHashtag(@RequestParam String hashtag, @RequestParam Long foodTruckId) {
        FoodTruck theFoodTruck = foodTruckRepo.findById(foodTruckId).get();

        Optional<Hashtag> tempHashtag = hashtagRepo.findByHashtagIgnoreCase(hashtag);
        if(tempHashtag.isPresent()){
            if(!tempHashtag.get().containsFoodTruck(theFoodTruck)){
                tempHashtag.get().addFoodTruck(theFoodTruck);
                hashtagRepo.save(tempHashtag.get());
            }
        }
        else {
            Hashtag theHashtag = new Hashtag(hashtag, theFoodTruck);
            hashtagRepo.save(theHashtag);
        }
        return "redirect:/AllHashtagsTemplate";
    }


}