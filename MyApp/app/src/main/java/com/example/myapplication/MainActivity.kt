package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.button.setOnClickListener {

            val resultValue = bindingClass.txName.text.toString()

            when (resultValue) {

                Constance.DIRECTOR -> {
                    bindingClass.textView.visibility = View.VISIBLE
                    val tempText = "Ваши ${Constance.DIRECTOR_ZP}"
                    if (bindingClass.txPassword.text.toString() == Constance.DIRECTOR_PASS) {
                        bindingClass.textView.text = tempText
                        bindingClass.imageView.visibility = View.VISIBLE
                        bindingClass.imageView.setImageResource(R.drawable.ic_launcher_background)
                    } else {
                        "Неверный пароль"
                    }
                }

                Constance.INGINER -> {
                    bindingClass.textView.visibility = View.VISIBLE
                    val tempText = "Ваши ${Constance.INGINER_ZP}"
                    bindingClass.textView.text = if (bindingClass.txPassword.text.toString() ==
                        Constance.INGINER_PASS
                    ) {
                        tempText
                    } else {
                        "Неверный пароль"
                    }
                }

                Constance.DVORNIK -> {
                    bindingClass.textView.visibility = View.VISIBLE
                    val tempText = "Ваши ${Constance.DVORNIK_ZP}"
                    bindingClass.textView.text = if (bindingClass.txPassword.text.toString() ==
                        Constance.DVORNIK_PASS
                    ) {
                        tempText
                    } else {
                        "Неверный пароль"
                    }
                }
            }
        }
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == 200 && resultCode == RESULT_OK && data != null) {
                bindingClass.textView3.text = data.getStringExtra("key")
            }
        }
        fun testOnClick (view : View) {
            val intent = Intent(this, TestActiviti::class.java)
            intent.putExtra("string", bindingClass.txName.text.toString())
            startActivityForResult(intent, 200)
        }
    }
}