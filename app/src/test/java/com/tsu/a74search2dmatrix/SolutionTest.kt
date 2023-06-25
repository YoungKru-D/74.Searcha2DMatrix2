package com.tsu.a74search2dmatrix

import org.junit.Assert
import org.junit.Test

/**
 * Unit tests for the search Matrix function.
 */
class SearchMatrixTest {
    /**
     * Test case description: Empty matrix, target not present.
     * Expected output: false
     */
    @Test
    fun testEmptyMatrix() {
        val matrix = emptyArray<IntArray>()
        val target = 5
        val result = Solution().searchMatrix(matrix, target)
        Assert.assertFalse(result)
    }

    /**
     * Test case description: Matrix with single element, target present.
     * Expected output: true
     */
    @Test
    fun testSingleElementMatrix_TargetPresent() {
        val matrix = arrayOf(intArrayOf(5))
        val target = 5
        val result = Solution().searchMatrix(matrix, target)
        Assert.assertTrue(result)
    }

    /**
     * Test case description: Matrix with single element, target not present.
     * Expected output: false
     */
    @Test
    fun testSingleElementMatrix_TargetNotPresent() {
        val matrix = arrayOf(intArrayOf(5))
        val target = 10
        val result = Solution().searchMatrix(matrix, target)
        Assert.assertFalse(result)
    }

    /**
     * Test case description: Matrix with multiple rows and columns, target present.
     * Expected output: true
     */
    @Test
    fun testMatrix_TargetPresent() {
        val matrix = arrayOf(
            intArrayOf(1, 3, 5),
            intArrayOf(7, 9, 11),
            intArrayOf(13, 15, 17)
        )
        val target = 9
        val result = Solution().searchMatrix(matrix, target)
        Assert.assertTrue(result)
    }

    /**
     * Test case description: Matrix with multiple rows and columns, target not present.
     * Expected output: false
     */
    @Test
    fun testMatrix_TargetNotPresent() {
        val matrix = arrayOf(
            intArrayOf(1, 3, 5),
            intArrayOf(7, 9, 11),
            intArrayOf(13, 15, 17)
        )
        val target = 8
        val result = Solution().searchMatrix(matrix, target)
        Assert.assertFalse(result)
    }
}