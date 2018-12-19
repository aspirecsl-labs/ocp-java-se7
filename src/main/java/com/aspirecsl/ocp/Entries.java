package com.aspirecsl.ocp;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings( "WeakerAccess" )
public class Entries
{
    public static class ComparableEntry implements Comparable< ComparableEntry >
    {
        private final int value;

        public ComparableEntry( int value )
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }

        @Override
        public int compareTo( ComparableEntry other )
        {
            return Integer.compare( value, other.value );
        }

        /*
         * equals method returns false for all cases
         */
        @Override
        public boolean equals( Object o )
        {
            return false;
        }

        /*
         * hashCode method returns a different value each time
         */
        @Override
        public int hashCode()
        {
            return ThreadLocalRandom.current()
                                    .nextInt();
        }
    }

    public static class EquatableEntry implements Comparable< EquatableEntry >
    {
        private final int value;

        public EquatableEntry( int value )
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }

        @Override
        public boolean equals( Object o )
        {
            if ( this == o )
            {
                return true;
            }
            if ( o == null || getClass() != o.getClass() )
            {
                return false;
            }
            EquatableEntry that = ( EquatableEntry ) o;
            return value == that.value;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash( value );
        }

        /*
         * compareTo method returns -1 for all cases
         */
        @Override
        public int compareTo( EquatableEntry other )
        {
            return -1;
        }
    }
}
