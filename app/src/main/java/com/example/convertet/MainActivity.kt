package com.example.convertet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meterRadioButton: RadioButton = findViewById(R.id.radioButton_meter)
        val inputEditText: EditText = findViewById(R.id.editTextTextPersonName)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            if (inputEditText.text.isEmpty()) {
                Toast.makeText(
                        applicationContext, "Vvedite dlinu",
                        Toast.LENGTH_SHORT).show()
            }
            else {
                val inputValue = inputEditText.text.toString().toFloat()
                if (meterRadioButton.isChecked) {
                    inputEditText.setText(convertInchestoMeter(inputValue).toString())
                } else {
                    inputEditText.setText(convertMetertoInches(inputValue).toString())
                }
            }
        }
    }


    private fun convertInchestoMeter(inches: Float): Float = (inches / 39.37).toFloat()
    private fun convertMetertoInches(meter: Float): Float = (meter * 39.37).toFloat()


}