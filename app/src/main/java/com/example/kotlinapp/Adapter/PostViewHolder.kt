package com.example.kotlinapp.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_layout.view.*

class PostViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
    val txt_author=itemview.txt_author
    val txt_title=itemview.txt_title
    val txt_content=itemview.txt_content


}