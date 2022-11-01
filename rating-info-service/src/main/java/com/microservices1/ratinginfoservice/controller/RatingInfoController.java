package com.microservices1.ratinginfoservice.controller;

import com.microservices1.ratinginfoservice.model.Rating;
import com.microservices1.ratinginfoservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingInfoController {

    @RequestMapping("/{modelName}")
    public Rating getRating(@PathVariable String modelName){
        return new Rating(modelName, (short) 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("Realme_7", (short) 4),
                new Rating("Radmi_note_4", (short) 3)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
