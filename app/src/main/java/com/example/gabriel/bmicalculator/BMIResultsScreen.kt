package com.example.gabriel.bmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.gabriel.bmicalculator.R
import com.example.gabriel.bmicalculator.R.id.btnExit
import kotlinx.android.synthetic.main.activity_bmiresults_screen.*
import java.text.DecimalFormat
import android.content.Intent

class BMIResultsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiresults_screen)

        showBMIResult()
        findBMICategory()

        setExitListener()
        setCheckAgainListener()
    }

    fun showBMIResult(){
        var decFormat = DecimalFormat("#.#")
        var formattedBMI = decFormat.format(getIntent().getExtras().getDouble("BMIResult"))
        lblBMIResult.setText(formattedBMI.toString())
    }

    fun findBMICategory(){
        var categoryOfBMI = "Unknown"
        var resultBMI = getIntent().getExtras().getDouble("BMIResult")

        if(resultBMI < 15){
            categoryOfBMI = "Very Severely Underweight"
        } else if(resultBMI in 15..16){
            categoryOfBMI = "Severely Underweight"
        } else if(resultBMI > 16 && resultBMI <= 18.5){
            categoryOfBMI = "Underweight"
        } else if(resultBMI > 18.5 && resultBMI <= 25){
            categoryOfBMI = "Normal (Healthy Weight)"
        } else if(resultBMI in 25..30){
            categoryOfBMI = "Overweight"
        } else if(resultBMI in 30..35){
            categoryOfBMI = "Moderately Obese"
        } else if(resultBMI in 35..40){
            categoryOfBMI = "Severely Obese"
        } else if(resultBMI >= 40){
            categoryOfBMI = "Very Severely Obese"
        }

        lblBMIResultCategory.setText(categoryOfBMI)
    }

    fun setExitListener(){
        btnExit.setOnClickListener{
            this.finishAffinity()
        }
    }

    fun setCheckAgainListener(){
        btnCheckAgain.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}

