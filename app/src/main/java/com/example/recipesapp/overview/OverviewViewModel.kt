package com.example.recipesapp.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.network.Recipe
import com.example.recipesapp.network.RecipeApi
import kotlinx.coroutines.launch


class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<Recipe>>()

    val properties: LiveData<List<Recipe>>
        get() = _properties


    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                var listResult = RecipeApi.retrofitService.getProperties()
                if (listResult.size > 0) {
                    _properties.value = listResult
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

}