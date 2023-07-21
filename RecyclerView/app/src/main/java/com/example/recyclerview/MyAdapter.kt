package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.databinding.ModuleBinding

class MyAdapter(
    private val list: List<Module>
) : RecyclerView.Adapter<ModuleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleHolder {
       return ModuleHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ModuleHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}

class ModuleHolder(private val itemBinding: ModuleBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(model: Module) {
        with(itemBinding) {
            imageView.setImageResource(model.imageId)
            textView.setText(model.title)
        }
    }

    companion object {

        fun create(parent: ViewGroup): ModuleHolder {
            val itemBinding = ModuleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return ModuleHolder(itemBinding)
        }
    }
}