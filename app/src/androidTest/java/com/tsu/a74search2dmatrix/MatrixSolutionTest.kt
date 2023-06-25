package com.tsu.a74search2dmatrix

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MatrixSolutionTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testMatrixSearch_TargetFound() {
        /*
        Test case to verify matrix search when the target value is found in the matrix.
        It enters matrix input, target value, and clicks the search button.
        The expected result is that the target value is found in the matrix.
        */

        val matrixInput = "1 2 3 4 5 6"
        val target = 4

        Espresso.onView(ViewMatchers.withId(R.id.editTextRows)).perform(ViewActions.typeText("2"))
        Espresso.onView(ViewMatchers.withId(R.id.editTextColumns)).perform(ViewActions.typeText("3"))
        Espresso.onView(ViewMatchers.withId(R.id.editTextMatrix)).perform(ViewActions.typeText(matrixInput))
        Espresso.onView(ViewMatchers.withId(R.id.editTextTarget)).perform(ViewActions.typeText(target.toString()))
        Espresso.onView(ViewMatchers.withId(R.id.buttonSearch)).perform(ViewActions.click())

        // Verify the expected result
        Espresso.onView(ViewMatchers.withId(R.id.textViewResult)).check(ViewAssertions.matches(ViewMatchers.withText("The $target number is found in the matrix.")))
    }

    @Test
    fun testMatrixSearch_TargetNotFound() {
        /*
        Test case to verify matrix search when the target value is not found in the matrix.
        It enters matrix input, target value, and clicks the search button.
        The expected result is that the target value is not found in the matrix.
        */

        val matrixInput = "1 2 3 4 5 6"
        val target = 7

        Espresso.onView(ViewMatchers.withId(R.id.editTextRows)).perform(ViewActions.typeText("2"))
        Espresso.onView(ViewMatchers.withId(R.id.editTextColumns)).perform(ViewActions.typeText("3"))
        Espresso.onView(ViewMatchers.withId(R.id.editTextMatrix)).perform(ViewActions.typeText(matrixInput))
        Espresso.onView(ViewMatchers.withId(R.id.editTextTarget)).perform(ViewActions.typeText(target.toString()))
        Espresso.onView(ViewMatchers.withId(R.id.buttonSearch)).perform(ViewActions.click())

        // Verify the expected result
        Espresso.onView(ViewMatchers.withId(R.id.textViewResult)).check(ViewAssertions.matches(ViewMatchers.withText("The $target number is not found in the matrix.")))
    }

    @Test
    fun testMatrixSearch_EmptyMatrix() {
        /*
        Test case to verify matrix search when the matrix is empty.
        It enters an empty matrix, target value, and clicks the search button.
        The expected result is that the target value is not found in the matrix.
        */

        val matrixInput = ""
        val target = 5

        Espresso.onView(ViewMatchers.withId(R.id.editTextRows)).perform(ViewActions.typeText("0"))
        Espresso.onView(ViewMatchers.withId(R.id.editTextColumns)).perform(ViewActions.typeText("0"))
        Espresso.onView(ViewMatchers.withId(R.id.editTextMatrix)).perform(ViewActions.typeText(matrixInput))
        Espresso.onView(ViewMatchers.withId(R.id.editTextTarget)).perform(ViewActions.typeText(target.toString()))
        Espresso.onView(ViewMatchers.withId(R.id.buttonSearch)).perform(ViewActions.click())

        // Verify the expected result
        Espresso.onView(ViewMatchers.withId(R.id.textViewResult))
            .check(ViewAssertions.matches(ViewMatchers.withText("The $target number is not found in the matrix.")))

        val expectedResult = matrixInput.isEmpty()
        Espresso.onView(ViewMatchers.withId(R.id.textViewResult))
            .check(ViewAssertions.matches(ViewMatchers.withText(expectedResult.toString())))
    }
}