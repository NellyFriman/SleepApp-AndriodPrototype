package com.example.sleep_app

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.sleep_app.R

import java.util.*


class Distraction : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_distraction)

        //----------TIMER-------------
        //changes activity after 10 seconds
        val pb: ProgressBar = findViewById(R.id.progressBar)
        val animation = ObjectAnimator.ofInt(pb, "progress", 0, 100)
        animation.duration = 10000
        animation.interpolator = DecelerateInterpolator()
        animation.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animator: Animator) {}

            //changes activity after 10 seconds
            override fun onAnimationEnd(animator: Animator) {
                val i = Intent(null, Recall::class.java)
                startActivity(i)
                finish()
            }

            override fun onAnimationCancel(animator: Animator) {}
            override fun onAnimationRepeat(animator: Animator) {}
        })
        animation.start()
        //-----------------------------------


        val images = mutableListOf(
                R.drawable.airplane,
                R.drawable.boat
        )

        images.shuffle()


        val rand = Random()
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
        for (i in symbols){
            val usedSymbol = rand.nextInt(images.size)
            i?.setImageResource(images[usedSymbol])
        }

    }
}