package com.neerajdevil.hiltmvvmsample.base

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.neerajdevil.hiltmvvmsample.R

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var dialogLoading: Dialog

    fun logError(message: String) {
        Log.e("SAMPLE_APP", message)
    }

    fun logDebug(message: String) {
        Log.d("SAMPLE_APP", message)
    }

    fun showError(message: String) {
        val sb = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        sb.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        sb.setBackgroundTint(ContextCompat.getColor(this, R.color.primary_dark))
        sb.show()
    }

    fun hideKeyboard() {
        val inputMethodManager = getSystemService(
            Activity.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        currentFocus?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    fun showLoading() {
        if (::dialogLoading.isInitialized)
            dialogLoading.show()
        else {
            initDialogue()
            dialogLoading.show()
        }
    }

    fun hideLoading() {
        if (::dialogLoading.isInitialized)
            dialogLoading.dismiss()
    }

    private fun initDialogue() {
        dialogLoading = Dialog(this)
        dialogLoading.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogLoading.setContentView(R.layout.progress_dialog)
        dialogLoading.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogLoading.setCancelable(false)
        dialogLoading.setCanceledOnTouchOutside(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::dialogLoading.isInitialized) {
            dialogLoading.dismiss()
        }
    }

    override fun finish() {
        super.finish()
    }
}