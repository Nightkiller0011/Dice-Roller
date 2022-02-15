package macbeth.tempconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import macbeth.tempconverter.databinding.ActivityMainBinding

/*
The MainActivity represents a single screen on the App.  This entire program will be a single
screen app.  AppCompatActivity is an Android SDK class that represents an Activity (or screen).

When Android wants to display this screen, it will run the code in the onCreate function.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var temp_input : EditText
    private lateinit var temp_output : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Associate the layout XML with this activity so Android knows what to draw
        setContentView(R.layout.activity_main)

        // Get references to the button objects in the layout XML
        // The R.id.<name> is based on the id names in the layout XML
        val f_to_c_button = findViewById<Button>(R.id.f_to_c_button)
        val c_to_f_button = findViewById<Button>(R.id.c_to_f_button)
        val reset_button = findViewById<Button>(R.id.reset_button)

        temp_input = findViewById<EditText>(R.id.temp_input)
        temp_output = findViewById<TextView>(R.id.temp_output)

        // Define which functions to run if a button is pressed
        f_to_c_button.setOnClickListener { convert_f_to_c() }
        c_to_f_button.setOnClickListener { convert_c_to_f() }
        reset_button.setOnClickListener { reset() }

    }

    private fun convert_f_to_c() {
        // Convert the input to a float, calculate the result, and convert it to a string
        try {
            val f_temp = temp_input.text.toString().toFloat()
            val c_temp = (f_temp - 32.0f) * (5.0f / 9.0f)
            temp_output.text = "${"%.1f".format(c_temp)} C"
        } catch (e : Exception) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show()
        }
    }

    private fun convert_c_to_f() {
        // Convert the input to a float, calculate the result, and convert it to a string
        try {
            val c_temp = temp_input.text.toString().toFloat()
            val f_temp = (c_temp * 9.0f / 5.0f) + 32.0f
            temp_output.text = "${"%.1f".format(f_temp)} F"
        } catch (e : Exception) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show()
        }
    }

    private fun reset() {
        // Clear out the input/output fields
        temp_input.text.clear()
        temp_output.text = ""
    }
}