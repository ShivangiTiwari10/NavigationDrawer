package com.example.navigationdrawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawer.ui.home.HomeFragment
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(val context: HomeFragment, val productArrayList: List<Comment>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context.requireContext())
            .inflate(R.layout.each_items, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.user.username
        holder.userId.text = currentItem.user.id.toString()
        holder.body.text = currentItem.body

    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView
        var userId: TextView
        var body: TextView
        var image: CircleImageView

        init {
            title = itemView.findViewById(R.id.productTitle)
            userId = itemView.findViewById(R.id.userId)
            body = itemView.findViewById(R.id.userBody)
            image = itemView.findViewById(R.id.productImage)

        }
    }

}