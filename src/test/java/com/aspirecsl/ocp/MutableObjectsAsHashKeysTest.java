package com.aspirecsl.ocp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MutableObjectsAsHashKeysTest
{
    @Test
    public void mutableObject_WithDynamicHashCodeOverride_DoesNotMakeA_ReliableHashKey()
    {
        final Map< MutableHashKey, String > map = new HashMap<>();

        final MutableHashKey key = new MutableHashKey( 10 );
        map.put( key, "FooBar" );
        assertThat( map.get( key ), is( equalTo( "FooBar" ) ) );

        key.setId( 20 );
        assertThat( map.get( key ), is( nullValue() ) );
    }
}
