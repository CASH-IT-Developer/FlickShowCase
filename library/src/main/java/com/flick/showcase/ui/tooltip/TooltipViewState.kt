package com.flick.showcase.ui.tooltip

import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.FontRes

data class TooltipViewState(
    val titleText: String,
    val descriptionText: String,
    val buttonText: String,
//    @ColorInt val titleTextColor: Int,
//    @ColorInt val descriptionTextColor: Int,
//    @ColorInt val backgroundColor: Int,
//    @ColorInt val closeButtonColor: Int,
    val showCloseButton: Boolean = true,
    val arrowPosition: ArrowPosition,
    val arrowPercentage: Int?,
    val titleTextSize: Float,
    val descriptionTextSize: Float,
    val arrowMargin: Int,
    val showOkeButton: Boolean = true
) {

    fun getTopArrowVisibility() =
        if (arrowPosition == ArrowPosition.TOP) View.VISIBLE else View.GONE

    fun getBottomArrowVisibility() =
        if (arrowPosition == ArrowPosition.BOTTOM) View.VISIBLE else View.GONE

    fun getCloseButtonVisibility() = if (showCloseButton) View.VISIBLE else View.GONE
    fun getOkeButtonVisibility() = if (showOkeButton) View.VISIBLE else View.GONE

    fun getHideTitle() = if (titleText.isEmpty()) View.GONE else View.VISIBLE
    fun getHideDescriptionn() = if (descriptionText.isEmpty()) View.GONE else View.VISIBLE
}
