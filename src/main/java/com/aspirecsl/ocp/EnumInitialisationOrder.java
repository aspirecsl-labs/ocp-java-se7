package com.aspirecsl.ocp;

import java.util.Optional;

@SuppressWarnings( { "unused",
                     "ClassInitializerMayBeStatic" } )
public enum EnumInitialisationOrder
{
    TESTER;

    private static String value;

    public String getValue()
    {
        return value;
    }

    static
    {
        value = createOrAppend( value, "Enum Static Initialiser" );
    }

    {
        modifyValue( "Enum Instance Initialiser" );
    }

    EnumInitialisationOrder()
    {
        modifyValue( "Enum Constructor" );
    }

    private static void modifyValue( String text )
    {
        value = createOrAppend( value, text );
        value = createOrAppend( value, " And Then " );
    }

    public static String createOrAppend( String bob, String text )
    {
        return Optional.ofNullable( bob )
                       .map( b -> b.concat( text ) )
                       .orElse( text );
    }
}
