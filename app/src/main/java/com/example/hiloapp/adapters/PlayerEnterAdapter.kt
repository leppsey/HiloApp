package com.example.hiloapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiloapp.PlayerItem
import com.example.hiloapp.R
import com.example.hiloapp.databinding.ListNameEnterBinding


class PlayerEnterAdapter: ListAdapter<PlayerItem,PlayerEnterAdapter.Holder>(Comparator()) {
    class Holder(view: View): RecyclerView.ViewHolder(view){
        private val binding=ListNameEnterBinding.bind(view)
        fun bind(item:PlayerItem) {
            binding.PlayerNameView.text=item.name
        }

    }
    class Comparator: DiffUtil.ItemCallback<PlayerItem>(){
        override fun areItemsTheSame(oldItem: PlayerItem, newItem: PlayerItem): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: PlayerItem, newItem: PlayerItem): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.list_name_enter,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.bind(getItem(position))

    }

}