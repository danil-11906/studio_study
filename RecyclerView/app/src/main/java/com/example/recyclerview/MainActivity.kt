package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.ActivityMainBinding
import java.nio.file.attribute.AclEntryType

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(viewBinding) {
            recyclerAngelinalublu.adapter = MyAdapter(
                listOf(
                    Module(
                        id = 1,
                        imageId = R.drawable.banan,
                        title = R.string.banan
                    ),
                    Module(
                        id = 2,
                        imageId = R.drawable.ponchik,
                        title = R.string.cakes
                    ),
                    Module(
                        id = 4,
                        imageId = R.drawable.eggs,
                        title = R.string.eggs
                    ),
                    Module(
                        id = 5,
                        imageId = R.drawable.banan,
                        title = R.string.banan
                    ),
                    Module(
                        id = 6,
                        imageId = R.drawable.eggs,
                        title = R.string.eggs
                    ),
                    Module(
                        id = 7,
                        imageId = R.drawable.eggs,
                        title = R.string.eggs
                    ),
                    Module(
                        id = 8,
                        imageId = R.drawable.eggs,
                        title = R.string.eggs
                    ),
                    Module(
                        id = 9,
                        imageId = R.drawable.eggs,
                        title = R.string.eggs
                    ),
                )
            )
        }
    }
}