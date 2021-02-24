package com.example.sleep_app

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class Recall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var success = false
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_recall)

        //----------TIMER-------------
        //changes activity after 10 seconds
        val pb: ProgressBar = findViewById(R.id.progressBar)
        val animation = ObjectAnimator.ofInt(pb, "progress", 0, 100)
        animation.duration = 15000
        animation.interpolator = DecelerateInterpolator()
        animation.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animator: Animator) {}

            //changes activity after 15 seconds
            override fun onAnimationEnd(animator: Animator) {

                if(!success){ToneGenerator(AudioManager.STREAM_RING, 100).startTone(ToneGenerator.TONE_PROP_BEEP, 1000)}

                val i = Intent(this@Recall, MainActivity::class.java)
                startActivity(i)
                finish()
            }

            override fun onAnimationCancel(animator: Animator) {}
            override fun onAnimationRepeat(animator: Animator) {}
        })
        animation.start()


        val i = intent
        val usedSymbols1: ArrayList<Int>? = i.extras?.getIntegerArrayList("SymbolList")

        val images = mutableListOf(
                R.drawable.airplane,
                R.drawable.boat,
                R.drawable.bolt,
                R.drawable.build,
                R.drawable.bus,
                R.drawable.cloud,
                R.drawable.delete,
                R.drawable.eco,
                R.drawable.female,
                R.drawable.fitness,
                R.drawable.heart,
                R.drawable.home,
                R.drawable.lightbulb,
                R.drawable.lock,
                R.drawable.male,
                R.drawable.paw,
                R.drawable.star
        )


        val symbols: Array<ImageView?> = arrayOfNulls<ImageView>(9)
        symbols[0] = findViewById(R.id.symbol1)
        symbols[1] = findViewById(R.id.symbol2)
        symbols[2] = findViewById(R.id.symbol3)
        symbols[3] = findViewById(R.id.symbol4)
        symbols[4] = findViewById(R.id.symbol5)
        symbols[5] = findViewById(R.id.symbol6)
        symbols[6] = findViewById(R.id.symbol7)
        symbols[7] = findViewById(R.id.symbol8)
        symbols[8] = findViewById(R.id.symbol9)


        /*
        for (i in symbols){
            i?.setImageResource(images[usedSymbols1!!?.get(counter)])
            counter++
        }*/

        val  guessImageView : ImageView =  findViewById(R.id.symbolToGuess)
        val guessImage = images[usedSymbols1?.random()!!]
        guessImageView.setImageResource(guessImage)
        for ((counter, i) in symbols.withIndex()){
           if(guessImage==images[usedSymbols1!!?.get(counter)]) {
                success = true
                i?.setOnClickListener {
                    i?.setImageResource(images[usedSymbols1!!?.get(counter)])
                }
  }
        }
    }
}