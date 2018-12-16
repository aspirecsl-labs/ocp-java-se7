package com.aspirecsl.ocp;

import java.util.Optional;

@SuppressWarnings( "unused" )
public enum EnumInitialisationOrder
{
    TESTER;

    private static StringBuilder bob;

    public String getValue()
    {
        return bob.toString();
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

    public static StringBuilder createOrAppend( StringBuilder bob, String text )
    {
        return Optional.ofNullable( bob )
                       .map( b -> b.append( text ) )
                       .orElse( new StringBuilder( text ) );
    }
}
