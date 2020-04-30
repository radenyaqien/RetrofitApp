package id.radenyaqien.retrofitap.Service

import id.radenyaqien.retrofitap.Model.Ebook
import retrofit2.Call
import retrofit2.http.*

interface EbookService {

    @GET("api.php?latest")
    fun GetEbooklist(): Call<Ebook>

    @GET("http://app.xmgi.net//api.php")
    fun getEbookDetail(@QueryMap filter: HashMap<String, Int>): Call<Ebook>
}