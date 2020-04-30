package id.radenyaqien.retrofitap.Model


import com.google.gson.annotations.SerializedName

data class GsonModel(
    @SerializedName("aid")
    var aid: String,
    @SerializedName("author_id")
    var authorId: String,
    @SerializedName("author_name")
    var authorName: String,
    @SerializedName("book_bg_img")
    var bookBgImg: String,
    @SerializedName("book_cover_img")
    var bookCoverImg: String,
    @SerializedName("book_description")
    var bookDescription: String,
    @SerializedName("book_file_type")
    var bookFileType: String,
    @SerializedName("book_title")
    var bookTitle: String,
    @SerializedName("book_views")
    var bookViews: String,
    @SerializedName("cat_id")
    var catId: String,
    @SerializedName("category_name")
    var categoryName: String,
    @SerializedName("cid")
    var cid: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("rate_avg")
    var rateAvg: String,
    @SerializedName("total_rate")
    var totalRate: String
)