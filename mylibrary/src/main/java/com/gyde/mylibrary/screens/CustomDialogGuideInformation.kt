package com.gyde.mylibrary.screens

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.button.MaterialButton
import com.gyde.mylibrary.R
import com.gyde.mylibrary.utils.Util

internal class CustomDialogGuideInformation(
    context: Context,
    private val listener: GuideInformationDialogListener,
    private val flowName: String,
    private val flowDescription: String,
    private val totalSteps: Int
) :
    Dialog(context) {
    init {
        setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_guide_description)
        window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val tvTitle = findViewById<AppCompatTextView>(R.id.tv_title)
        val tvGuideDescription = findViewById<AppCompatTextView>(R.id.tv_guide_description)
        val tvTotalSteps = findViewById<AppCompatTextView>(R.id.tv_total_steps)
        val btnStartGuide = findViewById<MaterialButton>(R.id.btn_start_guide)

        tvTitle.text = flowName
        tvGuideDescription.text = flowDescription
        tvTotalSteps.text = String.format("%s Steps", totalSteps)
        btnStartGuide.setBackgroundColor(Color.parseColor(Util.btnColor))
        tvTitle.setTextColor(Color.parseColor(Util.btnColor))

        btnStartGuide.setOnClickListener {
            listener.onStartGuideClicked(context)
            dismiss()
        }
    }

    interface GuideInformationDialogListener {
        fun onStartGuideClicked(context: Context)
    }
}