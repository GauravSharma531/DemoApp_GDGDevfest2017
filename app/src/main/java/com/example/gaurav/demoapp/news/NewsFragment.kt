package com.example.gaurav.demoapp.news

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gaurav.demoapp.R
import com.example.gaurav.demoapp.news.data.RedditNewsItem
import com.example.gaurav.demoapp.util.inflate
import kotlinx.android.synthetic.main.news_fragment.*
import java.util.*

/**
 * Created by Gaurav on 04/11/17.
 */

class NewsFragment : Fragment() ,NewsDelegateAdapter.onViewSelectedListener {
    override fun onItemSelected(url: String?) {
        if (url.isNullOrEmpty()) {
            Snackbar.make(rv_news, "No URL assigned to this news", Snackbar.LENGTH_LONG).show()
        } else {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val view = inflater.inflate(R.layout.news_fragment, container, false)
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_news.setHasFixedSize(true)
        rv_news.layoutManager = LinearLayoutManager(context)
        initAdapter()

        if (savedInstanceState == null) {
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        Date().time, // time
                        "", // image url
                        "url"
                ))
            }
            (rv_news.adapter as NewsAdapter).addNews(news)
        }
    }

    private fun initAdapter() {
        if (rv_news.adapter == null) {
            rv_news.adapter = NewsAdapter(this)
        }

    }


}