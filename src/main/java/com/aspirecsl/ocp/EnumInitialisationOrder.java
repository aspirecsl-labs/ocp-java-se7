package com.aspirecsl.ocp;

import java.util.Optional;

@SuppressWarnings( "unused" )
public enum EnumInitialisationOrder
{
    TESTER;

    private static String bob;

    public String getValue()
    {
        return bob;
    }

    static
    {
        bob = createOrAppend( bob, "Enum Static Initialiser" );
    }

    EnumInitialisationOrder()
    {
        ctorOperation();
    }

    private static void ctorOperation()
    {
        bob = createOrAppend( bob, "Enum Constructor" );
        bob = createOrAppend( bob, " And Then " );
    }

    public static String createOrAppend( String bob, String text )
    {
        return Optional.ofNullable( bob )
                       .map( b -> b.concat( text ) )
                       .orElse( text );
    }
}
