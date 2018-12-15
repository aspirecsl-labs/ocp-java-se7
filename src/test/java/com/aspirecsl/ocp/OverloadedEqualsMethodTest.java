package com.aspirecsl.ocp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OverloadedEqualsMethodTest
{
    @Test
    public void overloaded_EqualsMethod_ISNotTheSameAs_OverriddenEqualsMethod()
    {
        final Dog dog1 = new Dog( "Luchi" );
        final Animal dog2 = new Dog( "Luchi" );

        // calls the equals(Object object) method in the Object class
        assertThat( dog1.equals( dog2 ), is( false ) );

        // calls the overloaded equals(Dog dog) method in Dog class
        assertThat( dog1.equals( ( Dog ) dog2 ), is( true ) );
    }
}
