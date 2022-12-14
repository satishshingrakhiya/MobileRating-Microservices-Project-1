package com.microservices1.ratinginfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Rating {
    private String modelName;
    private short rating;
}
