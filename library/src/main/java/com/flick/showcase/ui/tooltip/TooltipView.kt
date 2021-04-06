package com.flick.showcase.ui.tooltip

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.flick.showcase.R
import com.flick.showcase.databinding.LayoutTooltipBinding
import com.flick.showcase.util.getShowcaseActivity

class TooltipView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: LayoutTooltipBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
        R.layout.layout_tooltip, rootView as ViewGroup, true)

    fun bind(tooltipViewState: TooltipViewState) {
        binding.imageViewTooltipClose.setOnClickListener {
            getShowcaseActivity()?.onBackPress()
        }
        binding.button.setOnClickListener {
            getShowcaseActivity()?.onBackPress()
        }
        binding.tooltipViewState = tooltipViewState
        binding.executePendingBindings()
    }
}
