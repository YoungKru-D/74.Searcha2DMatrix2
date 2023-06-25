package com.tsu.a74search2dmatrix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.a74search2dmatrix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSearch.setOnClickListener {
            val rows = binding.editTextRows.text.toString().toInt()
            val columns = binding.editTextColumns.text.toString().toInt()
            val matrixInput = binding.editTextMatrix.text.toString()
            val target = binding.editTextTarget.text.toString().toInt()

            val matrix = parseMatrixInput(matrixInput, rows, columns)
            val solution = Solution()
            val result = solution.searchMatrix(matrix, target)

            val targetp = binding.editTextTarget.text.toString()

            if (result) {
                binding.textViewResult.text = getString(R.string.result, targetp)
            } else {
                binding.textViewResult.text = getString(R.string.result2, targetp)
            }
        }
    }

    private fun parseMatrixInput(input: String, rows: Int, columns: Int): Array<IntArray> {
        val elements = input.split(" ").map { it.toInt() }
        val matrix = Array(rows) { IntArray(columns) }

        var index = 0
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                matrix[i][j] = elements[index]
                index++
            }
        }

        return matrix
    }
}