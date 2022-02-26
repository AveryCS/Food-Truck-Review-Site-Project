package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.entities.Category;
import org.wecancodeit.reviews.entities.FoodTruck;
import org.wecancodeit.reviews.entities.Hashtag;
import org.wecancodeit.reviews.entities.Review;
import org.wecancodeit.reviews.repos.CategoryRepository;
import org.wecancodeit.reviews.repos.FoodTruckRepository;
import org.wecancodeit.reviews.repos.HashtagRepository;
import org.wecancodeit.reviews.repos.ReviewRepository;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    FoodTruckRepository foodTruckRepo;
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    ReviewRepository reviewRepo;
    @Autowired
    HashtagRepository hashtagRepo;
    @Override
    public void run(String... args) throws Exception {
        FoodTruck foodTruck1 = new FoodTruck("Dos Hermanos", "https://doshermanoscolumbus.com/",true,"/img/dosHermanosName.jpg", 5);
        foodTruckRepo.save(foodTruck1);
        FoodTruck foodTruck2 = new FoodTruck("Schmidt's","https://www.schmidthaus.com/sausage-truck/", false, "/img/schmidtsName.jpg", 5);
        foodTruckRepo.save(foodTruck2);
        FoodTruck foodTruck3 = new FoodTruck("Chicken And Tea", "https://www.facebook.com/chickenandtea", true, "/img/chickenAndTeaName.jpg", 5);
        foodTruckRepo.save(foodTruck3);
        FoodTruck foodTruck4 = new FoodTruck("Cousins Maine Lobster", "https://www.cousinsmainelobster.com/", false, "/img/cousinsMaineLobsterName.jpg", 5);
        foodTruckRepo.save(foodTruck4);
        FoodTruck foodTruck5 = new FoodTruck("Pitabilities", "https://www.pitabilities.com/", true, "/img/pitabilitiesName.jpg", 5);
        foodTruckRepo.save(foodTruck5);
        FoodTruck foodTruck6 = new FoodTruck("Zapata’s Foot Truck", "https://www.facebook.com/Zapatasstreetfood/",false,"/img/zapatasName.jpg", 5);
        foodTruckRepo.save(foodTruck6);
        FoodTruck foodTruck7 = new FoodTruck("Late Night Slice","https://www.latenightslice.com/",true, "/img/lateNightSliceName.jpg", 5);
        foodTruckRepo.save(foodTruck7);
        FoodTruck foodTruck8 = new FoodTruck("The Angry Wiener", "https://www.edjegroup.com/", true, "/img/angryWienerName.jpg", 5);
        foodTruckRepo.save(foodTruck8);
        FoodTruck foodTruck9 = new FoodTruck("Dirty Franks", "https://dirtyfranks.com/truck/",true,"/img/dirtyFranksName.jpg", 5);
        foodTruckRepo.save(foodTruck9);
        FoodTruck foodTruck10 = new FoodTruck("Ray Ray’s Hog Pit", "https://www.rayrayshogpit.com/",true,"/img/rayRaysName.jpg",5);
        foodTruckRepo.save(foodTruck10);
        FoodTruck foodTruck11 = new FoodTruck("Zaki Grill", "https://www.facebook.com/ZakiGrill",true,"/img/zakiGrillName.jpg", 5);
        foodTruckRepo.save(foodTruck11);
        FoodTruck foodTruck12 = new FoodTruck("Little Ladies Soft Serve", "https://www.littleladiessoftserve.com/",false,"/img/littleLadiesName.jpg", 5);
        foodTruckRepo.save(foodTruck12);
        FoodTruck foodTruck13 = new FoodTruck("Winston’s Coffee & Waffles", "https://www.winstonscoffeeandwaffles.com/",true,"/img/winstonsName.jpg", 5);
        foodTruckRepo.save(foodTruck13);
        FoodTruck foodTruck14 = new FoodTruck("Kabob Time", "https://www.kabobtime-columbus.com/",true,"/img/kabobTimeName.jpg", 5);
        foodTruckRepo.save(foodTruck14);

        Category category1 = new Category("Barbecue", "/img/barbecue.jpg", foodTruck10);
        categoryRepo.save(category1);
        Category category2 = new Category("Seafood", "/img/seafood.jpg", foodTruck4);
        categoryRepo.save(category2);
        Category category3 = new Category("Mexican", "/img/Mexican.jpg", foodTruck1, foodTruck6);
        categoryRepo.save(category3);
        Category category4 = new Category("Mediterranean", "/img/mediterranean.jpg", foodTruck5, foodTruck11);
        categoryRepo.save(category4);
        Category category5 = new Category("Sweet Treats", "/img/SweetTreats.jpg", foodTruck12, foodTruck13);
        categoryRepo.save(category5);
        Category category6 = new Category("American", "/img/American.jpg", foodTruck7, foodTruck8, foodTruck9);
        categoryRepo.save(category6);
        Category category7 = new Category("European", "/img/european.jpg", foodTruck2);
        categoryRepo.save(category7);
        Category category8 = new Category("Breakfast", "/img/breakfast.jpg", foodTruck13);
        categoryRepo.save(category8);
        Category category9 = new Category("Asian", "/img/asian.jpg", foodTruck3);
        categoryRepo.save(category9);
        Category category10 = new Category("Middle Eastern", "/img/middleEastern.jpg", foodTruck14);
        categoryRepo.save(category10);
        Category category11 = new Category("Soul Food", "/img/soulFood.jpg", foodTruck10);
        categoryRepo.save(category11);

        Hashtag hashtag1 = new Hashtag("#NomNom", foodTruck1,foodTruck2);
        hashtagRepo.save(hashtag1);
        Hashtag hashtag2 = new Hashtag("#AllGone", foodTruck3,foodTruck4);
        hashtagRepo.save(hashtag2);
        Hashtag hashtag3 = new Hashtag("#Tasty", foodTruck5,foodTruck6);
        hashtagRepo.save(hashtag3);
        Hashtag hashtag4 = new Hashtag("#Amazing", foodTruck7,foodTruck8);
        hashtagRepo.save(hashtag4);
        Hashtag hashtag5 = new Hashtag("#Delicious", foodTruck9,foodTruck10);
        hashtagRepo.save(hashtag5);
        Hashtag hashtag6 = new Hashtag("#FoodiesOfInstagram", foodTruck11,foodTruck12);
        hashtagRepo.save(hashtag6);
        Hashtag hashtag7 = new Hashtag("#BestFoodTruckEver", foodTruck13,foodTruck14);
        hashtagRepo.save(hashtag7);


        Review review1 = new Review("Great food!", 5, foodTruck1);
        reviewRepo.save(review1);
        Review review2 = new Review("Delicious and quick!", 5, foodTruck2);
        reviewRepo.save(review2);
        Review review3 = new Review("Tastes so good, make you wanna slap yo' mama!", 5, foodTruck10);
        reviewRepo.save(review3);
        Review review4 = new Review("Awesome food, no wait!", 5, foodTruck3);
        reviewRepo.save(review4);
        Review review5 = new Review("One of my favorites in the city", 5, foodTruck4);
        reviewRepo.save(review5);
        Review review6 = new Review("Love this place!", 5, foodTruck5);
        reviewRepo.save(review6);
        Review review7 = new Review("I love this food truck because it has great locations and great food! The service is quick and friendly!", 5, foodTruck6);
        reviewRepo.save(review7);
        Review review8 = new Review("My daughter loves it here!", 5, foodTruck6);
        reviewRepo.save(review8);
        Review review9 = new Review("Amazing food!", 5, foodTruck7);
        reviewRepo.save(review9);
        Review review10 = new Review("The location is convenient, but the food is a bit pricey for what it is. Food is delicious though!", 5, foodTruck8);
        reviewRepo.save(review10);
        Review review11 = new Review("Food is great, but the truck is hard to find! I wish I could follow this truck around every day!", 5, foodTruck9);
        reviewRepo.save(review11);
        Review review12 = new Review("Worth the money!", 5, foodTruck10);
        reviewRepo.save(review12);
        Review review13 = new Review("This truck is outside of my work every day. So quick and easy to get lunch and has delicious food!", 5, foodTruck12);
        reviewRepo.save(review13);
        Review review14 = new Review("Love their desserts! This is a great treat!", 5, foodTruck13);
        reviewRepo.save(review14);
        Review review15 = new Review("Chefs kiss.  I love this food truck.", 5, foodTruck14);
        reviewRepo.save(review15);







    }





}
