package com.aspirecsl.ocp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MultipleStaticInitializerBlocksTest
{
    @Test
    public void verifies_TheStaticVariable_InitialisationOrder()
    {
        assertThat( MultipleStaticInitializerBlocks.getValue(), is( equalTo( 1 ) ) );
    }
}