package com.santo.practicandoparcial1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){


    val contrasena: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val mensajeerror: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val info: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    fun validatepasswor(password: String, repasword: String) {
        if (password != repasword){
            mensajeerror.value=" las contrasenas no son iguale"

    }else {
            contrasena.value = password.toString()
    }



   /* fun registro(email: String, password: String) {
         info.value = email.toString() + password.toString()

    }*/

    }

    fun registro(email: String, password: String) {
        info.value = email.toString() + password.toString()
    }


}