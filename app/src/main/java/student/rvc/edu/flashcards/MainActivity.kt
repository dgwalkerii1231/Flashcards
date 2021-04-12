package student.rvc.edu.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declarations - bind button objects
        val addBtn = findViewById<Button>(R.id.addBtn)
        val subtractBtn = findViewById<Button>(R.id.subtractBtn)
        val multiplyBtn = findViewById<Button>(R.id.multiplyBtn)
        val divideBtn = findViewById<Button>(R.id.divideBtn)
        val scoreBtn = findViewById<Button>(R.id.scoreBtn)
        val helpBtn = findViewById<Button>(R.id.helpBtn)

        //Declaration - for sending info to downstream activities
        val doMath = Intent(this, MathActivity::class.java)
        val doScores = Intent(this, ScoresActivity::class.java)
        val doHelp = Intent(this, HelpActivity::class.java)

        //Launch math activity, addition
        addBtn.setOnClickListener(View.OnClickListener {
            doMath.putExtra("sendToMath","add")
            startActivity(doMath)
        })

        //Launch math activity, subtraction
        subtractBtn.setOnClickListener(View.OnClickListener {
            doMath.putExtra("sendToMath","subtract")
            startActivity(doMath)
        })

        //Launch math activity, multiplication
        multiplyBtn.setOnClickListener(View.OnClickListener {
            doMath.putExtra("sendToMath","multiply")
            startActivity(doMath)
        })

        //Launch math activity, division
        divideBtn.setOnClickListener(View.OnClickListener {
            doMath.putExtra("sendToMath","divide")
            startActivity(doMath)
        })

        //Launch high scores activity
        scoreBtn.setOnClickListener(View.OnClickListener {
            startActivity(doScores)
        })

        //Launch help activity
        helpBtn.setOnClickListener(View.OnClickListener {
            startActivity(doHelp)
        })
    }
}