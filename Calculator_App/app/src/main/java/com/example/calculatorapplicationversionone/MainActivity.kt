package com.example.calculatorapplicationversionone

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var mathExpression : TextView
    private lateinit var result : TextView
    private lateinit var backSpace : Button
    private lateinit var clearButton : Button
    private lateinit var percentageSign : Button
    private lateinit var division : Button
    private lateinit var multiplication : Button
    private lateinit var minus : Button
    private lateinit var addition : Button
    private lateinit var equals : Button
    private lateinit var one : Button
    private lateinit var two : Button
    private lateinit var three : Button
    private lateinit var four : Button
    private lateinit var five : Button
    private lateinit var six : Button
    private lateinit var seven : Button
    private lateinit var eight : Button
    private lateinit var nine : Button
    private lateinit var zero : Button
    private lateinit var dot : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Identifying and Querying button inputs
        mathExpression = findViewById(R.id.math_expression)
        result = findViewById(R.id.result)
        backSpace = findViewById(R.id.backSpace)
        clearButton = findViewById(R.id.clearButton)
        percentageSign = findViewById(R.id.percentageSign)
        division = findViewById(R.id.division)
        multiplication = findViewById(R.id.multiplication)
        minus = findViewById(R.id.minus)
        addition = findViewById(R.id.addition)
        equals = findViewById(R.id.equals)
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

        mathExpression.movementMethod = ScrollingMovementMethod()
        mathExpression.isActivated  = true
        mathExpression.isPressed = true

        //setting event listeners on number buttons and operator buttons
        // A) Number Buttons
        one.setOnClickListener { appendOnTheExpression("1",true) }
        two.setOnClickListener { appendOnTheExpression("2",true) }
        three.setOnClickListener { appendOnTheExpression("3",true) }
        four.setOnClickListener { appendOnTheExpression("4",true) }
        five.setOnClickListener { appendOnTheExpression("5",true) }
        six.setOnClickListener { appendOnTheExpression("6",true) }
        seven.setOnClickListener { appendOnTheExpression("7",true) }
        eight.setOnClickListener { appendOnTheExpression("8",true) }
        nine.setOnClickListener { appendOnTheExpression("9",true) }
        zero.setOnClickListener { appendOnTheExpression("0",true) }
        dot.setOnClickListener { appendOnTheExpression(".",true) }

        // B) Operator Buttons
        percentageSign.setOnClickListener { appendOnTheExpression("%", false) }
        addition.setOnClickListener { appendOnTheExpression("+",false) }
        multiplication.setOnClickListener { appendOnTheExpression("*",false) }
        minus.setOnClickListener { appendOnTheExpression("-",false) }
        division.setOnClickListener { appendOnTheExpression("/",false) }
        clearButton.setOnClickListener { clear()}

        backSpace.setOnClickListener {
            val currentExpression = mathExpression.text.toString()
            if (currentExpression.isNotEmpty()){
                mathExpression.text = currentExpression.substring(0,currentExpression.length-1)
            }
            result.text = ""
        }

        equals.setOnClickListener {
            calculate()
        }
    }

    // Append function
    private fun appendOnTheExpression(stringFromButton: String, clearStatus: Boolean) {
        if (clearStatus) {
            result.text = ""
            mathExpression.append(stringFromButton)
        } else {
            mathExpression.append(result.text)
            mathExpression.append(stringFromButton)
            result.text = ""
        }
    }

    private fun clear(){
        mathExpression.text = ""
        result.text = ""
    }
    private fun calculate(){
        try {
            val input = ExpressionBuilder(mathExpression.text.toString()).build()
            val output = input.evaluate()
            val longResult = output.toLong()

            if (output == longResult.toDouble()) {
                result.text = longResult.toString()
            }else{
                result.text = result.toString()
            }
        }catch (e:Exception){
           Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
        }
    }
}