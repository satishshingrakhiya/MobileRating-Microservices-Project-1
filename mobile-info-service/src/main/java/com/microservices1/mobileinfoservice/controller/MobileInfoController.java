package com.microservices1.mobileinfoservice.controller;

import com.microservices1.mobileinfoservice.model.Mobile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile")
public class MobileInfoController {

    @RequestMapping("/{mobileId}")
    public Mobile getMobileInfo(@PathVariable String mobileId){
        return new Mobile("Note 4", "Redmi");
    }

}
