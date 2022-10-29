package com.microservices1.mobilecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rating {
    private String modelName;
    private short rating;
}
