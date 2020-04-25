package id.radenyaqien.retrofitap

import id.radenyaqien.retrofitap.Model.latest.EBOOKAPP


object EbookData {

    val Ebooks = ArrayList<EBOOKAPP>()
    private var COUNT = 5

    private var dummy_description =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit."

    init {

        val ebook1 = EBOOKAPP(
            id = 1
            , cat_id = "7"
            , aid = "8"
            , author_id = "26"
            , author_name = "yaqin"
            , book_bg_img = "53616_All-In-One-Videos_Banner.jpg"
            , book_file_type = "server_url"
            , book_cover_img = "86998_51z5IxdRwyL._SX322_BO1204203200_.jpg"
            , book_description = dummy_description
            , book_title = "kotlin dasar"
            , book_views = "66"
            , category_name = "pemrograman"
            , cid = "2"
            , total_rate = "2"
            , rate_avg = "3"
        )


    }

    fun getEbook(id: Int): EBOOKAPP? {
        for (i in Ebooks.indices) {
            if (Ebooks[i].id == id) {
                return Ebooks[i]
            }
        }
        return null
    }
}