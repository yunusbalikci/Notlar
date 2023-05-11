package com.yunusbalikci.notuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.yunusbalikci.notuygulamasi.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarDetay.title = "Not Detay"
        setSupportActionBar(binding.toolbarDetay)

        val not = intent.getSerializableExtra("nesne") as Notlar

        binding.editTextDers2.setText(not.ders_adi)
        binding.editTextNot1.setText((not.not1).toString())
        binding.editTextNot2.setText((not.not2).toString())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_sil ->{
                Snackbar.make(binding.toolbarDetay,"Notu Silmek İstediğinizden Emin Misiniz?",Snackbar.LENGTH_LONG)
                    .setAction("Evet"){
                        startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                        finish()
                    }.show()
                return true
            }
            R.id.action_duzenle ->{
                startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                finish()
                return true
            }
            else -> return false
        }
    }
}