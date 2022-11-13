package com.microservices1.mobilecatalogservice.services;

import com.microservices1.mobilecatalogservice.model.CatalogItem;
import com.microservices1.mobilecatalogservice.model.Mobile;
import com.microservices1.mobilecatalogservice.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MobileInfo {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    public CatalogItem getCatalogItem(Rating rating) {
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
    }

    public CatalogItem getFallBackCatalogItem(Rating rating) {
        return new CatalogItem("Not Found", "", rating.getRating());
    }
}
