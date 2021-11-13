package com.example.kotlin_test_11

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private val numberPicker1:NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.numberpicker_first)
            .apply{
                minValue=0
                maxValue=9
            }
    }
    private val numberPicker2:NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.numberpicker_second)
            .apply{
                minValue=0
                maxValue=9
            }
    }
    private val numberPicker3:NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.numberpicker_thrid)
            .apply{
                minValue=0
                maxValue=9
            }
    }

    private var changePasswordMode = false

    private val openButton: AppCompatButton by lazy{
        findViewById<AppCompatButton>(R.id.openButton)
    }
    private val changePasswordButton: AppCompatButton by lazy{
        findViewById<AppCompatButton>(R.id.changePasswordButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker1
        numberPicker2
        numberPicker3

        openButton.setOnClickListener {
            if(changePasswordMode){
                Toast.makeText(this,"비밀번호 변경 중입니다.",Toast.LENGTH_LONG).show()
            }
            val passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE)
            val passwordFromUser = "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}"

            if(passwordPreferences.getString("password","000").equals(passwordFromUser)){


            }else{
                AlertDialog.Builder(this)
                    .setTitle("실패!!")
                    .setMessage("비밀번호가 잘못되었습니다.")
                    .setPositiveButton("확인"){_,_->}
                    .create()
                    .show()
            }
        }
        changePasswordButton.setOnClickListener {
            if(changePasswordMode){
                // 번호를 저장하는 기능
            }else{
                // changePasswordMode가 활성화 :: 비밀번호가 맞는지를 체크
            }


        }


    }
}