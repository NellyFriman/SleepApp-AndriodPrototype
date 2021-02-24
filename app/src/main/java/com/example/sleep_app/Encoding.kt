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
import com.google.gson.*
import androidx.fragment.app.FragmentActivity
import com.example.sleep_app.R

import java.util.*
import kotlin.collections.ArrayList


class Encoding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_encoding)

        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val usedSymbols = arrayListOf<Int>()

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
                val i = Intent(this@Encoding, Distraction::class.java)
                i.putExtra("SymbolList", usedSymbols)

                val gson = Gson()
                val json: String = gson.toJson(usedSymbols)
                editor.putString("symbolPositioning", json)
                editor.apply()

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

        val list = (0 until 17).toMutableList()
        val randList = mutableListOf<Int>()

        for (i in 0 until 9) {
            val uniqueRand = list.random()
            randList.add(uniqueRand)
            list.remove(uniqueRand)
        }

        var counter = 0
        for (i in symbols){
            val pickedSymbol = randList[counter]
            i?.setImageResource(images[pickedSymbol])
            usedSymbols.add(pickedSymbol)
            counter++
        }





    }
}