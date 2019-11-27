package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.set
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        R.drawable.empty

        btnCALCULATE.setOnClickListener(){
/*
            val input:List<String> =
                listOf(editTextHeight.text.toString(), editTextWeight.text.toString())

            val value:List<Double> =
                listOf(input[0].toDouble(), input[1].toDouble()) */

            val weight:Double = editTextWeight.toString().toDouble()
            val height:Double = editTextHeight.toString().toDouble()

            //val bmi = calculateBMI(input[0].toDouble(), input[1].toDouble())
            val bmi = calculateBMI(height, weight)

            textView2.text = "%.2f IBM".format(bmi)
            val drawableResources = when {
                bmi < 18.5 -> R.drawable.under
                bmi in 18.5..24.9 -> R.drawable.normal
                bmi > 25 -> R.drawable.over
                else -> R.drawable.empty
            }
            imageView.setImageResource(drawableResources)

        }

        btnRESET.setOnClickListener(){
            imageView.setImageResource(R.drawable.empty)
            textView2.text = ""
            editTextWeight.text.clear()
            editTextHeight.text.clear()
            editTextHeight.requestFocus()


        }
    }

    public fun calculateBMI(height:Double, weight:Double): Double {
        val heightSquare:Double = (height/100) * (height/100)
        val bmi:Double = weight/heightSquare
        return bmi
    }


}
