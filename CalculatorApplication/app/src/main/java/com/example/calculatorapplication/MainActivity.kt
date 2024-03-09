package com.example.calculatorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var zero: Button
    private lateinit var dot: Button
    private lateinit var equalsSign: Button
    private lateinit var additionSign: Button
    private lateinit var subtractionSign: Button
    private lateinit var divisionSign: Button
    private lateinit var multiplicationSign: Button
    private lateinit var percentageSign: Button
    private lateinit var clearButton: Button
    private lateinit var backSpace: ImageButton

    private lateinit var expression: TextView
    private lateinit var result: TextView
    private var lastResult: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the buttons correctly
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        dot = findViewById(R.id.dot)
        equalsSign = findViewById(R.id.equals)
        additionSign = findViewById(R.id.addition)
        subtractionSign = findViewById(R.id.minus)
        multiplicationSign = findViewById(R.id.multiplication)
        divisionSign = findViewById(R.id.division)
        percentageSign = findViewById(R.id.percentageSign)
        clearButton = findViewById(R.id.clearButton)
        backSpace = findViewById(R.id.backSpace)

        expression = findViewById(R.id.expression)
        result = findViewById(R.id.result)

        // Set OnClickListener for the 'one' button
        one.setOnClickListener {
            appendOnTheExpression("1", true)
        }
        two.setOnClickListener {
            appendOnTheExpression("2", true)
        }
        three.setOnClickListener {
            appendOnTheExpression("3", true)
        }
        four.setOnClickListener {
            appendOnTheExpression("4", true)
        }
        five.setOnClickListener {
            appendOnTheExpression("5", true)
        }
        six.setOnClickListener {
            appendOnTheExpression("6", true)
        }
        seven.setOnClickListener {
            appendOnTheExpression("7", true)
        }
        eight.setOnClickListener {
            appendOnTheExpression("8", true)
        }
        nine.setOnClickListener {
            appendOnTheExpression("9", true)
        }
        zero.setOnClickListener {
            appendOnTheExpression("0", true)
        }
        dot.setOnClickListener {
            appendOnTheExpression(".", true)
        }
        equalsSign.setOnClickListener {
            calculate()
        }
        additionSign.setOnClickListener {
            appendOnTheExpression("+", false)
        }
        subtractionSign.setOnClickListener {
            appendOnTheExpression("-", false)
        }
        multiplicationSign.setOnClickListener {
            appendOnTheExpression("*", false)
        }
        divisionSign.setOnClickListener {
            appendOnTheExpression("/", false)
        }
        percentageSign.setOnClickListener {
            appendOnTheExpression("%", false)

        }
        clearButton.setOnClickListener {
            result.text = ""
            expression.text = ""
        }
        backSpace.setOnClickListener {
            val currentExpression = expression.text.toString()
            if (currentExpression.isNotEmpty()) {
                expression.text = currentExpression.substring(0, currentExpression.length - 1)
            }
            result.text = ""
        }
    }


    private fun calculatePercentage() {
        try {
            // Extract the expression from the expression TextView
            val inputExpression = expression.text.toString()

            // Remove the percentage sign from the expression
            val expressionWithoutPercentage = inputExpression.replace("%", "")

            // Evaluate the expression
            val expressionBuilder = ExpressionBuilder(expressionWithoutPercentage)
            val input = expressionBuilder.build()
            val output = input.evaluate()

            // Calculate the percentage value by dividing the output by 100
            val percentageValue = output / 100.0

            // Display the percentage value
            result.text = percentageValue.toString()

            // Clear the expression TextView after percentage calculation
           // expression.text = ""
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, "Invalid input", Toast.LENGTH_SHORT).show()
        }
    }

    // Append function
    private fun appendOnTheExpression(stringFromButton: String, clearStatus: Boolean) {
        // Clear the expression view and append the last result
        if (!clearStatus && lastResult.isNotEmpty()) {
            expression.text = lastResult
            lastResult = ""
        }

        if (clearStatus) {
            result.text = ""
            // Check if the expression is '0' and the input is not a dot
            if (expression.text.toString() == "0" && stringFromButton != ".") {
                expression.text = stringFromButton
            } else {
                expression.append(stringFromButton)
            }
        } else {
            // If the result is not empty, use it as the new expression
            if (result.text.isNotEmpty()) {
                expression.text = result.text
                result.text = ""
            }

            // Append the new operator and operand to the expression
            expression.append(stringFromButton)
        }
    }

    private fun clear() {
        expression.text = ""
        result.text = ""
    }
    private fun calculate() {
        try {
            val inputExpression = expression.text.toString()

            // Check if the expression contains a percentage sign
            if (inputExpression.contains("%")) {
                calculatePercentage()
            } else {
                // Evaluate the expression as usual
                val input = ExpressionBuilder(inputExpression).build()
                val output = input.evaluate()

                // Check if the output is a whole number
                if (output == output.toLong().toDouble()) {
                    // Display whole number as integer
                    result.text = output.toLong().toString()
                } else {
                    // Display decimal number with decimal points
                    result.text = output.toString()
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }

}