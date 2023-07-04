package com.example.mobile14_tp1_v2210043

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.graphics.Color
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile14_tp1_v2210043.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    val cal = Calendar.getInstance()
    var myDob = ""
    //var age = null // comme moi

    @SuppressLint("CutPasteId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.bDate.setOnClickListener{
        //    val ageYear = cal.get(Calendar.YEAR)
        //    val ageMonth = cal.get(Calendar.MONTH)
        //    val ageDay = cal.get(Calendar.DAY_OF_MONTH)
//
        //    val myDatePicker = DatePickerDialog(this,
        //        {_, year, _, _ -> myDob = (year.toString()) },
        //    ageYear, ageMonth, ageDay)
//
        //    myDatePicker.datePicker.maxDate = System.currentTimeMillis()
        //    binding.tvDob.text = "$ageDay , $ageMonth, $ageYear"
        //    myDatePicker.show()
        //}
        //age = cal.now

        
       myDob = findViewById<Button>(R.id.bDate).setOnClickListener {
           DatePickerDialog(
               this,
               this,
               cal.get(Calendar.YEAR),
               cal.get(Calendar.MONTH),
               cal.get(Calendar.DAY_OF_MONTH)
           ).show()
       }.toString()

        binding.bSubmit.setOnClickListener{
            val myIntent = Intent(this, SecondActivity::class.java)
            myIntent.putExtra("etFname", findViewById<EditText>(R.id.etFname).text)
            myIntent.putExtra("etLname", findViewById<EditText>(R.id.etLname).text)
            myIntent.putExtra("bDate", findViewById<Button>(R.id.bDate).text)
            myIntent.putExtra("etNcats", findViewById<EditText>(R.id.etNcats).text)
            myIntent.putExtra("etNdogs", findViewById<EditText>(R.id.etNdogs).text)

            // val myType = TypeDePersonne() // pas le droit faire ca en fonction ,...a cause du binding
            val myType = if(binding.etNcats.text.toString().toInt() > binding.etNdogs.text.toString().toInt()){
                getString(R.string.typeChat)
            }else if(binding.etNcats.text.toString().toInt() < binding.etNdogs.text.toString().toInt()){
                getString(R.string.typeChien)
            }else if(binding.etNcats.text.toString().toInt() == binding.etNdogs.text.toString().toInt() && binding.etNcats.text.toString().toInt()!= 0 && binding.etNdogs.text.toString().toInt() != 0){
                getString(R.string.typeAnimal)
            }else{
                getString(R.string.typeRien)
            }

            val concat =
                "Bonjour ${binding.etFname.text} ${binding.etLname.text},vous avez actuellement $myDob ans et vous $myType"
            myIntent.putExtra("myText", concat)
            myIntent.addFlags(FLAG_ACTIVITY_CLEAR_TOP)

            if(Validation() == true){
                startActivity(myIntent)
            }
        }

        binding.bClear.setOnClickListener {
            findViewById<EditText>(R.id.etFname).text = null
            findViewById<EditText>(R.id.etLname).text = null
            findViewById<EditText>(R.id.etNcats).text = null
            findViewById<EditText>(R.id.etNdogs).text = null
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        cal.set(year, month, dayOfMonth)
    }

    @SuppressLint("CutPasteId")
    private fun Validation(): Boolean{       // elle fonctionnait, la elle ne fonctione plus ,... magie de Kotlin
        var myBool = true
        if(ValidationFname() == false || ValidationLname() == false || ValidationNcats() == false || ValidationNdogs() == false){
            myBool = false
            }
        return myBool
    }

    private fun ValidationFname(): Boolean{
        var myBool = true
        if(findViewById<EditText>(R.id.etFname).text.isEmpty()){
            val et1: EditText = findViewById(R.id.etFname)
            et1.setBackgroundColor(Color.RED)
            myBool = false
        } else {
            val et2: EditText = findViewById(R.id.etFname)
            et2.setBackgroundColor(Color.WHITE)
        }
        return myBool
    }

    private fun ValidationLname(): Boolean{
        var myBool = true
        if(findViewById<EditText>(R.id.etLname).text.isEmpty()){
            val et3: EditText = findViewById(R.id.etLname)
            et3.setBackgroundColor(Color.RED)
            myBool = false
        } else {
            val et4: EditText = findViewById(R.id.etLname)
            et4.setBackgroundColor(Color.WHITE)
        }
        return myBool
    }

    private fun ValidationNcats(): Boolean{
        var myBool = true
        if(findViewById<EditText>(R.id.etNcats).text.isEmpty()){
            val et5: EditText = findViewById(R.id.etNcats)
            et5.setBackgroundColor(Color.RED)
            myBool = false
        } else {
            val et6: EditText = findViewById(R.id.etNcats)
            et6.setBackgroundColor(Color.WHITE)
        }
        return myBool
    }

    private fun ValidationNdogs(): Boolean{
        var myBool = true
        if(findViewById<EditText>(R.id.etNdogs).text.isEmpty()){
            val et7: EditText = findViewById(R.id.etNdogs)
            et7.setBackgroundColor(Color.RED)
            myBool = false
        } else {
            val et8: EditText = findViewById(R.id.etNdogs)
            et8.setBackgroundColor(Color.WHITE)
        }
        return myBool
    }

    //private fun TypeDePersonne():String{
    //    val result = if("etNcats" > "etNdogs"){
    //        getString(R.string.typeChat)
    //    }else if ("etNcats" < "etNdogs"){
    //        getString(R.string.typeChien)
    //    }else if("etNcats" contentEquals  "etNdogs"){
    //        getString(R.string.typeAnimal)
    //    }else{
    //        getString(R.string.typeRien)
    //    }
    //    return result
    //}

}

