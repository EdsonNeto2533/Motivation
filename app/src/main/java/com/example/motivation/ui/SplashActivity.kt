package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.PreferenciasSegurança
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    //instanciado somente la embaixo pois o contexto so existe dps do onCreate
    private lateinit var mPreferenciasSegurança: PreferenciasSegurança

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        hideToolbar()
        //this igual contexto da activity, toda activity tem o contexto
        mPreferenciasSegurança = PreferenciasSegurança(this)

        btnSalvar.setOnClickListener {
            botaoSalvar()
        }

    }

    fun hideToolbar(){
        //esconde toolbar, o suporteActionBar!! garante a execução pois o kotlin espera nullPointerExecption
        if(supportActionBar != null){
            supportActionBar!!.hide()
        }
    }

    fun botaoSalvar(){
        val nome = etNome.text.toString()

        if (nome != ""){
            mPreferenciasSegurança.salvarString("nome" , nome)
            val inti = Intent(this, MainActivity::class.java)
            startActivity(inti)
        } else {
            Toast.makeText(this,"Preencha o nome", Toast.LENGTH_SHORT).show()
        }
    }
}