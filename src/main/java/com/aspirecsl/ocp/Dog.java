package com.aspirecsl.ocp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings( { "unused",
                     "WeakerAccess",
                     "RedundantThrows" } )
public class Dog extends Animal
{
    @Override
    public String noise()
    {
        return "Woof Woof";
    }

    @Override
    public ArrayList< String > foods()
    {
        ArrayList< String > dogFoods = new ArrayList<>( Arrays.asList( "Meat", "Biscuits" ) );
        dogFoods.addAll( super.foods() );
        return dogFoods;
    }

    @Override
    public String isHumanFriendly()
    {
        return "yes";
    }

    @Override
    public final String wagsTail()
    {
        return "yes";
    }

    @Override
    public String sleepsAtNight() throws IOException
    {
        return "yes";
    }

    @Override
    public String lovesLongWalks() throws RuntimeException
    {
        return "yes";
    }

    @Override
    public String climbsTrees()
    {
        return "no";
    }

    // a covariant argument overloads the method instead of overriding it
    public boolean canEatTreats( ArrayList< String > treats )
    {
        return true;
    }
}
