package com.microservices1.mobilecatalogservice.controller;

import com.microservices1.mobilecatalogservice.model.CatalogItem;
import com.microservices1.mobilecatalogservice.model.Mobile;
import com.microservices1.mobilecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MobileCatalogController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder builder;

    @RequestMapping("{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){



        UserRating ratings = restTemplate.getForObject("http://rating-info-service/ratingsdata/users/" + userId, UserRating.class);
        return ratings.getUserRating().stream().map(
                rating -> {
                    Mobile mobile = restTemplate.getForObject("http://mobile-info-service/mobile/" + rating.getModelName(), Mobile.class);
                    /*
                    // Using Webclient
                    Mobile mobile = builder.build()
                            .get()
                            .uri("http://localhost:8082/mobile/" + rating.getModelName())
                            .retrieve()
                            .bodyToMono(Mobile.class)
                            .block();
                     */
                    return new CatalogItem(mobile.getModelName(), mobile.getCompanyName(), rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
