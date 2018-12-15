package com.aspirecsl.ocp;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OverloadedMethodDemoTest
{
    private OverloadedMethodDemo overloadedMethodDemo_SUT;

    @Before
    public void setupSut()
    {
        overloadedMethodDemo_SUT = new OverloadedMethodDemo();
    }

    @Test
    public void overloadedMethods_AreResolved_AtCompileTime()
    {
        final Dog dog = new Dog();
        assertThat( overloadedMethodDemo_SUT.identify( dog ), equalTo( "Dog" ) );
        MatcherAssert.assertThat( overloadedMethodDemo_SUT.identify( ( Animal ) dog ), equalTo( "Animal" ) );
    }

    @Test
    public void dubiousCallsToOverloadedMethods_ResultsInCompileTimeError()
    {
        final Dog dog1 = new Dog();
        final Dog dog2 = new Dog();

        assertThat( overloadedMethodDemo_SUT.socialize( ( Animal ) dog1, dog2 ),
                    equalTo( "An Animal & Dog are friends" ) );
        assertThat( overloadedMethodDemo_SUT.socialize( dog1, ( Animal ) dog2 ),
                    equalTo( "Dog & an Animal are friends" ) );

        // the following dubious call won't compile as arguments (dog1, dog2) matches
        // both (Animal animal, Dog dog) and (Dog dog, Animal animal) parameter lists

        // overloadedMethodDemo_SUT.socialize( dog1, dog2 );
    }
}