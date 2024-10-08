package com.unict.inkrecognition.adaperts

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.unict.inkrecognition.R
import com.unict.inkrecognition.activities.MainActivity
import com.unict.inkrecognition.holders.FileListHolder
import java.io.File

class FileListAdapter(private val dataSet: ArrayList<File>, private val context: MainActivity): RecyclerView.Adapter<FileListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileListHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.file_list, parent, false)
        return FileListHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: FileListHolder, position: Int) {
        holder.textView.text = dataSet[position].name

        holder.imageView.setOnClickListener {
            //TODO rivedere
            val mBuilder = AlertDialog.Builder(context,android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen)
            val mAlertDialog = mBuilder.create()
            mAlertDialog.setContentView(R.layout.alert_image)
            val imageView: ImageView = mAlertDialog.findViewById(R.id.image_full_screen)
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
            Glide.with(context).load(dataSet[position]).apply(options).into(imageView)
            mAlertDialog.show()
        }
    }
}