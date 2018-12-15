package com.aspirecsl.ocp;

import java.util.ArrayList;
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

    public boolean canEatTreats( Animal animal, List< String > treats )
    {
        return animal.canEatTreats( treats );
    }

    public boolean canEatTreats( Animal animal, ArrayList< String > treats )
    {
        return animal.canEatTreats( treats );
    }

    public boolean canEatTreats( Dog dog, List< String > treats )
    {
        return dog.canEatTreats( treats );
    }

    public boolean canEatTreats( Dog dog, ArrayList< String > treats )
    {
        return dog.canEatTreats( treats );
    }

    public String mistakenIdentity( Animal animal )
    {
        //noinspection AccessStaticViaInstance
        return animal.identity();
    }
}
