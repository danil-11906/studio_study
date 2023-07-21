package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityTestActivitiBinding

class TestActiviti : AppCompatActivity() {
    lateinit var bindingClass: ActivityTestActivitiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityTestActivitiBinding.inflate(layoutInflater)
        val mess = intent.getStringExtra("string")
        bindingClass.textView2.text = mess
    }

    fun testGo(view : View) {
        intent.putExtra("key", bindingClass.myName.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}