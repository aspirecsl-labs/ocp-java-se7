package com.aspirecsl.ocp;

@SuppressWarnings( { "unused",
                     "WeakerAccess" } )
public class MutableObject
{
    private int id;

    public MutableObject( int id )
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

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        MutableObject that = ( MutableObject ) o;
        return id == that.id;
    }
}
