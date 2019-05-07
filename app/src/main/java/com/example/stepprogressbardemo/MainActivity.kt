package com.example.stepprogressbardemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.prnd.StepProgressBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<StepProgressBar>(R.id.stepProgressBar).apply {
            max = 5
            step = 1
            stepDoneColor = Color.GREEN
            stepUndoneColor = Color.GRAY
        }

    }
}
