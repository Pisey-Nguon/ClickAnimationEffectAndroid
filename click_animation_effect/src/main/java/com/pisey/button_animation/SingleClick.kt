package com.pisey.button_animation

import android.graphics.Color
import android.view.View
import java.util.concurrent.atomic.AtomicBoolean

fun View.setOnSingleClickListener(clickListener:(view:View) -> Unit) {
    val colorFilter = Color.parseColor("#3B000000")
    setOnClickListener(OnSingleClickListener(clickListener))
    setOnTouchListener(TouchListener(colorFilter,true))
}


fun View.setOnSingleClickListener(colorFilter: Int,clickListener: View.OnClickListener) {
    clickListener.also {
        setOnClickListener(OnSingleClickListener(it))
        setOnTouchListener(TouchListener(colorFilter,null))

    }
}
fun View.setOnSingleClickListener(colorFilter: Int,isAnimate:Boolean,clickListener: View.OnClickListener) {
    clickListener.also {
        setOnClickListener(OnSingleClickListener(it))
        setOnTouchListener(TouchListener(colorFilter,isAnimate))

    }
}
class OnSingleClickListener(
    private val clickListener: View.OnClickListener
) : View.OnClickListener {
    private val intervalMs: Long = 1000L
    private var canClick = AtomicBoolean(true)
    override fun onClick(v: View?) {
        if (canClick.getAndSet(false)) {
            v?.run {
                postDelayed({
                    canClick.set(true)
                }, intervalMs)
                clickListener.onClick(v)
            }
        }
    }
}