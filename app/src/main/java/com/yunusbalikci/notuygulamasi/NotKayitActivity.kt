package com.yunusbalikci.notuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import com.yunusbalikci.notuygulamasi.databinding.ActivityNotKayitBinding

class NotKayitActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNotKayitBinding
    private lateinit var vt:VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotKayitBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        vt = VeritabaniYardimcisi(this)

        binding.toolbarNotKayit.title = "Not Kayıt"
        setSupportActionBar(binding.toolbarNotKayit)

        binding.buttonKaydet.setOnClickListener {
            val ders_adi = binding.editTextDers.text.toString().trim()
            val not1 = binding.editTextNot1.text.toString().trim()
            val not2 = binding.editTextNot2.text.toString().trim()

            if (TextUtils.isEmpty(ders_adi)){
                Snackbar.make(binding.toolbarNotKayit,"Ders adını giriniz.",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(not1)){
                Snackbar.make(binding.toolbarNotKayit,"Birinici notu giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(not2)){
                Snackbar.make(binding.toolbarNotKayit,"İkinci notu giriniz.",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            NotlarDao().notEkle(vt,ders_adi,not1.toInt(),not2.toInt())

            startActivity(Intent(this@NotKayitActivity,MainActivity::class.java))
            finish()
        }
    }
}