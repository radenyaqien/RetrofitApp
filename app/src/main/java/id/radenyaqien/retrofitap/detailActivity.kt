package id.radenyaqien.retrofitap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class detailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    companion object {

        const val ARG_ITEM_ID = "item_id"
    }
}
