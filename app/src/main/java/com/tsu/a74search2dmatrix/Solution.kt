package com.tsu.a74search2dmatrix

import java.util.Scanner

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) return false

        val m = matrix.size
        val n = matrix[0].size
        var l = 0
        var r = m * n - 1

        while (l <= r) {
            val mid = l + (r - l) / 2
            val i = mid / n
            val j = mid % n

            if (matrix[i][j] == target) {
                return true
            } else if (matrix[i][j] < target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return false
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    val m = scanner.nextInt()

    val n = scanner.nextInt()

    val matrix = Array(m) { IntArray(n) }

    for (i in 0 until m) {
        for (j in 0 until n) {
            matrix[i][j] = scanner.nextInt()
        }
    }

    val target = scanner.nextInt()

    val solution = Solution()
    val result = solution.searchMatrix(matrix, target)

    if (result) {
        println("Number $target found in the matrixs.")
    } else {
        println("Number $target not found in the matrixs.")
    }
}