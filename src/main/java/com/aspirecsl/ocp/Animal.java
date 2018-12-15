package com.aspirecsl.ocp;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings( { "unused",
                     "RedundantThrows" } )
public class Animal
{
    public String noise()
    {
        return "Some Noise";
    }

    public List< String > foods()
    {
        return Arrays.asList( "Vegetable", "Fruits" );
    }

    protected String isHumanFriendly()
    {
        return "maybe";
    }

    public synchronized String wagsTail()
    {
        return "maybe";
    }

    public String sleepsAtNight() throws Exception
    {
        return "maybe";
    }

    public String lovesLongWalks()
    {
        return "maybe";
    }

    public String climbsTrees() throws Exception
    {
        return "maybe";
    }
}
