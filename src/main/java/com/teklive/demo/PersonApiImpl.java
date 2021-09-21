package com.teklive.demo;

import com.github.javafaker.Faker;

import javax.ws.rs.core.Response;

public class PersonApiImpl implements PersonApi {
    @Override
    public Response generateRandomPerson() {
        Faker faker = new Faker();
        Person person = Person.Builder.aPerson()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().fullAddress())
                .build();
        return Response.ok(person).build();
    }
    // personImpl
}
