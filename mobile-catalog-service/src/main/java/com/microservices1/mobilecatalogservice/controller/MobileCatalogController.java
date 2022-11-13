package com.microservices1.mobilecatalogservice.controller;

import com.microservices1.mobilecatalogservice.model.CatalogItem;
import com.microservices1.mobilecatalogservice.model.Mobile;
import com.microservices1.mobilecatalogservice.model.Rating;
import com.microservices1.mobilecatalogservice.model.UserRating;
import com.microservices1.mobilecatalogservice.services.MobileInfo;
import com.microservices1.mobilecatalogservice.services.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MobileCatalogController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder builder;

    @Autowired
    MobileInfo mobileInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

    @RequestMapping("{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){



        UserRating ratings = userRatingInfo.getUserRating(userId);
        return ratings.getUserRating().stream().map(
                rating -> {
                    return mobileInfo.getCatalogItem(rating);
                })
                .collect(Collectors.toList());
    }
}
