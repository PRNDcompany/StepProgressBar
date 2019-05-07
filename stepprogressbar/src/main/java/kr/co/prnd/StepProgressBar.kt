package kr.co.prnd

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.CallSuper
import kr.co.prnd.stepprogressbar.R


class StepProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val defaultHeight =
        resources.getDimensionPixelSize(R.dimen.step_progressbar_default_height)

    private var needInitial = true

    var max: Int = DEFAULT_MAX
        set(value) {
            field = value
            makeStepView()
        }

    var step: Int = DEFAULT_STEP
        set(value) {
            field = value
            makeStepView()
        }

    var stepDoneColor = Color.BLUE
        set(value) {
            field = value
            makeStepView()
        }

    var stepUndoneColor = Color.LTGRAY
        set(value) {
            field = value
            makeStepView()
        }

    var stepMargin = resources.getDimensionPixelSize(R.dimen.step_progressbar_default_margin)
        set(value) {
            field = value
            makeStepView()
        }


    init {
        orientation = HORIZONTAL
        attrs?.let {
            val typedArray =
                context.obtainStyledAttributes(
                    attrs,
                    R.styleable.StepProgressBar, defStyleAttr, 0
                )

            max = typedArray.getInt(R.styleable.StepProgressBar_max, max)
            step = typedArray.getInt(R.styleable.StepProgressBar_step, step)
            stepDoneColor =
                typedArray.getColor(R.styleable.StepProgressBar_stepDoneColor, stepDoneColor)
            stepUndoneColor =
                typedArray.getColor(R.styleable.StepProgressBar_stepUndoneColor, stepUndoneColor)
            stepMargin =
                typedArray.getDimensionPixelSize(R.styleable.StepProgressBar_stepMargin, stepMargin)

            typedArray.recycle()
        }
    }

    @CallSuper
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val height = getDefaultHeight(defaultHeight, heightMeasureSpec)
        super.onMeasure(width, height)
        if (needInitial) {
            needInitial = false
            makeStepView(width, height)
        }
    }

    private fun getDefaultHeight(size: Int, measureSpec: Int): Int {
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)
        return when (specMode) {
            MeasureSpec.EXACTLY -> specSize
            MeasureSpec.UNSPECIFIED, MeasureSpec.AT_MOST -> size
            else -> size
        }
    }

    private fun makeStepView(width: Int = getWidth(), height: Int = getHeight()) {
        if (needInitial) {
            return
        }

        removeAllViewsInLayout()

        val totalViewWidth = width - stepMargin * (max - 1)
        val undoneViewWidth = totalViewWidth / max
        val undoneStepCount = max - step
        val doneViewWidth = width - undoneStepCount * (undoneViewWidth + stepMargin)

        addDoneView(doneViewWidth, height)
        repeat(undoneStepCount) { addUndoneView(undoneViewWidth, height) }
    }

    private fun addDoneView(doneViewWidth: Int, height: Int) {
        addView(View(context).apply {
            layoutParams = LayoutParams(doneViewWidth, height)
            setBackgroundColor(stepDoneColor)
        })
    }

    private fun addUndoneView(stepItemWidth: Int, height: Int) {
        addView(View(context).apply {
            layoutParams = LayoutParams(stepItemWidth, height)
                .apply { leftMargin = stepMargin }
            setBackgroundColor(stepUndoneColor)
        })
    }

    companion object {
        private const val DEFAULT_MAX = 10
        private const val DEFAULT_STEP = 0
    }

}