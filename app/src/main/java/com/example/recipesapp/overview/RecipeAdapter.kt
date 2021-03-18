package com.example.recipesapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipesapp.databinding.GridViewItemBinding

import com.example.recipesapp.network.Recipe


class RecipeAdapter : ListAdapter<Recipe, RecipeAdapter.RecipePropertyViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.RecipePropertyViewHolder {
        return RecipePropertyViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipePropertyViewHolder, position: Int) {
        val recipeProperty = getItem(position)
        holder.bind(recipeProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class RecipePropertyViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipeProperty: Recipe) {
            binding.property = recipeProperty
            binding.executePendingBindings()
        }
    }


}