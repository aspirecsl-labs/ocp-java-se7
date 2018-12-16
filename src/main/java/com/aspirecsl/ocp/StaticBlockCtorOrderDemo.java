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
        protected static String bob;

        static
        {
            //noinspection ConstantConditions
            bob = createOrAppend( bob, "Parent Static Initialiser" );
            bob = createOrAppend( bob, " And Then " );
        }

        {
            bob = createOrAppend( bob, "Parent Instance Initialiser" );
            bob = createOrAppend( bob, " And Then " );
        }

        public Parent()
        {
            bob = createOrAppend( bob, "Parent Ctor" );
            bob = createOrAppend( bob, " And Then " );
        }
    }

    public static class Child extends Parent
    {
        static
        {
            bob = createOrAppend( bob, "Child Static Initialiser" );
            bob = createOrAppend( bob, " And Then " );
        }

        {
            bob = createOrAppend( bob, "Child Instance Initialiser" );
            bob = createOrAppend( bob, " And Then " );
        }

        public Child()
        {
            bob = createOrAppend( bob, "Child Ctor" );
        }

        public String value()
        {
            return bob;
        }
    }
}
