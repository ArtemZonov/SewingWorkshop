package com.jkdajac.sewingworkshop.clients.database

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jkdajac.sewingworkshop.R
import com.jkdajac.sewingworkshop.clients.EditActivity
import kotlinx.android.synthetic.main.activity_edit.view.*
import kotlinx.android.synthetic.main.field_item.view.*

class FieldAdapter(
    val contextA: Context,
    private val fieldList: List<Field>,
    val callback: ViewHolder.ItemCallback
) : RecyclerView.Adapter<FieldAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { val context = contextA
        return ViewHolder(LayoutInflater.from(contextA).inflate(R.layout.field_item, parent, false),context)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(fieldList[position])
        holder.name?.text = fieldList[position].name
        holder.description?.text = fieldList[position].description
        holder.lastname?.text = fieldList[position].lastname
        holder.phonenumber?.text = fieldList[position].phonenumber
        holder.deleteItem?.setOnClickListener {
            callback.deleteItem(position)
        }

    }
    class ViewHolder(itemView: View, contextV : Context) : RecyclerView.ViewHolder(itemView) {
        private val tvItemName : TextView = itemView.findViewById(R.id.tvItemName)
        val context = contextV

        fun setData(item : Field){
            tvItemName.text = item.name
            itemView.setOnClickListener {
                val intent = Intent(context, EditActivity :: class.java).apply {
                    putExtra(MyIntentConstants.I_NAME_KEY, item.name)
                    putExtra(MyIntentConstants.I_LASTNAME_KEY, item.lastname)
                    putExtra(MyIntentConstants.I_PHONENUMBER_KEY, item.phonenumber)
                    putExtra(MyIntentConstants.I_DESCRIPTION_KEY, item.description)
                }
                context.startActivity(intent)
            }

        }

        var name: TextView? = null
        var description: TextView? = null
        var phonenumber: TextView? = null
        var lastname: TextView? = null
        var deleteItem: ImageView? = null


        init {
            name = itemView.tvItemName
            description = itemView.etDescription
            lastname = itemView.tvItemLastname
            phonenumber = itemView.etPhoneNumber
            deleteItem = itemView.ivItemDelete

        }

        interface ItemCallback {
            fun deleteItem(index: Int)

        }
    }
    override fun getItemCount(): Int {
        return fieldList.size
    }
}


