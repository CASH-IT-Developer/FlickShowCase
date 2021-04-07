package com.flick.showcase.showcase

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.graphics.fonts.FontFamily
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.FontRes
import androidx.annotation.IntRange
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import com.flick.showcase.R
import com.flick.showcase.ui.showcase.HighlightType
import com.flick.showcase.ui.showcase.ShowcaseActivity
import com.flick.showcase.ui.tooltip.ArrowPosition
import com.flick.showcase.util.Constants
import com.flick.showcase.util.TooltipFieldUtil
import com.flick.showcase.util.toRectF

data class FlickShowCase private constructor(
    private val showcaseModel: ShowcaseModel,
    @StyleRes val resId: Int?
) {

    fun showing(
        activity: Activity,
        requestCode: Int? = null
    ) {
        val intent = Intent(activity, ShowcaseActivity::class.java)
        val model = if (resId != null) readFromStyle(activity, resId) else showcaseModel
        intent.putExtra(ShowcaseActivity.BUNDLE_KEY, model)

        if (requestCode == null) {
            activity.startActivity(intent)
        } else {
            activity.startActivityForResult(intent, requestCode)
        }
    }

    fun showing(
        fragment: Fragment,
        requestCode: Int? = null
    ) {
        fragment.activity?.let { activity ->
            val intent = Intent(activity, ShowcaseActivity::class.java)
            val model = if (resId != null) readFromStyle(activity, resId) else showcaseModel
            intent.putExtra(ShowcaseActivity.BUNDLE_KEY, model)
            if (requestCode == null) {
                fragment.startActivity(intent)
            } else {
                fragment.startActivityForResult(intent, requestCode)
            }
        }
    }

    private fun readFromStyle(context: Context, resId: Int): ShowcaseModel {
        val typedArray = context.obtainStyledAttributes(resId, R.styleable.Showcase_Theme)
        return showcaseModel.copy(
//            titleTextColor = typedArray.getColor(R.styleable.Showcase_Theme_titleTextColor, showcaseModel.titleTextColor),
//            descriptionTextColor = typedArray.getColor(R.styleable.Showcase_Theme_descriptionTextColor, showcaseModel.descriptionTextColor),
//            closeButtonColor = typedArray.getColor(R.styleable.Showcase_Theme_closeButtonColor, showcaseModel.closeButtonColor),
//            popupBackgroundColor = typedArray.getColor(R.styleable.Showcase_Theme_popupBackgroundColor, showcaseModel.popupBackgroundColor),
            windowBackgroundColor = typedArray.getColor(R.styleable.Showcase_Theme_windowBackgroundColor, showcaseModel.windowBackgroundColor),
            showCloseButton = typedArray.getBoolean(R.styleable.Showcase_Theme_showCloseButton, showcaseModel.showCloseButton),
            cancellableFromOutsideTouch = typedArray.getBoolean(R.styleable.Showcase_Theme_cancellableFromOutsideTouch, showcaseModel.cancellableFromOutsideTouch),
            showOkeButton = typedArray.getBoolean(R.styleable.Showcase_Theme_showOkeButton, showcaseModel.showOkeButton)
        ).also {
            typedArray.recycle()
        }
    }

    class Create {

        private var focusView: View? = null
        private var titleText: String = Constants.DEFAULT_TEXT

//        @FontRes
//        private var titleFont: Int = R.font.title_flickshowcase_font
//        @FontRes
//        private var descriptionFont: Int = R.font.description_flickshowcase_font

        private var descriptionText: String = Constants.DEFAULT_TEXT
        private var buttonText: String = Constants.DEFAULT_BUTTON_TEXT
//        @ColorInt
//        private var titleTextColor: Int = Constants.DEFAULT_TEXT_COLOR
//        @ColorInt
//        private var descriptionTextColor: Int = Constants.DEFAULT_TEXT_COLOR
//        @ColorInt
//        private var popupBackgroundColor: Int = Constants.DEFAULT_POPUP_COLOR
        private var showCloseButton: Boolean = Constants.DEFAULT_CLOSE_BUTTON_VISIBILITY
        private var showOkeButton: Boolean = Constants.DEFAULT_OKE_BUTTON_VISIBILITY
//        @ColorInt
//        private var closeButtonColor: Int = Constants.DEFAULT_TEXT_COLOR
        private var arrowPosition: ArrowPosition = Constants.DEFAULT_ARROW_POSITION
        private var highlightType: HighlightType = Constants.DEFAULT_HIGHLIGHT_TYPE
        private var arrowPercentage: Int? = null
        @ColorInt
        private var windowBackgroundColor: Int = Constants.DEFAULT_COLOR_BACKGROUND
        private var windowBackgroundAlpha: Int = Constants.DEFAULT_BACKGROUND_ALPHA
        private var titleTextSize: Float = Constants.DEFAULT_TITLE_TEXT_SIZE
        private var descriptionTextSize: Float = Constants.DEFAULT_DESCRIPTION_TEXT_SIZE
        private var highlightPadding: Float = Constants.DEFAULT_HIGHLIGHT_PADDING_EXTRA
        @StyleRes
        private var resId: Int? = null
        private var cancellableFromOutsideTouch: Boolean = Constants.DEFAULT_CANCELLABLE_FROM_OUTSIDE_TOUCH

        fun view(view: View) = apply { focusView = view }
        fun titleText(title: String) = apply { titleText = title }
        fun descriptionText(description: String) = apply { descriptionText = description }
        fun buttonText(text: String) = apply { buttonText = text }
//        fun titleColor(@ColorInt color: Int) = apply { titleTextColor = color }
//        fun descriptionColor(@ColorInt color: Int) = apply { descriptionTextColor = color }
//        fun backgroundColor(@ColorInt color: Int) = apply { popupBackgroundColor = color }
//        fun closeButtonColor(@ColorInt color: Int) = apply { closeButtonColor = color }
//        fun showCloseButton(show: Boolean) = apply { showCloseButton = show }
        fun showOkeButton(show: Boolean) = apply { showOkeButton = show }
        fun arrowPosition(position: ArrowPosition) = apply { arrowPosition = position }
        fun highlightType(type: HighlightType) = apply { highlightType = type }
//        fun titleFontFamily(@FontRes font: Int) = apply { titleFont = font }
//        fun descriptionFontFamily(@FontRes font: Int) = apply { descriptionFont = font }
        /**
         *
         * Extra padding for highlight area.
         */
        fun highlightPadding(padding: Float) = apply { highlightPadding = padding }

        /**
         *
         * Custom positioning for arrow.
         */
        fun arrowPercentage(@IntRange(from = 0, to = 100) percentage: Int) = apply { arrowPercentage = percentage }

        fun windowBackgroundColor(@ColorInt color: Int) = apply { windowBackgroundColor = color }
        fun windowBackgroundAlpha(@IntRange(from = 0, to = 255) alpha: Int) = apply { windowBackgroundAlpha = alpha }



        /**
         *
         * titleTextSize in SP.
         */
        fun titleTextSize(size: Float) = apply { titleTextSize = size }

        /**
         *
         * descriptionTextSize in SP.
         */
        fun descriptionTextSize(size: Float) = apply { descriptionTextSize = size }

        /**
         *
         * Resource id of an custom style named Showcase.Theme in project.
         */
        fun resId(@StyleRes res: Int) = apply { resId = res }
        fun cancellableFromOutsideTouch(cancellable: Boolean) = apply { cancellableFromOutsideTouch = cancellable }

        @SuppressLint("ResourceType")
        fun created(): FlickShowCase {
            if (focusView == null) {
                throw Exception("view should not be null!")
            }

            val rect = Rect()

            focusView?.getGlobalVisibleRect(rect)

            val showcaseModel = ShowcaseModel(
                rect.toRectF(),
                TooltipFieldUtil.calculateRadius(focusView!!),
                titleText,
                descriptionText,
                buttonText,
//                titleTextColor,
//                descriptionTextColor,
//                titleFont,
//                descriptionFont,
//                popupBackgroundColor,
//                closeButtonColor,
                showCloseButton,
                arrowPosition,
                highlightType,
                arrowPercentage,
                windowBackgroundColor,
                windowBackgroundAlpha,
                titleTextSize,
                descriptionTextSize,
                highlightPadding,
                cancellableFromOutsideTouch,
                showOkeButton)

            return FlickShowCase(showcaseModel, resId)
        }
    }

    companion object {
        const val HIGHLIGHT_CLICKED = "highlight_clicked"
    }
}
