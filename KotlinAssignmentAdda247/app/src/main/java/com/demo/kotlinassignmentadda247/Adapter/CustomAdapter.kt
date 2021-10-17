package com.demo.kotlinassignmentadda247.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.kotlinassignmentadda247.Model.ApiResponce
import com.demo.kotlinassignmentadda247.Model.User
import com.demo.kotlinassignmentadda247.databinding.RowTileBinding

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    var datalist= mutableListOf<User>()
    class CustomViewHolder(val binding: RowTileBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val binding= RowTileBinding.inflate(inflater,parent,false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.binding.nameData.setText(datalist.get(position).name)
        holder.binding.emailData.setText(datalist.get(position).email)
        holder.binding.genderData.setText(datalist.get(position).gender)
        holder.binding.statusData.setText(datalist.get(position).status)

        if(holder.binding.statusData.text.toString().equals("active"))
        {
            holder.binding.statusData.setTextColor(Color.parseColor("#66CC00"))


        } else {
            holder.binding.statusData.setTextColor(Color.parseColor("#FF0000"))
        }
    }

    override fun getItemCount(): Int {
      return  datalist.size
    }

    fun refreshList(it: ApiResponce?) {
        if (it != null) {
            this.datalist= it.data.toMutableList()
            notifyDataSetChanged()
        }

    }
}