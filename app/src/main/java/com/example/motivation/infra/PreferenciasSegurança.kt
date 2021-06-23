package com.example.motivation.infra

import android.content.Context

class PreferenciasSegurança(context: Context) {

    //garante uma variavel instancia ja da sharedPreferences na criação da classe
    private val mSharedPreferences = context.getSharedPreferences("app" , Context.MODE_PRIVATE)


    fun salvarString(chave: String, valor: String){
        mSharedPreferences.edit().putString(chave , valor).apply()
    }
    fun getString (chave: String){

    }
}