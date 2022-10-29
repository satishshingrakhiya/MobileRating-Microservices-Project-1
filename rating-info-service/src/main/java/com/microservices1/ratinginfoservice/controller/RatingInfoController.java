package com.microservices1.ratinginfoservice.controller;

import com.microservices1.ratinginfoservice.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingInfoController {

    @RequestMapping("/{modelName}")
    public Rating getRating(@PathVariable String modelName){
        return new Rating(modelName, (short) 4);
    }
}
