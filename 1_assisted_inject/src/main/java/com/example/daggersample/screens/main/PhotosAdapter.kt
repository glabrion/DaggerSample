package com.example.daggersample.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daggersample.R
import com.example.daggersample.common.getProgressBar
import com.example.daggersample.databinding.ItemPhotoCardBinding
import com.example.daggersample.model.Photo
import com.squareup.picasso.Picasso

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoCardViewHolder>() {

    private val list = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoCardViewHolder {
        val binding = ItemPhotoCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoCardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun setData(items: List<Photo>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    class PhotoCardViewHolder(private val binding: ItemPhotoCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.ipcIvImage.apply {
                val path = photo.urls?.regular
                Picasso.get()
                    .load(path)
                    .error(R.drawable.ic_error)
                    .placeholder(itemView.context.getProgressBar())
                    .into(binding.ipcIvImage)
            }
        }
    }
}
