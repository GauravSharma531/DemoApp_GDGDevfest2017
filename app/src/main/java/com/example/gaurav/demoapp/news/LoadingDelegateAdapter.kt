package  com.example.gaurav.demoapp.news

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.gaurav.demoapp.R
import com.example.gaurav.demoapp.util.adapter.ViewType
import com.example.gaurav.demoapp.util.adapter.ViewTypeDelegateAdapter
import com.example.gaurav.demoapp.util.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.loader))
}