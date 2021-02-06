package com.example.mydiceapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import render.animations.Attention
import render.animations.Fade
import render.animations.Render

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAnimation()

        Handler().postDelayed({
            meVoy()

            Handler().postDelayed({
                startActivity(Intent(this, NavigationDrawerActivity::class.java))
            }, 500)

        }, 500)
    }

    fun initAnimation() {
        val render = Render(this)
        render.setAnimation(Attention().Ruberband(ivDice))
        render.setDuration(1400)
        render.start()
    }

    fun meVoy() {
        val render = Render(this)
        render.setAnimation(Fade().OutUp(ivDice))
        render.setDuration(1400)
        render.start()
    }
}