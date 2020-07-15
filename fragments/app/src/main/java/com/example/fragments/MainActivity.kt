package com.example.fragments

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FrameLayout>(R.id.frameLayout)?.let {
            savedInstanceState?.let {return;}

            supportFragmentManager.commit {
                add<Frag_first>(R.id.frameLayout, null, intent.extras)
            }
        }

        val button = findViewById(R.id.switchButton) as Button

        button.setOnClickListener{
            change()
        }

    }
    var pressed:Boolean = false

   fun change() {
        //Log.d("message:","$pressed")
        if(pressed==true) {
            supportFragmentManager.popBackStack()
            pressed = false
        }

        else {
            supportFragmentManager.commit {
                replace<Frag_second>(R.id.frameLayout, null, intent.extras)
                addToBackStack(null)
            }
            pressed = true
        }


    }
}
