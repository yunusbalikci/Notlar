package com.yunusbalikci.notuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.yunusbalikci.notuygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var notlarListe:ArrayList<Notlar>
    private lateinit var adapter:NotlarAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbar.title = "Notlar Uygulaması"
        binding.toolbar.subtitle="Ortalama : 60"
        setSupportActionBar(binding.toolbar)

        binding.rw.setHasFixedSize(true)
        binding.rw.layoutManager = LinearLayoutManager(this@MainActivity)

        notlarListe = ArrayList()

        val n1 = Notlar(1,"Tarih",50,40)
        val n2 = Notlar(2,"Kimya",20,60)
        val n3 = Notlar(3,"Fizik",60,30)

        notlarListe.add(n1)
        notlarListe.add(n2)
        notlarListe.add(n3)
 
        adapter = NotlarAdapter(this,notlarListe)

        binding.rw.adapter = adapter

        binding.fab.setOnClickListener {

        }
    }
}