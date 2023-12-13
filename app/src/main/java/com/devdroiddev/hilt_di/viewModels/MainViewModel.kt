package com.devdroiddev.hilt_di.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdroiddev.hilt_di.models.Products
import com.devdroiddev.hilt_di.repositories.ProductRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    private val _data = MutableLiveData<List<Products>>()
    val data: LiveData<List<Products>> get() = _data
    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        GlobalScope.launch(Dispatchers.IO) {
            val result = productRepository.getProducts()
            _data.postValue(result)
        }
    }

}