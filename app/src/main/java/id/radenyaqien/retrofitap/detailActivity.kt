package id.radenyaqien.retrofitap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import id.radenyaqien.retrofitap.Model.Ebook
import id.radenyaqien.retrofitap.Service.EbookService
import id.radenyaqien.retrofitap.Service.Services
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class detailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val inten = intent
        val bundle = inten.extras

        if (bundle?.containsKey(ARG_ITEM_ID)!!) {
            val id = inten.getIntExtra(ARG_ITEM_ID, 0)
            loadDetail(id)
        }


    }

    private fun loadDetail(id: Int) {

        val filter = HashMap<String, Int>()
        filter.put("book_id", id)

        val EbookServ = Services.buildService(EbookService::class.java)
        val request = EbookServ.getEbookDetail(filter)
        request.enqueue(object : Callback<Ebook> {
            override fun onFailure(call: Call<Ebook>, t: Throwable) {
                Toast.makeText(applicationContext, "Cannot load data", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(call: Call<Ebook>, response: Response<Ebook>) {
                if (response.isSuccessful) {
                    response.body()!!.EBOOK_APP.let {
                        tv_bookname.text = it[0].book_title
                        bookAuthor.text = it[0].author_name
                        tvCategory.text = it[0].category_name
                        tvDescription.text = it[0].book_description
                        Glide.with(this@detailActivity)
                            .load(Services.URLIMAGE + it[0].book_cover_img)
                            .into(imgbook)
//                    val uri = it[0].book_file_url
//                    button.setOnClickListener {
//                        val intent = Intent(Intent.ACTION_VIEW)
//                        intent.data = Uri.parse(uri)
//                        startActivity(intent)
//
//                         }

                    }
                }
            }
        })
    }


    companion object {

        const val ARG_ITEM_ID = "item_id"
    }
}
