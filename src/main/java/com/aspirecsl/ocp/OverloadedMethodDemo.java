package com.aspirecsl.ocp;

@SuppressWarnings( { "unused",
                     "WeakerAccess" } )
public class OverloadedMethodDemo
{
    public String identify( Animal animal )
    {
        return Animal.identity();
    }

    public String identify( Dog dog )
    {
        return Dog.identity();
    }

    public String socialize( Dog dog, Animal animal )
    {
        return "Dog & an Animal are friends";
    }

    public String socialize( Animal animal, Dog dog )
    {
        return "An Animal & Dog are friends";
    }
}


