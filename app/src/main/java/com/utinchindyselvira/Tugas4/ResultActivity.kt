package com.utinchindyselvira.Tugas4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    companion object{
        const val RESULT_CODE = 200
        const val EXTRA_COLOR = "extra_color"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btn_pilih.setOnClickListener{
            if (rad_color.checkedRadioButtonId != 0){
                var value = "#ffffff"
                when(rad_color.checkedRadioButtonId){
                    R.id.rad_biru -> value = "#00BFFF"
                    R.id.rad_merah -> value = "#ff0000"
                    R.id.rad_kuning -> value =  "#ffff00"
                    R.id.rad_hijau -> value = "#008000"
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_COLOR, value)
                setResult(200, resultIntent)
                finish()
            }
        }
    }
}