package com.example.quiztrivia.homepage

import android.view.View
import android.widget.Button
import com.example.quiztrivia.R

class HomeView(view: View) {

    private val directPlay: Button = view.findViewById(R.id.game_fragment_direct_play)
    private val customPlay: Button = view.findViewById(R.id.game_fragment_custom_play)

    fun setDirectPlayListener(listener  : () -> Unit) {
        directPlay.setOnClickListener {
            listener.invoke()
        }
    }

    fun setCustomPlayListener(listener  : () -> Unit) {
        customPlay.setOnClickListener {
            listener.invoke()
        }
    }

}