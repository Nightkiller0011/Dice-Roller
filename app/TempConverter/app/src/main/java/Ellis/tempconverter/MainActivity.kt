package Ellis.tempconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var diceInput : EditText
    private lateinit var diceInput2 : EditText
    private lateinit var rollOutput : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonRollMore = findViewById<Button>(R.id.BF2C)

        val buttonRollOne = findViewById<Button>(R.id.BC2F)

        diceInput = findViewById(R.id.ETTempInput)
        diceInput2 = findViewById(R.id.ETTempInput2)
        rollOutput = findViewById(R.id.TVTempOutput)
        buttonRollOne.setOnClickListener { rollOne() }
        buttonRollMore.setOnClickListener { rollMore() }

    }
    private fun rollOne() {
        val dice = diceInput.text.toString().toInt()
        val roll = (1..dice).random()
        rollOutput.text = "Roll: $roll"
    }

    private fun rollMore() {
        val dice = diceInput.text.toString().toInt()
        val amount = diceInput2.text.toString().toInt()


        val roll1 = (1..dice).random()
        val roll2 = (1..dice).random()
        val roll3 = (1..dice).random()

        rollOutput.text = "Rolls: $roll1, $roll2, $roll3"
    }

}