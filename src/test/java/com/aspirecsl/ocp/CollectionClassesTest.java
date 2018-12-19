package com.aspirecsl.ocp;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static java.util.Comparator.reverseOrder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;

public class CollectionClassesTest
{
    private Entries.EquatableEntry equatableEntry;
    private Entries.EquatableEntry equatableEntry1;
    private Entries.EquatableEntry equatableEntry2;

    private Entries.ComparableEntry comparableEntry;
    private Entries.ComparableEntry comparableEntry1;
    private Entries.ComparableEntry comparableEntry2;

    private Entries.ComparableAndEquatableEntry comparableAndEquatableEntry1;
    private Entries.ComparableAndEquatableEntry comparableAndEquatableEntry2;

    @Before
    public void setup()
    {
        equatableEntry = new Entries.EquatableEntry( 1 );
        equatableEntry1 = new Entries.EquatableEntry( 1 );
        equatableEntry2 = new Entries.EquatableEntry( 2 );

        comparableEntry = new Entries.ComparableEntry( 1 );
        comparableEntry1 = new Entries.ComparableEntry( 1 );
        comparableEntry2 = new Entries.ComparableEntry( 2 );

        comparableAndEquatableEntry1 = new Entries.ComparableAndEquatableEntry( 1 );
        comparableAndEquatableEntry2 = new Entries.ComparableAndEquatableEntry( 2 );
    }

