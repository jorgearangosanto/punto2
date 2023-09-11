package com.santo.practicandoparcial1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.santo.practicandoparcial1.databinding.ActivityRegister2Binding
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity2 : AppCompatActivity() {

    private lateinit var register2Binding: ActivityRegister2Binding
    private var fechaNacimiento: String = ""
    private var cal= Calendar.getInstance()
    private var estado =""
    private var combo = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        register2Binding= ActivityRegister2Binding.inflate(layoutInflater)
       val view = register2Binding.root
        setContentView(view)
        val dataSetListener =
            DatePickerDialog.OnDateSetListener { view, year: Int, month, DayOfMonth ->
                cal.set(Calendar.YEAR,year)
                cal.set(Calendar.MONTH,month)
                cal.set(Calendar.DAY_OF_MONTH,DayOfMonth)

                val  format = " MM/dd/yyyy"
                val sdf = SimpleDateFormat(format,Locale.US)
                fechaNacimiento = sdf.format(cal.time).toString()
                register2Binding.dateButton2.setText(fechaNacimiento)
            }
        register2Binding.dateButton2.setOnClickListener{
            DatePickerDialog(
                this,
                dataSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH),


                ).show()

        }
        register2Binding.registerButton.setOnClickListener {
            Log.d( "button" , "clicked")
            val email = register2Binding.emailEditText.text.toString()
            register2Binding.infoTextView.text = email

            val password = register2Binding.passworeditex.text.toString()

            val repasword = register2Binding.repPassworEditText.text.toString()

            var genre = "masculino"
            if ( register2Binding.femalesRadioButton.isChecked)
                genre = "femenino"

            var genrefavorite = ""
            if (register2Binding.actionCheckBox.isChecked)
                genrefavorite = genrefavorite + "  " + "accion"
            if (register2Binding.loveCheckBox2.isChecked)
                genrefavorite = genrefavorite + "  " + "amor"
            if (register2Binding.dramaCheckBox.isChecked)
                genrefavorite = genrefavorite + "  " + "drama"
            if (register2Binding.comicCheckBox.isChecked)
                genrefavorite = genrefavorite + "  " + "humor"
            if (register2Binding.fantasyCheckBox.isChecked)
                genrefavorite = genrefavorite + "  " + "fantasia"
            if (register2Binding.fictionCheckBox.isChecked)
                genrefavorite = genrefavorite + "  " + "ficcion"

            if (password == repasword){
               val  info =email +"\n" + password + "\n" +genre+ "\n" + genrefavorite+ "\n" +fechaNacimiento
                //val info = email.toInt() + password.toInt()
                register2Binding.infoTextView.text = info.toString()
            }
            else {  Toast.makeText(this,"las contrasenas no son iguale",Toast.LENGTH_LONG).show()

            }
        }

    }
}