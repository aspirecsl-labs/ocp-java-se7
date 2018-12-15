package com.aspirecsl.ocp;

@SuppressWarnings( { "unused",
                     "WeakerAccess" } )
public class MutableHashKey
{
    private int id;

    public MutableHashKey( int id )
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
