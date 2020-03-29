package com.risma.aplikasikebunbinatang

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list_binatang.view.*


class MainActivity : AppCompatActivity() {

    var listBinatang = ArrayList<Binatang>()
    var adapter: AdapterBinatang? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listBinatang.add(
            Binatang("Gajah", "Gajah termasuk hewan mamalia. Hampir seluruh bagian tubuh dari hewan ini memiliki ukuran yang besar.", R.drawable.gajah, false)
        )
        listBinatang.add(
            Binatang("Singa", "Hewan buas yang memiliki jiwa kepemimpinan dan kharismatik itulah, maka singa tetaplah pantas mendapatkan julukan si raja hutan.", R.drawable.singa, true)
        )
        listBinatang.add(
            Binatang("Sapi", "Sapi diartikan sebagai binatang mamalia pemakan tumbuhan, memiliki tanduk dan kaki empat. Dimanfaatkan manusia dengan tujuan diambil daging juga susunya.", R.drawable.sapi, false)
        )
        listBinatang.add(
            Binatang("Harimau", "Harimau merupakan salah satu binatang buas pemakan daging. Harimau dapat berlari dengan kecepatan yang cukup mengagumkan.", R.drawable.harimau, true)
        )
        listBinatang.add(
            Binatang("Kuda", "Kuda umumnya kuda dimanfaatkan sebagai hewan pengangkut (transportasi) baik orang maupun barang.", R.drawable.kuda, false)
        )
        listBinatang.add(
            Binatang("Elang", "Elang termasuk jenis burung predator. Habitat elang secara umum sering berada di daerah dataran tinggi atau pegunungan.", R.drawable.elang, true)
        )


        adapter = AdapterBinatang(this, listBinatang)
        lvBinatang.adapter = adapter
    }
    inner class AdapterBinatang: BaseAdapter {
        var listBinatang = ArrayList<Binatang>()
        var context: Context? = null

        constructor(context: Context, listOfAnimals: ArrayList<Binatang>): super(){
            this.listBinatang = listOfAnimals
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val binatang = listBinatang[position]
            if(binatang.binatangBuas == true){
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
                        LayoutInflater
                var myView = inflator.inflate(R.layout.item_list_binatang_buas, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDesc.text = binatang.deskripsi!!
                myView.imgGambarBinatang.setImageResource(binatang.gambar!!)

                myView.imgGambarBinatang.setOnClickListener {
                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView

            }else{
                var binatang = listBinatang[position]
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
                        LayoutInflater
                var myView = inflator.inflate(R.layout.item_list_binatang, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDesc.text = binatang.deskripsi!!
                myView.imgGambarBinatang.setImageResource(binatang.gambar!!)

                myView.imgGambarBinatang.setOnClickListener {
                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
        }

        override fun getItem(position: Int): Any {
            return listBinatang[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listBinatang.size
        }
    }
}