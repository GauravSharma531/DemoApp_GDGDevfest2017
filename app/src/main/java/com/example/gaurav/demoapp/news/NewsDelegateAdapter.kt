package com.example.gaurav.demoapp.news

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.gaurav.demoapp.R
import com.example.gaurav.demoapp.news.data.RedditNewsItem
import com.example.gaurav.demoapp.util.adapter.ViewType
import com.example.gaurav.demoapp.util.adapter.ViewTypeDelegateAdapter
import com.example.gaurav.demoapp.util.inflate
import com.example.gaurav.demoapp.util.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter(val viewActions: onViewSelectedListener) : ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onItemSelected(url: String?)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    inner class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {

        private val imgThumbnail = itemView.img_thumbnail
        private val description = itemView.description
        private val author = itemView.author
        private val comments = itemView.comments
        private val time = itemView.time

        fun bind(item: RedditNewsItem) {
            imgThumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = "${item.created}"

            super.itemView.setOnClickListener { viewActions.onItemSelected(item.url)}
        }
    }
}