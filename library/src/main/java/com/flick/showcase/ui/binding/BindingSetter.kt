package com.trendyol.showcase.ui.binding

import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.flick.showcase.ui.tooltip.ArrowPosition
import com.flick.showcase.ui.tooltip.TooltipView
import com.flick.showcase.ui.tooltip.TooltipViewState

object BindingSetter {

    @JvmStatic
    @BindingAdapter("tooltipViewState")
    fun TooltipView.setTooltipViewState(tooltipViewState: TooltipViewState) {
        bind(tooltipViewState)
    }

    @JvmStatic
    @BindingAdapter(value = ["applyMargin", "arrowPosition"], requireAll = true)
    fun TooltipView.placeTooltip(margin: Int, arrowPosition: ArrowPosition) {
        if (arrowPosition == ArrowPosition.TOP) {
            (layoutParams as? ConstraintLayout.LayoutParams)?.apply {
                topToTop = 0 // parent
                bottomToBottom = -1
                topMargin = margin
            }
        } else if (arrowPosition == ArrowPosition.BOTTOM) {
            (layoutParams as? ConstraintLayout.LayoutParams)?.apply {
                topToTop = -1
                bottomToBottom = 0 // parent
                bottomMargin = margin
            }
        }
    }

    @JvmStatic
    @BindingAdapter("textSizeInSP")
    fun TextView.setTextSizeInSp(size: Float) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
    }

    @JvmStatic
    @BindingAdapter(value = ["arrowHorizontalPosition", "arrowPercentage"], requireAll = true)
    fun ImageView.layoutMarginStart(margin: Int, percentage: Int?) {
        (layoutParams as? ConstraintLayout.LayoutParams)?.apply {
            percentage?.let {
                endToEnd = 0
                horizontalBias = (it.toFloat() / 100)
            } ?: run {
                this.marginStart = margin
            }
        }
    }
}
