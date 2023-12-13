 package com.devdroiddev.hilt_di

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.devdroiddev.hilt_di.repositories.ProductRepository
import com.devdroiddev.hilt_di.utils.APP_TAG
import com.devdroiddev.hilt_di.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    // Use viewModels delegate to obtain MainViewModel instance
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.data.observe(this) { products ->
            if (products != null) {
                Log.d(APP_TAG, "Product Size -> ${products.size}")
            } else {
                Log.d(APP_TAG, "No Products")
            }
        }
    }
}