package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.model.Model

class Adapter(val onItemClick: (model: Model) -> Unit) :
    RecyclerView.Adapter<Adapter.AdapterViewHolder>() {

    private var list: List<Model> = ArrayList()

    fun setList(list: List<Model>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class AdapterViewHolder(var binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick(list[adapterPosition])
            }
        }

        fun onBind(model: Model) {
            binding.txtName.text = model.name
            Glide
                .with(binding.ivImage.context)
                .load(model.image)
                .into(binding.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}