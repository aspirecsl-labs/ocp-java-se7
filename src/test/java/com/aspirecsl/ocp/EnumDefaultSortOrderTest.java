package com.aspirecsl.ocp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.aspirecsl.ocp.UpIsDownEnum.*;
import static java.util.Arrays.asList;
import static java.util.Collections.reverse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EnumDefaultSortOrderTest
{
    @Test
    public void defaultSortOrder_ForEnumConstants_IsTheirDeclarationOrder()
    {
        final List< UpIsDownEnum > enumConstantsAsList = asList( values() );
        reverse( enumConstantsAsList );
        final UpIsDownEnum[] enumConstants = enumConstantsAsList.toArray( new UpIsDownEnum[ 0 ] );

        assertThat( enumConstants, is( arrayContaining( ALLIGATOR, OSTRICH, ZEBRA ) ) );
        assertThat( enumConstantsAsList, contains( ALLIGATOR, OSTRICH, ZEBRA ) );

        Arrays.sort( enumConstants );
        Collections.sort( enumConstantsAsList );

        assertThat( enumConstants, is( arrayContaining( ZEBRA, OSTRICH, ALLIGATOR ) ) );
        assertThat( enumConstantsAsList, contains( ZEBRA, OSTRICH, ALLIGATOR ) );
    }
}
