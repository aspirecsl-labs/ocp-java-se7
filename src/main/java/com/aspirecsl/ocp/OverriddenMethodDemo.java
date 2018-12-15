package com.aspirecsl.ocp;

import java.util.List;

@SuppressWarnings( { "unused",
                     "WeakerAccess" } )
public class OverriddenMethodDemo
{
    public String makeNoise( Animal animal )
    {
        return animal.noise();
    }

    public List< String > foodsEaten( Animal animal )
    {
        return animal.foods();
    }

    public String isHumanFriendly( Animal animal )
    {
        return animal.isHumanFriendly();
    }

    public String wagsTail( Animal animal )
    {
        return animal.wagsTail();
    }

    public String sleepsAtNight( Animal animal ) throws Exception
    {
        return animal.sleepsAtNight();
    }

    public String lovesLongWalks( Animal animal )
    {
        return animal.lovesLongWalks();
    }

    public String climbsTrees( Animal animal ) throws Exception
    {
        return animal.climbsTrees();
    }
}
