package com.aspirecsl.ocp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class OverriddenMethodDemoTest
{
    private Dog    dog;
    private Animal animal;

    private OverriddenMethodDemo overriddenMethodDemo_SUT;

    @Before
    public void setup_SUT()
    {
        dog = new Dog();
        animal = new Animal();

        overriddenMethodDemo_SUT = new OverriddenMethodDemo();
    }

    @Test
    public void virtualMethodInvocation_InvokesTheMethodInTheObject_ResolvedAtRuntime()
    {
        assertThat( overriddenMethodDemo_SUT.makeNoise( animal ), equalTo( "Some Noise" ) );
        assertThat( overriddenMethodDemo_SUT.makeNoise( dog ), equalTo( "Woof Woof" ) );
    }

    @Test
    public void overridingMethod_CanReturnA_CovariantReturnType()
    {
        assertThat( overriddenMethodDemo_SUT.foodsEaten( animal ),
                    containsInAnyOrder( "Vegetables", "Fruits" ) );
        assertThat( overriddenMethodDemo_SUT.foodsEaten( dog ),
                    containsInAnyOrder( "Vegetables", "Fruits", "Meat", "Biscuits" ) );
    }


    @Test
    public void overridingMethod_CanUseA_LessRestrictive_AccessModifier()
    {
        assertThat( overriddenMethodDemo_SUT.isHumanFriendly( animal ), equalTo( "maybe" ) );
        assertThat( overriddenMethodDemo_SUT.isHumanFriendly( dog ), equalTo( "yes" ) );
    }

    @Test
    public void overridingMethod_CanUseA_Different_NonAccessModifier_SoLongAs_OverriddenMethod_IsNotFinal_OrStatic()
    {
        assertThat( overriddenMethodDemo_SUT.wagsTail( animal ), equalTo( "maybe" ) );
        assertThat( overriddenMethodDemo_SUT.wagsTail( dog ), equalTo( "yes" ) );
    }

    @Test
    public void overridingMethod_CanThrowA_SubClassException_OfTheOverriddenMethod() throws Exception
    {
        assertThat( overriddenMethodDemo_SUT.sleepsAtNight( animal ), equalTo( "maybe" ) );
        assertThat( overriddenMethodDemo_SUT.sleepsAtNight( dog ), equalTo( "yes" ) );
    }

    @Test
    public void overridingMethod_CanThrowUncheckedExceptions_EvenIfTheOverriddenMethod_DoesntThrowAny_UncheckedExceptions()
    {
        assertThat( overriddenMethodDemo_SUT.lovesLongWalks( animal ), equalTo( "maybe" ) );
        assertThat( overriddenMethodDemo_SUT.lovesLongWalks( dog ), equalTo( "yes" ) );
    }

    @Test
    public void overridingMethod_MayNotThrowExceptions_EvenIfTheOverriddenMethod_ThrowsExceptions() throws Exception
    {
        assertThat( overriddenMethodDemo_SUT.climbsTrees( animal ), equalTo( "maybe" ) );
        assertThat( overriddenMethodDemo_SUT.climbsTrees( dog ), equalTo( "no" ) );
    }

    @Test
    public void usingCovariantArguments_OverloadsTheMethodInTheParentClass_InsteadOfOverridingIt()
    {
        assertThat( overriddenMethodDemo_SUT.canEatTreats( dog, asList( "Meat", "Biscuits" ) ),
                    equalTo( false ) );
        assertThat( overriddenMethodDemo_SUT.canEatTreats( dog, new ArrayList<>( asList( "Meat", "Biscuits" ) ) ),
                    equalTo( true ) );

        assertThat( overriddenMethodDemo_SUT.canEatTreats( ( Animal ) dog, asList( "Meat", "Biscuits" ) ),
                    equalTo( false ) );
        assertThat( overriddenMethodDemo_SUT.canEatTreats( ( Animal ) dog, new ArrayList<>( asList( "Meat", "Biscuits" ) ) ),
                    equalTo( false ) );
    }

    @Test
    public void staticMethods_AreHidden_AndNot_Overridden()
    {
        assertThat( overriddenMethodDemo_SUT.mistakenIdentity( dog ), equalTo( "Animal" ) );
        assertThat( overriddenMethodDemo_SUT.mistakenIdentity( animal ), equalTo( "Animal" ) );
    }
}