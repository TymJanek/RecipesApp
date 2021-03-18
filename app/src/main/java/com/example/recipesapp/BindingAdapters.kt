package com.example.recipesapp


import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.BindingAdapter
import com.example.recipesapp.network.Recipe
import com.example.recipesapp.overview.RecipeAdapter



@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Recipe>?) {
    val adapter = recyclerView.adapter as RecipeAdapter
    adapter.submitList(data)
}

