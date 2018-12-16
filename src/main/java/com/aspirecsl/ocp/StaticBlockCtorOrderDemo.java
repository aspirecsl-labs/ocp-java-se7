package com.aspirecsl.ocp;

import java.util.Optional;

@SuppressWarnings( { "unused",
                     "WeakerAccess",
                     "ClassInitializerMayBeStatic" } )
public class StaticBlockCtorOrderDemo
{
    public String getHeldValue()
    {
        return new Child().value();
    }

    public static String createOrAppend( String bob, String text )
    {
        return Optional.ofNullable( bob )
                       .map( b -> b.concat( text ) )
                       .orElse( text );
    }

    public static class Parent
    {
        protected static String value;

        static
        {
            //noinspection ConstantConditions
            value = createOrAppend( value, "Parent Static Initialiser" );
            value = createOrAppend( value, " And Then " );
        }

        {
            value = createOrAppend( value, "Parent Instance Initialiser" );
            value = createOrAppend( value, " And Then " );
        }

        public Parent()
        {
            value = createOrAppend( value, "Parent Ctor" );
            value = createOrAppend( value, " And Then " );
        }
    }

    public static class Child extends Parent
    {
        static
        {
            value = createOrAppend( value, "Child Static Initialiser" );
            value = createOrAppend( value, " And Then " );
        }

        {
            value = createOrAppend( value, "Child Instance Initialiser" );
            value = createOrAppend( value, " And Then " );
        }

        public Child()
        {
            value = createOrAppend( value, "Child Ctor" );
        }

        public String value()
        {
            return value;
        }
    }
}
