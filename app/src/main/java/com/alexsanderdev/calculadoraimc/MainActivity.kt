package com.alexsanderdev.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCalculate: Button
    private lateinit var textWeightInputLayout: TextInputLayout
    private lateinit var textHeightInputLayout: TextInputLayout
    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textWeightInputLayout = findViewById(R.id.textWeightInputLayout)
        textHeightInputLayout = findViewById(R.id.textHeightInputLayout)

        textHeightInputLayout.error = null
        textWeightInputLayout.error = null

        buttonCalculate = findViewById(R.id.buttonCalculate)
        editWeight = findViewById(R.id.edit_weight)
        editHeight = findViewById(R.id.edit_height)

        buttonCalculate.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)
            val weight = editWeight.text.toString()
            val height = editHeight.text.toString()

            if (weight.isNotEmpty() && height.isNotEmpty()) {
                intent.putExtra("weight", weight.toDouble())
                intent.putExtra("height", height.toDouble())
                startActivity(intent)
            } else {
                textWeightInputLayout.error = getString(R.string.error_weight)
                textHeightInputLayout.error = getString(R.string.error_height)
            }

        }
    }
}

