package com.microservices1.mobilecatalogservice.controller;

import com.microservices1.mobilecatalogservice.model.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MobileCatalogController {

    @RequestMapping("{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){
        return Collections.singletonList(
                new CatalogItem("RealMe 7", "RealMe", (short) 4)
        );
    }
}
