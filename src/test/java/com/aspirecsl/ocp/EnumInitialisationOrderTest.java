package com.aspirecsl.ocp;

import org.junit.Test;

import static com.aspirecsl.ocp.EnumInitialisationOrder.TESTER;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EnumInitialisationOrderTest
{
    @Test
    public void verifies_EnumInstance_InitialisationOrder()
    {
        assertThat( TESTER.getValue(), equalTo( "Enum Constructor And Then Enum Static Initialiser" ) );
    }
}