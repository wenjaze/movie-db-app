package com.example.fragments

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FrameLayout>(R.id.frameLayout)?.let {
            savedInstanceState?.let { return; }

            supportFragmentManager.commit {
                add<FirstFragment>(R.id.frameLayout, null, intent.extras)
            }
        }
    }
}
