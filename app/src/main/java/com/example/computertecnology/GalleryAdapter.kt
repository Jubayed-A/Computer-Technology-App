package com.example.computertecnology

import android.app.Activity
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class GalleryAdapter(private var galleryArrayList: ArrayList<Gallery>, var context: Activity) :
    RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    // galleryViewHolder code here
    class GalleryViewHolder(galleryView: View) : RecyclerView.ViewHolder(galleryView) {

        val gImg = galleryView.findViewById<ImageView>(R.id.img2)
    }

    // createViewHolder code here
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val galleryView =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_gallery_view, parent, false)
        return GalleryViewHolder(galleryView)
    }

    // getItemCount code here
    override fun getItemCount(): Int {
        return galleryArrayList.size
    }

    // onBindViewHolder code here
    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val currentImage = galleryArrayList[position]
        holder.gImg.setImageResource(currentImage.image)
    }
}