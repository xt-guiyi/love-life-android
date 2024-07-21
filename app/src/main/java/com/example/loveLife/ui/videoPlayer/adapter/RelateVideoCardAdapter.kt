package com.example.loveLife.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loveLife.databinding.VideoCard2Binding
import com.example.loveLife.entity.VideoInfo
import com.example.loveLife.utils.CommonUtil
import com.example.loveLife.utils.GlideUtil
import com.example.loveLife.utils.TimeUtil
import com.google.android.material.imageview.ShapeableImageView

class RelateVideoCardAdapter(private val videoData: MutableList<VideoInfo>): RecyclerView.Adapter<RelateVideoCardAdapter.ViewHolder>() {
    private var mClickCall: ((view: View,position: Int, videoData: VideoInfo) -> Unit)? = null

    public fun setOnClickListenerByRoot(mClickCall: (view: View,position: Int, videoData: VideoInfo) -> Unit) {
        this.mClickCall = mClickCall
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = VideoCard2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(videoData[position])
        holder.binding.root.setOnClickListener {
            mClickCall?.invoke(it, position, videoData[position])
        }
    }

    override fun getItemCount(): Int {
        return videoData.size
    }

    class ViewHolder(val binding: VideoCard2Binding):RecyclerView.ViewHolder(binding.root) {
        fun bindTo(data: VideoInfo){
            binding.title.text = data.title
            binding.author.text = data.owner.name
            binding.duration.text = TimeUtil.geDurationTime(data.duration)
            binding.views.text = CommonUtil.formatNumber(data.views)
            GlideUtil.loadUrl(data.pic, binding.pic.context, binding.pic as ShapeableImageView) // 必须指定为ShapeableImageView
        }
    }


    fun addItems(newItems: List<VideoInfo>) {
        val startPosition = videoData.size
        videoData.addAll(newItems)
        notifyItemRangeInserted(startPosition, newItems.size)
    }
}