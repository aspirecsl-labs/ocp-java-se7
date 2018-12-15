package com.aspirecsl.ocp;

import java.util.ArrayList;
import java.util.List;

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

    public boolean canEatTreats( Dog dog, List< String > treats )
    {
        return dog.canEatTreats( treats );
    }

    public boolean canEatTreats( Dog dog, ArrayList< String > treats )
    {
        return dog.canEatTreats( treats );
    }
}


