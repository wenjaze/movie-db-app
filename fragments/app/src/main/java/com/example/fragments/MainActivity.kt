package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (findViewById<FrameLayout>(R.id.frameLayout) != null) {
            if (savedInstanceState != null) return;

            supportFragmentManager.commit {
                add<frag1>(R.id.frameLayout, null, intent.extras)
            }
        }
        var pressed:Boolean = false
        val button = findViewById(R.id.switchButton) as Button

        button.setOnClickListener{
            if (pressed == true){
                getSupportFragmentManager().popBackStack()
                pressed = false
            }

            else {
                supportFragmentManager.commit {
                    replace<frag2>(R.id.frameLayout, null, intent.extras)
                    addToBackStack(null)
                }
                pressed = true
            }
        }

    }

    //var pressed:Boolean = false



   /* fun change(view: View) {
        //Log.d("message:","$pressed")
        if (pressed == true){
            getSupportFragmentManager().popBackStack()
            pressed = false
        }

        else {
            supportFragmentManager.commit {
                replace<frag2>(R.id.frameLayout, null, intent.extras)
                addToBackStack(null)
            }
            pressed = true
        }


    }*/
}





