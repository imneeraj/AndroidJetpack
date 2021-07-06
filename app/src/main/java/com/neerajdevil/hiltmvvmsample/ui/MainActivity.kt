package com.neerajdevil.hiltmvvmsample.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.neerajdevil.hiltmvvmsample.R
import com.neerajdevil.hiltmvvmsample.base.BaseActivity
import com.neerajdevil.hiltmvvmsample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
    }
}