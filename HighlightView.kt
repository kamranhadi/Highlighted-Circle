package com.ui.components.overlay

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils

class HighlightView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val overlayPaint: Paint = Paint()
    private val overlayPath: Path = Path()

    //position of the highlighted circle
    var highlightPositions: List<HighlightPosition> = listOf()
        set(value) {
            field = value
            //redraw
            this.invalidate()
        }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        for (highlight: HighlightPosition in highlightPositions) {
            //Adding circle to overlay
            overlayPath.addCircle(highlight.x, highlight.y, highlight.r, Path.Direction.CW)
        }
        //INVERSE_EVEN_ODD is used to fill the overlay and keep the circle transparent
        overlayPath.fillType = Path.FillType.INVERSE_EVEN_ODD
        //Setting Overlay background color

        overlayPaint.color = getOverlayColor(android.R.color.black)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(overlayPath, overlayPaint)
    }

    private fun getOverlayColor(@ColorRes colorRes: Int): Int {
        val backgroundAlpha = 0.8
        return ColorUtils.setAlphaComponent(
            ContextCompat.getColor(
                this.context,
                colorRes
            ), (255 * backgroundAlpha).toInt()
        )
    }

}

class HighlightPosition(var x: Float, var y: Float, var r: Float)
