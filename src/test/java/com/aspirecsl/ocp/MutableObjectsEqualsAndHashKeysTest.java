package com.aspirecsl.ocp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MutableObjectsEqualsAndHashKeysTest
{
    @Test
    public void mutableObject_WithDynamicHashCodeOverride_DoesNotMakeA_ReliableHashKey()
    {
        final Map< MutableObject, String > map = new HashMap<>();

        final MutableObject key = new MutableObject( 10 );
        map.put( key, "FooBar" );
        assertThat( map.get( key ), is( equalTo( "FooBar" ) ) );

        key.setId( 20 );
        assertThat( map.get( key ), is( nullValue() ) );
    }

    @Test
    public void mutableObject_WithDynamicEqualsOverride_ReportsInCorrectly_ForCollection_ContainsMethod()
    {
        final List< MutableObject > list = new ArrayList<>();

        final MutableObject value1 = new MutableObject( 10 );
        final MutableObject value2 = new MutableObject( 10 );

        list.add( value1 );
        assertThat( list.contains( value2 ), is( true ) );

        value1.setId( 20 );
        assertThat( list.contains( value2 ), is( false ) );
    }
}
