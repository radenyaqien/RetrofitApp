package id.radenyaqien.retrofitap.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.radenyaqien.retrofitap.Model.EBOOKAPP
import id.radenyaqien.retrofitap.R
import id.radenyaqien.retrofitap.detailActivity

class Adapter(private val ebookList: List<EBOOKAPP>) : RecyclerView.Adapter<Adapter.Viewholder>() {
    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView = itemView.findViewById(R.id.tv_list_name)
        lateinit var ebook: EBOOKAPP

        override fun toString(): String {
            //return super.toString()
            return """${super.toString()} '${tv.text}'"""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return Viewholder(view)
    }

    override fun getItemCount(): Int {

        return ebookList.size

    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.ebook = ebookList[position]
            //ebookList.[position]
        holder.tv.text = holder.ebook.book_title

        holder.itemView.setOnClickListener { view ->
            val context = view.context
            val intent = Intent(context, detailActivity::class.java)
            intent.putExtra(detailActivity.ARG_ITEM_ID, holder.ebook.id)

            context.startActivity(intent)

        }


    }
}