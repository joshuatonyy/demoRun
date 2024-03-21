package com.joshuadev.demo.user;

public record Address(
    String street,
    String suite,
    String city,
    String zipcode,
    Geo geo
) {

}