    @Test
    public void allListImplementations_Use_EqualsMethod_AndNot_CompareToMethod_WhenCheckingExistence()
    {
        final List< Entries.EquatableEntry > equatableEntriesArrayList =
                new ArrayList<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );
        final List< Entries.ComparableEntry > comparableEntriesArrayList =
                new ArrayList<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        final List< Entries.EquatableEntry > equatableEntriesLinkedList =
                new LinkedList<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );
        final List< Entries.ComparableEntry > comparableEntriesLinkedList =
                new LinkedList<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        final Deque< Entries.EquatableEntry > equatableEntriesArrayDeque = new ArrayDeque<>();
        final Deque< Entries.ComparableEntry > comparableEntriesArrayDeque = new ArrayDeque<>();

        equatableEntriesArrayDeque.add( equatableEntry1 );
        equatableEntriesArrayDeque.offerLast( equatableEntry2 );

        comparableEntriesArrayDeque.offer( comparableEntry2 );
        comparableEntriesArrayDeque.addFirst( comparableEntry1 );

        assertThat( equatableEntriesArrayList, hasItem( equatableEntry ) );
        assertThat( equatableEntriesLinkedList, hasItem( equatableEntry ) );
        assertThat( equatableEntriesArrayDeque, hasItem( equatableEntry ) );

        assertThat( comparableEntriesArrayList, not( hasItem( comparableEntry ) ) );
        assertThat( comparableEntriesLinkedList, not( hasItem( comparableEntry ) ) );
        assertThat( comparableEntriesArrayDeque, not( hasItem( comparableEntry ) ) );
    }

    @Test
    public void hashSet_Uses_EqualsMethod_AndNot_CompareToMethod_ToEstablish_Equality_WhenAddingElements()
    {
        final Set< Entries.EquatableEntry > equatableEntries =
                new HashSet<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );

        final Set< Entries.ComparableEntry > comparableEntries =
                new HashSet<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        equatableEntries.add( equatableEntry );
        comparableEntries.add( comparableEntry );

        assertThat( equatableEntries.size(), is( equalTo( 2 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 3 ) ) );
    }

    @Test
    public void hashSet_Uses_EqualsMethod_AndNot_CompareToMethod_ToEstablish_Equality_WhenRemovingElements()
    {
        final Set< Entries.EquatableEntry > equatableEntries =
                new HashSet<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );

        final Set< Entries.ComparableEntry > comparableEntries =
                new HashSet<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        equatableEntries.remove( equatableEntry );
        comparableEntries.remove( comparableEntry );

        assertThat( equatableEntries.size(), is( equalTo( 1 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 2 ) ) );
    }

    @Test
    public void linkedHashSet_Uses_EqualsMethod_AndNot_CompareToMethod_ToEstablish_Equality_WhenAddingElements()
    {
        final Set< Entries.EquatableEntry > equatableEntries =
                new LinkedHashSet<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );

        final Set< Entries.ComparableEntry > comparableEntries =
                new LinkedHashSet<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        equatableEntries.add( equatableEntry );
        comparableEntries.add( comparableEntry );

        assertThat( equatableEntries.size(), is( equalTo( 2 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 3 ) ) );
    }

    @Test
    public void linkedHashSet_Uses_EqualsMethod_AndNot_CompareToMethod_ToEstablish_Equality_WhenRemovingElements()
    {
        final Set< Entries.EquatableEntry > equatableEntries =
                new LinkedHashSet<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );

        final Set< Entries.ComparableEntry > comparableEntries =
                new LinkedHashSet<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        equatableEntries.remove( equatableEntry );
        comparableEntries.remove( comparableEntry );

        assertThat( equatableEntries.size(), is( equalTo( 1 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 2 ) ) );
    }

    @Test
    public void treeSet_Uses_CompareToMethod_AndNot_EqualsMethod_ToEstablish_Equality_WhenAddingElements()
    {
        final Set< Entries.EquatableEntry > equatableEntries =
                new TreeSet<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );

        final Set< Entries.ComparableEntry > comparableEntries =
                new TreeSet<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        equatableEntries.add( equatableEntry );
        comparableEntries.add( comparableEntry );

        assertThat( equatableEntries.size(), is( equalTo( 3 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 2 ) ) );
    }

    @Test
    public void treeSet_Uses_CompareToMethod_AndNot_EqualsMethod_ToEstablish_Equality_WhenRemovingElements()
    {
        final Set< Entries.EquatableEntry > equatableEntries =
                new TreeSet<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );

        final Set< Entries.ComparableEntry > comparableEntries =
                new TreeSet<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        equatableEntries.remove( equatableEntry );
        comparableEntries.remove( comparableEntry );

        assertThat( equatableEntries.size(), is( equalTo( 2 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 1 ) ) );
    }

    @Test
    public void allSetImplementations_Use_EqualsMethod_AndNot_CompareToMethod_WhenCheckingExistence()
    {
        final Set< Entries.EquatableEntry > equatableEntriesHashSet =
                new HashSet<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );

        final Set< Entries.ComparableEntry > comparableEntriesHashSet =
                new HashSet<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        final Set< Entries.EquatableEntry > equatableEntriesTreeSet =
                new TreeSet<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );

        final Set< Entries.ComparableEntry > comparableEntriesTreeSet =
                new TreeSet<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        final Set< Entries.EquatableEntry > equatableEntriesLinkedHashSet =
                new LinkedHashSet<>( Arrays.asList( equatableEntry1, equatableEntry2 ) );

        final Set< Entries.ComparableEntry > comparableEntriesLinkedHashSet =
                new LinkedHashSet<>( Arrays.asList( comparableEntry1, comparableEntry2 ) );

        assertThat( equatableEntriesHashSet, hasItem( equatableEntry ) );
        assertThat( equatableEntriesTreeSet, hasItem( equatableEntry ) );
        assertThat( equatableEntriesLinkedHashSet, hasItem( equatableEntry ) );

        assertThat( comparableEntriesHashSet, not( hasItem( comparableEntry ) ) );
        assertThat( comparableEntriesTreeSet, not( hasItem( comparableEntry ) ) );
        assertThat( comparableEntriesLinkedHashSet, not( hasItem( comparableEntry ) ) );
    }

    @Test
    public void naturalSortOrderOfEntries_IsPreserved_WhenTreeSetIsNotGivenA_Comparator()
    {
        final Set< Entries.ComparableAndEquatableEntry > treeSet = new TreeSet<>();

        treeSet.add( comparableAndEquatableEntry1 );
        treeSet.add( comparableAndEquatableEntry2 );

        assertThat( treeSet, contains( comparableAndEquatableEntry1, comparableAndEquatableEntry2 ) );
    }

    @Test
    public void naturalSortOrderOfEntries_IsIgnored_WhenTreeSetIsGivenA_Comparator()
    {
        final Set< Entries.ComparableAndEquatableEntry > treeSet = new TreeSet<>( reverseOrder() );

        treeSet.add( comparableAndEquatableEntry1 );
        treeSet.add( comparableAndEquatableEntry2 );

        assertThat( treeSet, contains( comparableAndEquatableEntry2, comparableAndEquatableEntry1 ) );
    }

    @Test
    public void hashMap_Uses_EqualsMethod_AndNot_CompareToMethod_OnKeyObject_WhenAddingElements()
    {
        final Map< Entries.EquatableEntry, String > equatableEntries = new HashMap<>();
        final Map< Entries.ComparableEntry, String > comparableEntries = new HashMap<>();

        equatableEntries.put( equatableEntry, "Value 1" );
        equatableEntries.put( equatableEntry1, "Value 2" );
        equatableEntries.put( equatableEntry2, "Value 3" );

        comparableEntries.put( comparableEntry, "Value 1" );
        comparableEntries.put( comparableEntry1, "Value 2" );
        comparableEntries.put( comparableEntry2, "Value 3" );

        assertThat( equatableEntries.size(), is( equalTo( 2 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 3 ) ) );
    }

    @Test
    public void linkedHashMap_Uses_EqualsMethod_AndNot_CompareToMethod_OnKeyObject_WhenAddingElements()
    {
        final Map< Entries.EquatableEntry, String > equatableEntries = new LinkedHashMap<>();
        final Map< Entries.ComparableEntry, String > comparableEntries = new LinkedHashMap<>();

        equatableEntries.put( equatableEntry, "Value 1" );
        equatableEntries.put( equatableEntry1, "Value 2" );
        equatableEntries.put( equatableEntry2, "Value 3" );

        comparableEntries.put( comparableEntry, "Value 1" );
        comparableEntries.put( comparableEntry1, "Value 2" );
        comparableEntries.put( comparableEntry2, "Value 3" );

        assertThat( equatableEntries.size(), is( equalTo( 2 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 3 ) ) );
    }

    @Test
    public void treeMap_Uses_CompareToMethod_AndNot_EqualsMethod_OnKeyObject_WhenAddingElements()
    {
        final Map< Entries.EquatableEntry, String > equatableEntries = new TreeMap<>();
        final Map< Entries.ComparableEntry, String > comparableEntries = new TreeMap<>();

        equatableEntries.put( equatableEntry, "Value 1" );
        equatableEntries.put( equatableEntry1, "Value 2" );
        equatableEntries.put( equatableEntry2, "Value 3" );

        comparableEntries.put( comparableEntry, "Value 1" );
        comparableEntries.put( comparableEntry1, "Value 2" );
        comparableEntries.put( comparableEntry2, "Value 3" );

        assertThat( equatableEntries.size(), is( equalTo( 3 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 2 ) ) );
    }

    @Test
    public void hashMap_Uses_EqualsMethod_AndNot_CompareToMethod_OnKeyObject_WhenRemovingElements()
    {
        final Map< Entries.EquatableEntry, String > equatableEntries = new HashMap<>();
        final Map< Entries.ComparableEntry, String > comparableEntries = new HashMap<>();

        equatableEntries.put( equatableEntry1, "Value 1" );
        equatableEntries.put( equatableEntry2, "Value 2" );
        equatableEntries.remove( equatableEntry );


        comparableEntries.put( comparableEntry1, "Value 1" );
        comparableEntries.put( comparableEntry2, "Value 2" );
        comparableEntries.remove( comparableEntry );

        assertThat( equatableEntries.size(), is( equalTo( 1 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 2 ) ) );
    }

    @Test
    public void linkedHashMap_Uses_EqualsMethod_AndNot_CompareToMethod_OnKeyObject_WhenRemovingElements()
    {
        final Map< Entries.EquatableEntry, String > equatableEntries = new LinkedHashMap<>();
        final Map< Entries.ComparableEntry, String > comparableEntries = new LinkedHashMap<>();

        equatableEntries.put( equatableEntry1, "Value 1" );
        equatableEntries.put( equatableEntry2, "Value 2" );
        equatableEntries.remove( equatableEntry );


        comparableEntries.put( comparableEntry1, "Value 1" );
        comparableEntries.put( comparableEntry2, "Value 2" );
        comparableEntries.remove( comparableEntry );

        assertThat( equatableEntries.size(), is( equalTo( 1 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 2 ) ) );
    }

    @Test
    public void treeMap_Uses_CompareToMethod_AndNot_EqualsMethod_OnKeyObject_WhenRemovingElements()
    {
        final Map< Entries.EquatableEntry, String > equatableEntries = new TreeMap<>();
        final Map< Entries.ComparableEntry, String > comparableEntries = new TreeMap<>();

        equatableEntries.put( equatableEntry1, "Value 1" );
        equatableEntries.put( equatableEntry2, "Value 2" );
        equatableEntries.remove( equatableEntry );


        comparableEntries.put( comparableEntry1, "Value 1" );
        comparableEntries.put( comparableEntry2, "Value 2" );
        comparableEntries.remove( comparableEntry );

        assertThat( equatableEntries.size(), is( equalTo( 2 ) ) );
        assertThat( comparableEntries.size(), is( equalTo( 1 ) ) );
    }

    @Test
    public void hashMap_Uses_EqualsMethod_AndNot_CompareToMethod_OnKeyObject_WhenCheckingKeyExistence()
    {
        final Map< Entries.EquatableEntry, String > equatableEntriesHashMap = new HashMap<>();
        final Map< Entries.ComparableEntry, String > comparableEntriesHashMap = new HashMap<>();

        equatableEntriesHashMap.put( equatableEntry1, "Value 1" );
        equatableEntriesHashMap.put( equatableEntry2, "Value 2" );

        comparableEntriesHashMap.put( comparableEntry1, "Value 1" );
        comparableEntriesHashMap.put( comparableEntry2, "Value 2" );

        assertThat( equatableEntriesHashMap.containsKey( equatableEntry ), is( true ) );
        assertThat( comparableEntriesHashMap.containsKey( comparableEntry ), is( false ) );

    }

    @Test
    public void linkedHashMap_Uses_EqualsMethod_AndNot_CompareToMethod_OnKeyObject_WhenCheckingKeyExistence()
    {
        final Map< Entries.EquatableEntry, String > equatableEntriesLinkedHashMap = new LinkedHashMap<>();
        final Map< Entries.ComparableEntry, String > comparableEntriesLinkedHashMap = new LinkedHashMap<>();

        equatableEntriesLinkedHashMap.put( equatableEntry1, "Value 1" );
        equatableEntriesLinkedHashMap.put( equatableEntry2, "Value 2" );

        comparableEntriesLinkedHashMap.put( comparableEntry1, "Value 1" );
        comparableEntriesLinkedHashMap.put( comparableEntry2, "Value 2" );

        assertThat( equatableEntriesLinkedHashMap.containsKey( equatableEntry ), is( true ) );
        assertThat( comparableEntriesLinkedHashMap.containsKey( comparableEntry ), is( false ) );
    }

    @Test
    public void treeMap_Uses_CompareToMethod_AndNot_EqualsMethod_OnKeyObject_WhenCheckingKeyExistence()
    {
        final Map< Entries.EquatableEntry, String > equatableEntriesTreeMap = new TreeMap<>();
        final Map< Entries.ComparableEntry, String > comparableEntriesTreeMap = new TreeMap<>();

        equatableEntriesTreeMap.put( equatableEntry1, "Value 1" );
        equatableEntriesTreeMap.put( equatableEntry2, "Value 2" );

        comparableEntriesTreeMap.put( comparableEntry1, "Value 1" );
        comparableEntriesTreeMap.put( comparableEntry2, "Value 2" );

        assertThat( equatableEntriesTreeMap.containsKey( equatableEntry ), is( false ) );
        assertThat( comparableEntriesTreeMap.containsKey( comparableEntry ), is( true ) );
    }

    @Test
    public void allMapImplementations_Use_EqualsMethod_AndNot_CompareToMethod_OnValueObject_WhenCheckingValueExistence()
    {
        final Map< String, Entries.EquatableEntry > equatableEntriesHashMap = new HashMap<>();
        final Map< String, Entries.EquatableEntry > equatableEntriesTreeMap = new TreeMap<>();
        final Map< String, Entries.EquatableEntry > equatableEntriesLinkedHashMap = new LinkedHashMap<>();

        final Map< String, Entries.ComparableEntry > comparableEntriesHashMap = new HashMap<>();
        final Map< String, Entries.ComparableEntry > comparableEntriesTreeMap = new TreeMap<>();
        final Map< String, Entries.ComparableEntry > comparableEntriesLinkedHashMap = new LinkedHashMap<>();

        equatableEntriesHashMap.put( "Key 1", equatableEntry1 );
        equatableEntriesHashMap.put( "Key 2", equatableEntry2 );
        equatableEntriesTreeMap.put( "Key 1", equatableEntry1 );
        equatableEntriesTreeMap.put( "Key 2", equatableEntry2 );
        equatableEntriesLinkedHashMap.put( "Key 1", equatableEntry1 );
        equatableEntriesLinkedHashMap.put( "Key 2", equatableEntry2 );

        comparableEntriesHashMap.put( "Key 1", comparableEntry1 );
        comparableEntriesHashMap.put( "Key 2", comparableEntry2 );
        comparableEntriesTreeMap.put( "Key 1", comparableEntry1 );
        comparableEntriesTreeMap.put( "Key 2", comparableEntry2 );
        comparableEntriesLinkedHashMap.put( "Key 1", comparableEntry1 );
        comparableEntriesLinkedHashMap.put( "Key 2", comparableEntry2 );

        assertThat( equatableEntriesHashMap.containsValue( equatableEntry ), is( true ) );
        assertThat( equatableEntriesTreeMap.containsValue( equatableEntry ), is( true ) );
        assertThat( equatableEntriesLinkedHashMap.containsValue( equatableEntry ), is( true ) );

        assertThat( comparableEntriesHashMap.containsValue( comparableEntry ), is( false ) );
        assertThat( comparableEntriesTreeMap.containsValue( comparableEntry ), is( false ) );
        assertThat( comparableEntriesLinkedHashMap.containsValue( comparableEntry ), is( false ) );
    }

    @Test
    public void naturalSortOrderOfEntries_IsPreserved_WhenTreeMapIsNotGivenA_Comparator()
    {
        final Map< Entries.ComparableAndEquatableEntry, String > treeMap = new TreeMap<>();

        treeMap.put( comparableAndEquatableEntry1, "Value 1" );
        treeMap.put( comparableAndEquatableEntry2, "Value 2" );

        assertThat( treeMap.keySet(), contains( comparableAndEquatableEntry1, comparableAndEquatableEntry2 ) );
        assertThat( treeMap.values(), contains( "Value 1", "Value 2" ) );
    }

    @Test
    public void naturalSortOrderOfEntries_IsIgnored_WhenTreeMapIsGivenA_Comparator()
    {
        final Map< Entries.ComparableAndEquatableEntry, String > treeMapReversed = new TreeMap<>( reverseOrder() );

        treeMapReversed.put( comparableAndEquatableEntry1, "Value 1" );
        treeMapReversed.put( comparableAndEquatableEntry2, "Value 2" );

        assertThat( treeMapReversed.keySet(), contains( comparableAndEquatableEntry2, comparableAndEquatableEntry1 ) );
        assertThat( treeMapReversed.values(), contains( "Value 2", "Value 1" ) );
    }
}
