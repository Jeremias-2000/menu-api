package com.menu.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodType {
    BARBECUE("barbecue"),
    DRINK("drink"),
    JUICE("juice"),
    PASTA("pasta"),
    SEAFOOD("seafood");

    private String description;
}
