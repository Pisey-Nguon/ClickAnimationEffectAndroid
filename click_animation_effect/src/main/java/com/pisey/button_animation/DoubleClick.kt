package com.pisey.button_animation

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.View


fun View.setOnDoubleClickListener(clickListener: DoubleClick.DoubleClickListener){
    val colorFilter = Color.parseColor("#3B000000")
    clickListener.also {
        setOnClickListener(DoubleClick(clickListener))
        setOnTouchListener(TouchListener(colorFilter,true))
    }
}
fun View.setOnDoubleClickListener(colorFilter:Int,clickListener: DoubleClick.DoubleClickListener){
    clickListener.also {
        setOnClickListener(DoubleClick(clickListener))
        setOnTouchListener(TouchListener(colorFilter,true))
    }
}
fun View.setOnDoubleClickListener(colorFilter:Int,isAnimation:Boolean,clickListener: DoubleClick.DoubleClickListener){
    clickListener.also {
        setOnClickListener(DoubleClick(clickListener))
        setOnTouchListener(TouchListener(colorFilter,isAnimation))

    }
}
class DoubleClick(private val listener: DoubleClickListener) : View.OnClickListener {
    private var isSingleEvent = false
    private val doubleClickQualificationSpanInMillis: Long = DEFAULT_QUALIFICATION_SPAN
    private var timestampLastClick: Long
    private val handler: Handler
    private val runnable: Runnable
    override fun onClick(v: View?) {
        if (SystemClock.elapsedRealtime() - timestampLastClick < doubleClickQualificationSpanInMillis) {
            isSingleEvent = false
            handler.removeCallbacks(runnable)
            listener.onDoubleClick()
            return
        }
        isSingleEvent = true
        handler.postDelayed(runnable, DEFAULT_QUALIFICATION_SPAN)
        timestampLastClick = SystemClock.elapsedRealtime()
    }


    companion object {
        private const val DEFAULT_QUALIFICATION_SPAN: Long = 200
    }

    init {
        timestampLastClick = 0
        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            if (isSingleEvent) {
                listener.onSingleClick()
            }
        }
    }

    interface DoubleClickListener{
        fun onDoubleClick()
        fun onSingleClick(){}

    }
}