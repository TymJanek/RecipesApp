package com.example.recipesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recipesapp.domain.Recipe

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "recipes.json")
        Log.i("data", jsonFileString)

        val gson = Gson()
        val listPersonType = object : TypeToken<List<Recipe>>() {}.type

        var persons: List<Recipe> = gson.fromJson(jsonFileString, listPersonType)
        persons.forEachIndexed { idx, recipe -> Log.i("data", "> Item $idx:\n$recipe") }
    }
}