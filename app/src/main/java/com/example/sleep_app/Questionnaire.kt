package com.example.sleep_app

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class Questionnaire : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionnaire)

        val goToBedBar = findViewById<SeekBar>(R.id.goingToBedBar)
        val wakeUpBar = findViewById<SeekBar>(R.id.wakingUpBar)

        val radioGroupStress = findViewById<RadioGroup>(R.id.radioStress)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener() {
            //save to database
            val goToBed = goToBedBar.progress
            val wakeUp = wakeUpBar.progress

            val selectedOption: Int = radioGroupStress!!.checkedRadioButtonId

            finish()
        }
    }
}
