package com.example.myapplication.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemHomeBinding
import com.example.myapplication.madel.CharacrterResult

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    private var list: List<CharacrterResult> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CharacrterResult>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class CharacterViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(result: CharacrterResult) {
            Glide.with(binding.root).load(result.image).centerCrop().into(binding.img)
            binding.textView.text = result.name
            binding.textView2.text = result.status
        }
    }
}
