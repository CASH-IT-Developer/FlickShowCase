package com.lesehankoding.showcaseexample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
//                .titleText("Title For Top!")
                .descriptionText("Simple, short description for top tooltip.")
                .buttonText("Tutup")
                .showOkeButton(true)
                .cancellableFromOutsideTouch(false)
                .arrowPosition(ArrowPosition.TOP)
                .highlightType(HighlightType.NONE)
                .windowBackgroundAlpha(90)
                .created()
                .showing(this@MainActivity, 0)
        }


    }
}