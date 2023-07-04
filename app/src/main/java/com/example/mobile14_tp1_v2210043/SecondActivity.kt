package com.example.mobile14_tp1_v2210043

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile14_tp1_v2210043.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    var myConcat = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = intent.getStringExtra("myText")


        binding.bRetour.setOnClickListener{
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

       //if(intent.getStringExtra("etFname") != nothing {
       //    binding.textView.text = "Bonjour ${intent.getStringExtra("etFname")} ${intent.getStringExtra("etLname")} , vous avez
       //
       //    })
    }
}