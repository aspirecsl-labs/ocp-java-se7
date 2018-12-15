package com.aspirecsl.ocp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings( { "unused",
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
        ArrayList< String > dogFoods = new ArrayList<>( Arrays.asList( "Meat", "Biscuit" ) );
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
}
