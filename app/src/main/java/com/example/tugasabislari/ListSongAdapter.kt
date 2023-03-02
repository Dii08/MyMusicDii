package com.example.tugasabislari

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListSongAdapter (private val listSong: ArrayList<Musik>) : RecyclerView.Adapter<ListSongAdapter.ListViewHolder>(){
    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)


    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, from, photo) = listSong[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvFrom.text = from

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listSong[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Musik)
    }


    override fun getItemCount(): Int {
        return listSong.size

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_song, viewGroup, false)
        return ListViewHolder(view)
    }

}