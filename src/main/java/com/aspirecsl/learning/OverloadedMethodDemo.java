package com.aspirecsl.learning;

@SuppressWarnings( { "unused",
                     "WeakerAccess" } )
public class OverloadedMethodDemo
{
    public String identify( Animal animal )
    {
        return "Animal";
    }

    public String identify( Dog dog )
    {
        return "Dog";
    }

    public String socialize( Dog dog, Animal animal )
    {
        return "Dog & an Animal are friends";
    }

    public String socialize( Animal animal, Dog dog )
    {
        return "An Animal & Dog are friends";
    }

    public static class Animal
    {
    }

    public static class Dog extends Animal
    {
    }
}


