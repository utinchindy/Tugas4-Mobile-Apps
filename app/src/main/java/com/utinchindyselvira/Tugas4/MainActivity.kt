package com.utinchindyselvira.Tugas4

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utinchindyselvira.Tugas4.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_simple_intent.setOnClickListener{
            val simpleIntent = Intent(this@MainActivity, SimpleActivity::class.java)
            startActivity(simpleIntent)
        }

        btn_intent_with_data.setOnClickListener{
            val dataIntent = Intent(this@MainActivity, ExplicitActivityIntent::class.java)

            dataIntent.putExtra(ExplicitActivityIntent.EXTRA_NAMA, "Laptop Acer Swift 7")
            dataIntent.putExtra(ExplicitActivityIntent.EXTRA_HARGA, "Rp. 30.000.00")
            dataIntent.putExtra(ExplicitActivityIntent.EXTRA_STOK, "10 Unit")
            dataIntent.putExtra(ExplicitActivityIntent.EXTRA_DESKRIPSI, "Swift 7 (SF714-52T) diklaim sebagai salah satu laptop tertipis dan teringan di dunia dengan ketipisan 9,95 mm dan bobot hanya 890 gram saja. Gokil, kan?\n" +
                    "\n" +
                    "Seri terbaru yang dirilis pada 2019 ini hadir dengan panel layar sentuh 14 inci Full HD (1920 x 1080 piksel) berteknologi IPS yang menjanjikan tampilan lebih jernih.\n" +
                    "\n" +
                    "Untuk performanya sendiri, Swift 7 sudah dibekali prosesor Intel Core i7-8500Y dengan dukungan kartu grafis Intel UHD Graphics 615, geng.")
            startActivity(dataIntent)
        }

        btn_intent_with_parcelable.setOnClickListener{
            val parcelIntent = Intent(this@MainActivity, ParcelActivity::class.java)
            val user = User("Laptop Acer Swift 7", "Rp. 30.000.00", "10", "Swift 7 (SF714-52T) diklaim sebagai salah satu laptop tertipis dan teringan di dunia dengan ketipisan 9,95 mm dan bobot hanya 890 gram saja. Gokil, kan?\n" +
                    "\n" +
                    "Seri terbaru yang dirilis pada 2019 ini hadir dengan panel layar sentuh 14 inci Full HD (1920 x 1080 piksel) berteknologi IPS yang menjanjikan tampilan lebih jernih.\n" +
                    "\n" +
                    "Untuk performanya sendiri, Swift 7 sudah dibekali prosesor Intel Core i7-8500Y dengan dukungan kartu grafis Intel UHD Graphics 615, geng.")
            parcelIntent.putExtra(ParcelActivity.EXTRA_USER, user)
            startActivity(parcelIntent)
        }

        btn_implicit_intent.setOnClickListener{
            val nomor = "089639166560"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$nomor"))
            startActivity(intent)
        }

        btn_intent_with_result.setOnClickListener{
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 200){
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            view_result.setBackgroundColor(Color.parseColor(color.toString()))
        }
    }


}