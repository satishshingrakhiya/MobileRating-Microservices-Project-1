package com.microservices1.ratinginfoservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserRating {
    public List<Rating> userRating;
}
