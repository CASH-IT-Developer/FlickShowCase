package com.flick.showcase.util

import android.content.res.Resources
import android.view.View
import com.flick.showcase.ui.tooltip.ArrowPosition
import kotlin.math.pow
import kotlin.math.sqrt

object TooltipFieldUtil {

    fun calculateArrowPosition(resources: Resources, verticalCenter: Float): ArrowPosition {
        val screenHeight = resources.displayMetrics.heightPixels

        return if (screenHeight / 2 > verticalCenter) ArrowPosition.TOP else ArrowPosition.BOTTOM
    }

    fun calculateRadius(view: View): Float {
        val x = view.width.toDouble() / 2
        val y = view.height.toDouble() / 2

        return sqrt(x.pow(2) + y.pow(2)).toFloat()
    }

    fun calculateMarginForCircle(resources: Resources, top: Float, bottom: Float, arrowPosition: ArrowPosition, statusBarDiff: Int) = when (arrowPosition) {
        ArrowPosition.TOP -> bottom.toInt() + statusBarDiff
        ArrowPosition.BOTTOM -> resources.displayMetrics.heightPixels - top.toInt()// + statusBarDiff
        else -> 0//throw IllegalArgumentException("arrowPosition should be ArrowPosition.UP or ArrowPosition.DOWN")
    }

    fun calculateMarginForRectangle(resources: Resources, top: Float, bottom: Float, arrowPosition: ArrowPosition, statusBarDiff: Int) = when (arrowPosition) {
        ArrowPosition.TOP -> bottom.toInt() + statusBarDiff
        ArrowPosition.BOTTOM -> resources.displayMetrics.heightPixels - top.toInt()// + statusBarDiff
        else -> 0//throw IllegalArgumentException("arrowPosition should be ArrowPosition.UP or ArrowPosition.DOWN")
    }

    fun calculateArrowMargin(resources: Resources, horizontalCenter: Float): Int {
        val arrowHalfWidth = (15 * resources.displayMetrics.density)

        return (horizontalCenter - arrowHalfWidth).toInt()
    }
}
