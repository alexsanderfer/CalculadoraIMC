/*
 * Copyright (c) 2024. Created by Alexsander Fernandes at 1/3. All rights reserved.
 * GitHub: https://github.com/alexsanderfer/
 * Portfolio: https://alexsanderfer.netlify.app/
 */

package com.alexsanderdev.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    private lateinit var textWeight: TextView
    private lateinit var textHeight: TextView
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textWeight = findViewById(R.id.text_weight)
        textHeight = findViewById(R.id.text_height)
        textResult = findViewById(R.id.text_result)

        val bundle = intent.extras
        if (bundle != null) {
            val weight = bundle.getDouble("weight")
            val height = bundle.getDouble("height")

            textWeight.text = getString(R.string.reportedWeight, weight.toString())
            textHeight.text = getString(R.string.reportedHeight, height.toString())

            val imc = weight / (height * height)
            val imcInt = imc.toInt() // Converte o IMC para um número inteiro

            textResult.text = getString(R.string.imc_result, imcInt, when {
                imc < 18.5 -> getString(R.string.low_weight)
                imc in 18.5..24.9 -> getString(R.string.normal_weight)
                imc in 25.0..29.9 -> getString(R.string.overweight)
                imc in 30.0..34.9 -> getString(R.string.obese_class_1)
                imc in 35.0..39.9 -> getString(R.string.obese_class_2)
                else -> getString(R.string.obese_class_3)
            })
        }
    }
}