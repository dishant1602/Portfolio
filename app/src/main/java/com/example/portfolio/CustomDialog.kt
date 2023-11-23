package com.example.portfolio

import android.app.Dialog
import android.os.Bundle
import android.text.Html
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
class CustomDialog(private val fragment: EducationFragment, private val images: List<Int>) : Dialog(fragment.requireContext()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_content)

        val viewPager: ViewPager = findViewById(R.id.dialogViewPager)
        val btnPrevious: ImageView = findViewById(R.id.dialogBtnPrevious)
        val btnNext: ImageView = findViewById(R.id.dialogBtnNext)
        val closeButton: TextView = findViewById(R.id.closeButton)

        setCancelable(false)
        val text = "<u>Close</u>"
        closeButton.text = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)

        val adapter = ImagePagerAdapter(context, images)
        viewPager.adapter = adapter

        btnPrevious.setOnClickListener {
            if (viewPager.currentItem > 0) {
                viewPager.currentItem = viewPager.currentItem - 1
            }

        }

        btnNext.setOnClickListener {
            if (viewPager.currentItem < images.size - 1) {
                viewPager.currentItem = viewPager.currentItem + 1
            }
        }
    }


}