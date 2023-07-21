package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.seconds().observe(this, Observer {
            bindingClass.textView.text = it.toString()
        })
        viewModel.finished.observe(this, Observer {
            if (it){
                Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show()
            }
        })
        bindingClass.startBtn.setOnClickListener {
            if(bindingClass.numberInput.text.isEmpty() || bindingClass.numberInput.text.length < 4){
                Toast.makeText(this, "Invalid Number", Toast.LENGTH_SHORT).show()
            }else {
                viewModel.timerValue.value = bindingClass.numberInput.text.toString().toLong()
                viewModel.startTimer()
            }
        }
        bindingClass.stopBtn.setOnClickListener {
            bindingClass.textView.text = "0"
            viewModel.stopTimer()
        }
    }
}