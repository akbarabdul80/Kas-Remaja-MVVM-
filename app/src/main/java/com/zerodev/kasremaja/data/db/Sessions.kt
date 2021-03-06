package com.zerodev.kasremaja.data.db

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.zerodev.kasremaja.BuildConfig

@SuppressLint("CommitPrefEdits")
class Sessions(context : Context) {
    companion object {
        var sessions: Sessions?= null
        var PREF_NAME = BuildConfig.APPLICATION_ID+".session"

        val id_user : String = "id_user"
        val email : String = "email"
        val phone : String = "phone"
        val username : String = "username"
        val fullname : String = "fullname"
        val img_user : String = "img_user"
        val level : String = "level"

        val saldo : String = "saldo"
        val saldoKas : String = "saldoKas"
    }

    var pref : SharedPreferences
    var editor : SharedPreferences.Editor? = null

    var context : Context?= null
    val PRIVATE_MODE : Int = 0

    init {
        this.context = context
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    fun putString(key : String, value : String){
        editor!!.putString(key, value)
        editor!!.commit()
    }

    fun putInt(key : String, value: Int) {
        editor!!.putInt(key, value)
        editor!!.commit()
    }

    fun getString(key: String) : String{
        return pref.getString(key, "").toString()
    }

   fun getInt(key: String) : Int {
        return pref.getInt(key, 0)
    }


    fun isLogin() : Boolean{
        return getString(id_user).isNotEmpty()
    }

    fun Logout(){
        editor!!.clear()
        editor!!.commit()
    }
}