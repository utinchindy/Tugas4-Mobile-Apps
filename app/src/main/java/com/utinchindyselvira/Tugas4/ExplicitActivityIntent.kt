package com.utinchindyselvira.Tugas4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_explicit_intent.*
import kotlinx.android.synthetic.main.activity_simple.*

class ExplicitActivityIntent : AppCompatActivity() {

    companion object {
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_HARGA = "extra_harga"
        const val EXTRA_STOK = "extra_stok"
        const val EXTRA_DESKRIPSI = "extra_deskripsi"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

        txt_produk.text = intent.getStringExtra(EXTRA_NAMA)
        txt_harga.text = intent.getStringExtra(EXTRA_HARGA)
        txt_stok.text = intent.getStringExtra(EXTRA_STOK)
        txt_deskripsi.text = intent.getStringExtra(EXTRA_DESKRIPSI)

        btn_kembali.setOnClickListener{
            val backItem = Intent(this@ExplicitActivityIntent, MainActivity::class.java)
            startActivity(backItem)
        }

    }
}