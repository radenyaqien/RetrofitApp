package id.radenyaqien.retrofitap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonElement
import id.radenyaqien.retrofitap.Adapter.Adapter
import id.radenyaqien.retrofitap.Model.latest.Ebook
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

        loadInit()

    }


    private fun loadInit() {

        val EbookServ = Services.buildService(EbookService::class.java)



        val request = EbookServ.GetEbooklist()

        request.enqueue(object : Callback<Ebook> {
            override fun onFailure(call: Call<Ebook>, t: Throwable) {
                Toast.makeText(applicationContext, "Cannot load data", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(call: Call<Ebook>, response: Response<Ebook>) {
                if (response.isSuccessful) {
//                    try {
                    response.body()!!.EBOOK_APP.let {

                        ebookview.layoutManager = LinearLayoutManager(this@MainActivity)
                        ebookview.adapter = Adapter(Ebook(it))
                    }


                }
            }


        })


    }


}
