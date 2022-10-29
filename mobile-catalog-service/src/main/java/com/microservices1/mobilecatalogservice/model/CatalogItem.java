package com.microservices1.mobilecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CatalogItem {

    private String modelName;
    private String companyName;
    private short rating;

}
