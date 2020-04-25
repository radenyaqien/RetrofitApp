package id.radenyaqien.retrofitap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import id.radenyaqien.retrofitap.Adapter.Adapter
import id.radenyaqien.retrofitap.Model.latest.EBOOKAPP
import id.radenyaqien.retrofitap.Model.latest.EbookLatest
import id.radenyaqien.retrofitap.Service.EbookService
import id.radenyaqien.retrofitap.Service.Services
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var json: JsonElement
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadInit()

    }


    private fun loadInit() {

        val EbookServ = Services.buildService(EbookService::class.java)

        val filter = HashMap<String, String>()

        val request = EbookServ.GetEbooklist()

        request.enqueue(object : Callback<EbookLatest> {
            override fun onFailure(call: Call<EbookLatest>, t: Throwable) {
                Toast.makeText(applicationContext, "Cannot load data", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<EbookLatest>, response: Response<EbookLatest>) {
                if (response.isSuccessful) {
//                    try {
                    response.body()!!.EBOOK_APP.let {

                        ebookview.layoutManager = LinearLayoutManager(this@MainActivity)
                        ebookview.adapter = Adapter(EbookLatest(it))
                    }


                }
            }


        })


    }


}
