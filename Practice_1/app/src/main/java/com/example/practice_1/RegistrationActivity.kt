package com.example.practice_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.practice_1.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityRegistrationBinding
    private var signState = "empty"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE)!!

        if (signState == Constance.SIGN_IN_STATE){

            bindingClass.edNAme.visibility = View.GONE
            bindingClass.edSurname.visibility = View.GONE
            bindingClass.avatar.visibility = View.GONE
            bindingClass.imageView.visibility = View.INVISIBLE

        }
    }

    fun onClickDone(view: View) {
        if (signState == Constance.SIGN_UP_STATE){
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPass.text.toString())
            intent.putExtra(Constance.NAME, bindingClass.edNAme.text.toString())
            intent.putExtra(Constance.SURMAE, bindingClass.edSurname.text.toString())
            intent.putExtra(Constance.AVATAR_ID, R.drawable.ic_launcher_background)
            setResult(RESULT_OK, intent)
            finish()
        } else if (signState == Constance.SIGN_IN_STATE) {
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPass.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun onClickAvatar(view: View) {
        if (signState == Constance.SIGN_UP_STATE){
            bindingClass.imageView.visibility = View.VISIBLE
            bindingClass.imageView.setImageResource(R.drawable.ic_launcher_background)
        }
    }
}