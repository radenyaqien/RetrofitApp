package id.radenyaqien.retrofitap.Model.latest

data class EBOOKAPPID(
    var aid: String,
    var author_id: String,
    var author_name: String,
    var book_bg_img: String,
    var book_cover_img: String,
    var book_description: String,
    var book_file_type: String,
    var book_file_url: String,
    var book_title: String,
    var book_views: String,
    var cat_id: String,
    var category_name: String,
    var cid: String,
    var featured: String,
    var id: Int,
    var rate_avg: String,
    var related_books: List<RelatedBook>,
    var total_rate: String,
    var user_comments: List<UserComment>
)