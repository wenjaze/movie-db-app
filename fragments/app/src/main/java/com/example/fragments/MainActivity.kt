package com.example.fragments

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        findViewById<FrameLayout>(R.id.frameLayout)?.let {
            savedInstanceState?.let { return; }
            supportFragmentManager.commit {
                add<SearchFragment>(R.id.frameLayout, null, intent.extras)
            }
        }
    }
}
