package com.aspirecsl.ocp;

@SuppressWarnings( { "WeakerAccess",
                     "UnusedAssignment" } )
public class MultipleStaticInitializerBlocks
{
    static
    {
        value = 10;
    }

    private static int value = 0;

    static
    {
        value++;
    }

    public static int getValue()
    {
        return value;
    }
}
