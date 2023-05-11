package com.yunusbalikci.notuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert.ACTION
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.yunusbalikci.notuygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var notlarListe:ArrayList<Notlar>
    private lateinit var adapter:NotlarAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var vt:VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbar.title = "Notlar Uygulaması"
        setSupportActionBar(binding.toolbar)

        binding.rw.setHasFixedSize(true)
        binding.rw.layoutManager = LinearLayoutManager(this@MainActivity)

        vt = VeritabaniYardimcisi(this)
        notlarListe = NotlarDao().tumNotlar(vt)
 
        adapter = NotlarAdapter(this,notlarListe)

        binding.rw.adapter = adapter

        var toplam = 0

        for (n in notlarListe){
            toplam = toplam + (n.not1 + n.not2) /2
        }

        if (toplam != 0){
            binding.toolbar.subtitle = "Ortalama :${toplam/notlarListe.size}"
        }

        binding.fab.setOnClickListener {

            startActivity(Intent(this@MainActivity,NotKayitActivity::class.java))


        }
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}