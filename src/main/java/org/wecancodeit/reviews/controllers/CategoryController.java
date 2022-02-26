package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.repos.CategoryRepository;
import org.wecancodeit.reviews.repos.FoodTruckRepository;

@Controller
public class CategoryController {
    private CategoryRepository categoryRepo;
    private FoodTruckRepository foodTruckRepo;


    public CategoryController(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    @RequestMapping("/")
    public String showCategoriesTemplate(Model model){
        model.addAttribute("categories", categoryRepo.findAll());
        return "CategoriesTemplate";
    }

    @RequestMapping("/CategoriesTemplate/SingleCategoryTruckListTemplate/{categoryId}")
    public String showSingleCategoryTruckListTemplate(Model model, @PathVariable long categoryId) {
        model.addAttribute("category", categoryRepo.findById(categoryId).get());
        model.addAttribute("categoryName", categoryRepo.findById(categoryId).get().getCategory());
        return "SingleCategoryTruckListTemplate";
    }

}
