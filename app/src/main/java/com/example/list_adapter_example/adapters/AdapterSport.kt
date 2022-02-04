package com.example.list_adapter_example.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.list_adapter_example.R
import com.example.list_adapter_example.databinding.ItemListBinding
import com.example.list_adapter_example.interfaces.OnClickListener
import com.example.list_adapter_example.model_data.SportModelData

class AdapterSport (private val listener: OnClickListener): ListAdapter<SportModelData,RecyclerView.ViewHolder>(SportDiffCall()){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate((R.layout.item_list), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val sport = getItem(position)
        with(holder as ViewHolder) {
            binding.tvName.text = sport.name
            Glide.with(context)
                .load(sport.url)
                .into(binding.imgPhoto)
        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemListBinding.bind(view)
    }



    class SportDiffCall: DiffUtil.ItemCallback<SportModelData>() {

        override fun areItemsTheSame(oldItem: SportModelData, newItem: SportModelData): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: SportModelData, newItem: SportModelData): Boolean = oldItem == newItem
    }

}