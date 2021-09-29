package com.jkdajac.sewingworkshop.clients.database

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jkdajac.sewingworkshop.R
import kotlinx.android.synthetic.main.activity_edit.view.*
import kotlinx.android.synthetic.main.field_item.view.*

class FieldAdapter(
    val context: Context,
    private val fieldList: List<Field>,
    val callback: ViewHolder.ItemCallback
) : RecyclerView.Adapter<FieldAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.field_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name?.text = fieldList[position].name
        holder.description?.text = fieldList[position].description
        holder.lastname?.text = fieldList[position].lastname
        holder.phonenumber?.text = fieldList[position].phonenumber
        holder.deleteItem?.setOnClickListener {
            callback.deleteItem(position)
        }
//        holder.editItem?.setOnClickListener {
//            callback.editItem(position)
//        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView? = null
        var description: TextView? = null
        var phonenumber: TextView? = null
        var lastname: TextView? = null
        var deleteItem: ImageView? = null
        var editItem: ImageView? = null

        init {
            name = itemView.tvItemName
            description = itemView.etDescription
            lastname = itemView.tvItemLastname
            phonenumber = itemView.etPhoneNumber
            deleteItem = itemView.ivItemDelete
            deleteItem = itemView.ivItemEdit
        }

        interface ItemCallback {
            fun deleteItem(index: Int)
            //fun editItem(index: Int)
        }
    }
    override fun getItemCount(): Int {
        return fieldList.size
    }
}


