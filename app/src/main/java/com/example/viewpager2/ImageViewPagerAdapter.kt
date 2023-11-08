package com.example.viewpager2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sample.databinding.ItemImageViewPagerBinding


class ImageViewPagerAdapter(
    private val items : List<String>
) : RecyclerView.Adapter<ImageViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
        val binding = ItemImageViewPagerBinding.inflate(inflatedView, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(
        private val binding : ItemImageViewPagerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : String) {
            binding.apply {
                Glide.with(root.context)
                    .load(item)
                    .into(imageView)
            }
        }
    }
}