package com.utinchindyselvira.Tugas4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utinchindyselvira.Tugas4.model.User
import kotlinx.android.synthetic.main.activity_explicit_intent.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_parcel.*

class ParcelActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcel)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        txt_produkparcel.text = user.produk
        txt_hargaparcel.text = user.harga
        txt_stokparcel.text = user.stok
        txt_deskripsiparcel.text = user.deskripsi

        btn_backitem.setOnClickListener{
            val backItem = Intent(this@ParcelActivity, MainActivity::class.java)
            startActivity(backItem)
        }

        btn_tanya.setOnClickListener{
            val nomor = "089639166560"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$nomor"))
            intent.putExtra("sms_body", "Hallo, Apakah produk Laptop Acer Swift 7 nya masih ready dan berapa ongkos kirimnya?")
            startActivity(intent)
        }

    }
}