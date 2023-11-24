package com.example.portfolio

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
class twelveGraphDialog(private val fragment: EducationFragment) : Dialog(fragment.requireContext()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.twelve_graph_dialog)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.setBackgroundDrawable(getDrawable(context, R.drawable.clggraph_background))
        }
        val closeButton: TextView = findViewById(R.id.closeButton)

        setCancelable(false)
        val text = "<u>Close</u>"
        closeButton.text = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)

        closeButton.setOnClickListener { _->
            dismiss()
        }
    }


}