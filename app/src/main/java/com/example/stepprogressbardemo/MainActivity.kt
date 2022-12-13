package com.example.stepprogressbardemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.co.prnd.StepProgressBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<StepProgressBar>(R.id.stepProgressBar).apply {
            max = 5
            step = 2
            stepDoneColor = Color.BLUE
            stepUndoneColor = Color.GRAY
        }

    }
}
