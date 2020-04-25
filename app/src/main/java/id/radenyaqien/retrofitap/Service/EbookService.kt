package id.radenyaqien.retrofitap.Service

import id.radenyaqien.retrofitap.Model.latest.EbookLatest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface EbookService {

    @GET("api.php?latest")
    fun GetEbooklist(): Call<EbookLatest>

    @GET("http://app.xmgi.net//api.php?book_id={id}")
    fun getEbookDetail(@Path("id") id: Int): Call<ResponseBody>
}