package com.example.sleep_app

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.RadioButton
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
        val stressBtn1 = findViewById<RadioButton>(R.id.notAtAllButton)
        val stressBtn2 = findViewById<RadioButton>(R.id.justALittleButton)
        val stressBtn3 = findViewById<RadioButton>(R.id.SomewhatButton)
        val stressBtn4 = findViewById<RadioButton>(R.id.quiteButton)
        val stressBtn5 = findViewById<RadioButton>(R.id.veryButton)

        val radioGroupExertion = findViewById<RadioGroup>(R.id.radioPhysicalExertion)
        val exertionBtn1 = findViewById<RadioButton>(R.id.veryHighButton)
        val exertionBtn2 = findViewById<RadioButton>(R.id.highButton)
        val exertionBtn3 = findViewById<RadioButton>(R.id.someButton)
        val exertionBtn4 = findViewById<RadioButton>(R.id.littleButton)
        val exertionBtn5 = findViewById<RadioButton>(R.id.noneButton)




        val saveButton = findViewById<Button>(R.id.saveButton)




        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        saveButton.setOnClickListener() {



            val goToBedProgress = goToBedBar.progress
            val wakeUpProgress = wakeUpBar.progress
            editor.putInt("goToBedProgress", goToBedProgress)
            editor.putInt("wakeUpProgress", wakeUpProgress)

            editor.putBoolean("stressOption1", stressBtn1.isChecked)
            editor.putBoolean("stressOption2", stressBtn2.isChecked)
            editor.putBoolean("stressOption3", stressBtn3.isChecked)
            editor.putBoolean("stressOption4", stressBtn4.isChecked)
            editor.putBoolean("stressOption5", stressBtn5.isChecked)

            editor.putBoolean("exertionOption1", exertionBtn1.isChecked)
            editor.putBoolean("exertionOption2", exertionBtn2.isChecked)
            editor.putBoolean("exertionOption3", exertionBtn3.isChecked)
            editor.putBoolean("exertionOption4", exertionBtn4.isChecked)
            editor.putBoolean("exertionOption5", exertionBtn5.isChecked)

            finish()
        }
    }
}
