package com.lesehankoding.showcaseexample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.flick.showcase.showcase.FlickShowCase
import com.flick.showcase.ui.showcase.HighlightType
import com.flick.showcase.ui.tooltip.ArrowPosition

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonTop = findViewById<Button>(R.id.button)

        buttonTop.setOnClickListener {
            FlickShowCase.Create()
                .view(buttonTop)
                .titleText("This is Title!")
                .descriptionText("This is description.")
                .buttonText("Tutup")
                .showOkeButton(true)
                .cancellableFromOutsideTouch(false)
                .arrowPosition(ArrowPosition.TOP)
                .highlightType(HighlightType.CIRCLE)
                .windowBackgroundAlpha(90)
                .created()
                .showing(activity = this@MainActivity)
        }


    }
}