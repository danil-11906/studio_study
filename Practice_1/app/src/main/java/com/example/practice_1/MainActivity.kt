package com.example.practice_1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.practice_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding
    private var login: String = "empty"
    private var pass: String = "empty"
    private var name: String = "empty"
    private var surname: String = "empty"
    private var AvatarImage: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        bindingClass.imAvatar.visibility = View.INVISIBLE
        bindingClass.textView.visibility = View.INVISIBLE
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constance.REQUEST_CODE_SIGN_IN){
            val l = data?.getStringExtra(Constance.LOGIN)
            val p = data?.getStringExtra(Constance.PASSWORD)
            if (login == l && pass == p){
                bindingClass.imAvatar.visibility = View.VISIBLE
                bindingClass.imAvatar.setImageResource(R.drawable.ic_launcher_background)
                bindingClass.textView.text = "$name $surname, привет!"
            } else {
                bindingClass.textView.text = "Пароль неверный или Логин"
                bindingClass.textView.visibility = View.VISIBLE
            }
        } else if (requestCode == Constance.REQUEST_CODE_SIGN_UP) {
            login = data?.getStringExtra(Constance.LOGIN)!!
            pass = data?.getStringExtra(Constance.PASSWORD)!!
            name = data?.getStringExtra(Constance.NAME)!!
            surname = data?.getStringExtra(Constance.SURMAE)!!
            AvatarImage = data?.getIntExtra(Constance.AVATAR_ID, 0)!!
            bindingClass.imAvatar.visibility = View.VISIBLE
            bindingClass.imAvatar.setImageResource(R.drawable.ic_launcher_background)
            bindingClass.textView.text = "$name $surname, привет!"
            bindingClass.textView.visibility = View.VISIBLE
            bindingClass.button2.visibility = View.INVISIBLE
            bindingClass.bExit.text = "Выйти"

        }
    }

    fun onClickSignIn(view: View) {

        if (bindingClass.imAvatar.isVisible && bindingClass.textView.text.toString() != "Пароль неверный или Логин") {
            bindingClass.imAvatar.visibility = View.INVISIBLE
            bindingClass.textView.visibility = View.INVISIBLE
            bindingClass.button2.visibility = View.VISIBLE
            bindingClass.bExit.text = "SignIn"
        } else {

            val intent = Intent(this, RegistrationActivity::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)

        }
    }

    fun onClickSignUp(view: View){
        val intent = Intent(this, RegistrationActivity::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)
    }
}