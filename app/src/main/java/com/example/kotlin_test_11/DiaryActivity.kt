package com.example.kotlin_test_11

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener

class DiaryActivity: AppCompatActivity() {
    private val diaryET:EditText by lazy{
        findViewById(R.id.diary_ET)
    }

    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(svaedInstanceState: Bundle?){
        super.onCreate(svaedInstanceState)
        setContentView(R.layout.activity_note)

        val detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)
        diaryET.setText(detailPreferences.getString("detail",""))



        val runnable = Runnable {
            getSharedPreferences("diary",Context.MODE_PRIVATE).edit{
                putString("detail",diaryET.text.toString())
            }
        }
        diaryET.addTextChangedListener {
            Log.d("DiaryActivity","TextChanged:: $it")
            handler.removeCallbacks(runnable)
            handler.postDelayed(runnable,500)
        }
    }
}