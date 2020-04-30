package id.radenyaqien.retrofitap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.radenyaqien.retrofitap.Adapter.Adapter
import id.radenyaqien.retrofitap.Model.Ebook
import id.radenyaqien.retrofitap.Service.EbookService
import id.radenyaqien.retrofitap.Service.Services
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ebookview.layoutManager = LinearLayoutManager(this@MainActivity)
        loadInit()

    }


    private fun loadInit() {

        val bookServ = Services.buildService(EbookService::class.java)



        val request = bookServ.GetEbooklist()

        request.enqueue(object : Callback<Ebook> {
            override fun onFailure(call: Call<Ebook>, t: Throwable) {
                Toast.makeText(applicationContext, "Cannot load data", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(call: Call<Ebook>, response: Response<Ebook>) {
                if (response.isSuccessful) {
//                    try {
                    response.body()!!.EBOOK_APP.let {


                        ebookview.adapter = Adapter(it)
                    }


                }
            }


        })


    }


}
