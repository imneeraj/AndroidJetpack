package com.neerajdevil.hiltmvvmsample.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    fun logError(message: String) {
        (activity as BaseActivity).logError(message)
    }

    fun logDebug(message: String) {
        (activity as BaseActivity).logDebug(message)
    }

    fun finish() {
        (activity as BaseActivity).finish()
    }

    fun showLoading() {
        (activity as BaseActivity).showLoading()
    }

    fun hideLoading() {
        (activity as BaseActivity).hideLoading()
    }

    fun showError(message: String) {
        (activity as BaseActivity).showError(message)
    }
}