package com.flick.showcase.showcase

import android.graphics.RectF
import android.os.Parcelable
import androidx.annotation.ColorInt
import androidx.annotation.FontRes
import com.flick.showcase.ui.showcase.HighlightType
import com.flick.showcase.ui.tooltip.ArrowPosition
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ShowcaseModel(val rectF: RectF,
                         val radius: Float,
                         val titleText: String,
                         val descriptionText: String,
                         val buttonText: String,
//                         @FontRes val titleFont:Int,
//                         @FontRes val descriptionFont:Int,
//                         @ColorInt val titleTextColor: Int,
//                         @ColorInt val descriptionTextColor: Int,
//                         @ColorInt val popupBackgroundColor: Int,
//                         @ColorInt val closeButtonColor: Int,
                         val showCloseButton: Boolean,
                         val arrowPosition: ArrowPosition,
                         val highlightType: HighlightType,
                         val arrowPercentage: Int?,
                         val windowBackgroundColor: Int,
                         val windowBackgroundAlpha: Int,
                         val titleTextSize: Float,
                         val descriptionTextSize: Float,
                         val highlightPadding: Float,
                         val cancellableFromOutsideTouch: Boolean,
                         val showOkeButton: Boolean

) : Parcelable {

    fun horizontalCenter() = rectF.left + ((rectF.right - rectF.left) / 2)
    fun verticalCenter() = rectF.top + ((rectF.bottom - rectF.top) / 2)

    fun bottomOfCircle() = verticalCenter() + radius
    fun topOfCircle() = verticalCenter() - radius
}
