package com.example.sleep_app

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

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
                val i = Intent(this@Distraction, Recall::class.java)
                startActivity(i)
                finish()
            }

            override fun onAnimationCancel(animator: Animator) {}
            override fun onAnimationRepeat(animator: Animator) {}
        })
        animation.start()

        val images = mutableListOf(
                R.drawable.e,
                R.drawable.f
        )

        val letters: Array<ImageView?> = arrayOfNulls<ImageView>(45)
        letters[0] = findViewById(R.id.Letter1)
        letters[1] = findViewById(R.id.Letter2)
        letters[2] = findViewById(R.id.Letter3)
        letters[3] = findViewById(R.id.Letter4)
        letters[4] = findViewById(R.id.Letter5)
        letters[5] = findViewById(R.id.Letter6)
        letters[6] = findViewById(R.id.Letter7)
        letters[7] = findViewById(R.id.Letter8)
        letters[8] = findViewById(R.id.Letter9)
        letters[9] = findViewById(R.id.Letter10)
        letters[10] = findViewById(R.id.Letter11)
        letters[11] = findViewById(R.id.Letter12)
        letters[12] = findViewById(R.id.Letter13)
        letters[13] = findViewById(R.id.Letter14)
        letters[14] = findViewById(R.id.Letter15)
        letters[15] = findViewById(R.id.Letter16)
        letters[16] = findViewById(R.id.Letter17)
        letters[17] = findViewById(R.id.Letter18)
        letters[18] = findViewById(R.id.Letter19)
        letters[19] = findViewById(R.id.Letter20)
        letters[20] = findViewById(R.id.Letter21)
        letters[21] = findViewById(R.id.Letter22)
        letters[22] = findViewById(R.id.Letter23)
        letters[23] = findViewById(R.id.Letter24)
        letters[24] = findViewById(R.id.Letter25)
        letters[25] = findViewById(R.id.Letter26)
        letters[26] = findViewById(R.id.Letter27)
        letters[27] = findViewById(R.id.Letter28)
        letters[28] = findViewById(R.id.Letter29)
        letters[29] = findViewById(R.id.Letter30)
        letters[30] = findViewById(R.id.Letter31)
        letters[31] = findViewById(R.id.Letter32)
        letters[32] = findViewById(R.id.Letter33)
        letters[33] = findViewById(R.id.Letter34)
        letters[34] = findViewById(R.id.Letter35)
        letters[35] = findViewById(R.id.Letter36)
        letters[36] = findViewById(R.id.Letter37)
        letters[37] = findViewById(R.id.Letter38)
        letters[38] = findViewById(R.id.Letter39)
        letters[39] = findViewById(R.id.Letter40)
        letters[40] = findViewById(R.id.Letter41)
        letters[41] = findViewById(R.id.Letter42)
        letters[42] = findViewById(R.id.Letter43)
        letters[43] = findViewById(R.id.Letter44)
        letters[44] = findViewById(R.id.Letter45)


        for (i in letters){
            val chosenLetter = rollDie()
            if (chosenLetter == true) {
                i?.setImageResource(images[0])
            }
            else {
                i?.setImageResource(images[1])
                i?.tag = "F"
            }
        }
        for (i in letters){
            i?.setOnClickListener{
                if(i.tag == "F")
                    i.setVisibility(View.INVISIBLE)

            }
        }
    }



    private fun rollDie(): Any {
        val rand = Random()
        var roll = rand.nextInt(100);
        return roll < 70;
    }
}