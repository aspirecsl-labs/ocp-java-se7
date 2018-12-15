package com.aspirecsl.ocp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StaticBlockCtorOrderDemoTest
{

    @Test
    public void verifyThat_CorrectInitialisationOrderIsFollowed()
    {
        // Initialisation order is as follows:
        // -- 1. Parent static initialiser block
        // -- 2. Child static initialiser block
        // -- 3. Parent instance initialiser block
        // -- 4. Parent constructor
        // -- 5. Child instance initialiser block
        // -- 6. Child constructor

        assertThat( new StaticBlockCtorOrderDemo().getHeldValue(),
                    equalTo( "Parent Static Initialiser " +
                                     "And Then " +
                                     "Child Static Initialiser " +
                                     "And Then " +
                                     "Parent Instance Initialiser " +
                                     "And Then " +
                                     "Parent Ctor " +
                                     "And Then " +
                                     "Child Instance Initialiser " +
                                     "And Then " +
                                     "Child Ctor" ) );
    }
}