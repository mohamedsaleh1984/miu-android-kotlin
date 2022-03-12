package com.miu.assigfour

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemsListAdapter (var blist:ArrayList<Product>) : RecyclerView.Adapter<ItemsListAdapter.ItemViewHolder>(){
    var onItemClick: ((Product) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsListAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsListAdapter.ItemViewHolder, position: Int) {
        holder.itemView.tvItemName.text = blist[position].Title
        holder.itemView.tvPrice.text = "Price : " + blist[position].Price.toString()
        holder.itemView.tvColor.text = "Color : " + blist[position].Color.toString()
        holder.itemView.imgViewPic.setImageResource(blist[position].Image)

    }

    override fun getItemCount(): Int {
        return blist.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(blist[adapterPosition])
            }
        }
    }
}
