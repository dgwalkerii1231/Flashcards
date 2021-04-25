package student.rvc.edu.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MathActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

        //Declarations and bindings
        val titleTxt: TextView  = findViewById(R.id.titleTxt)
        val num1Txt: TextView = findViewById(R.id.num1Txt)
        val num2Txt: TextView  = findViewById(R.id.num2Txt)
        val answerTxt: TextView  = findViewById(R.id.answerTxt)
        val symbolTxt: TextView  = findViewById(R.id.symbolTxt)
        val scoreTxt: TextView  = findViewById(R.id.scoreTxt)
        val submitBtn: Button = findViewById(R.id.submitBtn)

        var answer: Int = -1
        var response: Int
        var score: Int = 0
        var count: Int = 0

        //What activity did user choose in Main?
        var activityChoice: String? = intent.getStringExtra("sendToMath")

        while (count <= 10) {
            //Set up chosen activity
            when
            {
                activityChoice == "add" ->
                {
                    titleTxt.text = "Addition"
                    symbolTxt.text = "+"
                    answer = addition(num1Txt, num2Txt)
                }
                activityChoice == "sub" ->
                {
                    titleTxt.text = "Subtraction"
                    symbolTxt.text = "−"
                    answer = subtraction(num1Txt, num2Txt)
                }
                activityChoice == "mlt" ->
                {
                    titleTxt.text = "Multiplication"
                    symbolTxt.text = "×"
                    answer = multiplication(num1Txt, num2Txt)
                }
                activityChoice == "div" ->
                {
                    titleTxt.text = "Division"
                    symbolTxt.text = "÷"
                    answer = division(num1Txt, num2Txt)
                }
            }

//            if (activityChoice == "add") {
//                titleTxt.text = "Addition"
//                symbolTxt.text = "+"
//                answer = addition(num1Txt, num2Txt)
//            } else if (activityChoice == "sub") {
//                titleTxt.text = "Subtraction"
//                symbolTxt.text = "−"
//                answer = subtraction(num1Txt, num2Txt)
//            } else if (activityChoice == "mlt") {
//                titleTxt.text = "Multiplication"
//                symbolTxt.text = "×"
//                answer = multiplication(num1Txt, num2Txt)
//            } else if (activityChoice == "div") {
//                titleTxt.text = "Division"
//                symbolTxt.text = "÷"
//                answer = division(num1Txt, num2Txt)
//            }

            submitBtn.setOnClickListener(View.OnClickListener {
                response = Integer.valueOf(answerTxt.getText().toString())
                if (answer == response) {
                    Toast.makeText(this, "You are CORRECT!.", Toast.LENGTH_LONG).show()
                    score++
                } else {
                    Toast.makeText(this, "Sorry, incorrect answer.", Toast.LENGTH_LONG).show()
                }

                scoreTxt.text = ("Score: " + score.toString() + " out of 10")
                count++
            })
        }
    }

    fun addition(num1Txt: TextView, num2Txt: TextView): Int
    {
        var add1: Int
        var add2: Int
        var sum: Int

        //Assign random value to first addend
        add1 = (0 until 10).shuffled().last()
        //Assign random value to second addend
        add2 = (0 until 10).shuffled().last()
        //Find the answer
        sum = add1 + add2

        //For addition, display an addend in textview 1, and the other addend in textview 2
        num1Txt.text = add1.toString()
        num2Txt.text = add2.toString()

        //Return the some for answer comparison
        return sum
    }

    fun subtraction(num1Txt: TextView, num2Txt: TextView): Int
    {
        var add1: Int
        var add2: Int
        var sum: Int

        //Assign random value to first addend
        add1 = (0 until 10).shuffled().last()
        //Assign random value to second addend
        add2 = (0 until 10).shuffled().last()
        //Find the answer
        sum = add1 + add2

        //For subtraction, display sum in textview 1, and an addend in textview 2
        num1Txt.text = sum.toString()
        num2Txt.text = add2.toString()

        //Return the other addend for answer comparison
        return add1
    }

    fun multiplication(num1Txt: TextView, num2Txt: TextView): Int
    {
        var factor1: Int
        var factor2: Int
        var multiplicand: Int

        //Assign random value to first factor
        factor1 = (0 until 10).shuffled().last()
        //Assign random value to second factor
        factor2 = (0 until 10).shuffled().last()
        //Find the answer
        multiplicand = factor1 * factor2

        //For multiplication, display a factor in textview 1, and the other factor in textview 2
        num1Txt.text = factor1.toString()
        num2Txt.text = factor2.toString()

        //Return multiplicand for answer comparison
        return multiplicand
    }

    fun division(num1Txt: TextView, num2Txt: TextView): Int
    {
        var factor1: Int
        var factor2: Int
        var multiplicand: Int

        //Assign random value to first factor (this is division, so we're removing 0's as factors)
        factor1 = (1 until 10).shuffled().last()
        //Assign random value to second factor (this is division, so we're removing 0's as factors)
        factor2 = (1 until 10).shuffled().last()
        //Find the answer
        multiplicand = factor1 * factor2

        //For division, display multiplicand in textview 1, and the a factor in textview 2
        num1Txt.text = multiplicand.toString()
        num2Txt.text = factor2.toString()

        //Return the other factor for answer comparison
        return factor1
    }
}