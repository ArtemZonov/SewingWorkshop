package com.jkdajac.sewingworkshop.clients

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jkdajac.sewingworkshop.R
import com.jkdajac.sewingworkshop.clients.database.ListItem
import com.jkdajac.sewingworkshop.clients.database.MyIntentConstants
import kotlinx.android.synthetic.main.item_rvclient.view.*

class ClientsAdapter(listNames : ArrayList<ListItem>, contextC : Context) : RecyclerView.Adapter<ClientsAdapter.ClientsHolder>() {
    val listArray = listNames
    val context = contextC

    class ClientsHolder(itemView: View, contextV: Context) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tvNameItem
        val tvLastName = itemView.tvLastnameItem
        val context = contextV
        fun setData(item : ListItem){
            tvName.text = item.name
            tvLastName.text = item.lastname
            itemView.setOnClickListener {
                val intent = Intent(context, EditActivity :: class.java).apply{
                     putExtra(MyIntentConstants.I_NAME_KEY, item.name)
                     putExtra(MyIntentConstants.I_LASTNAME_KEY, item.lastname)
                     putExtra(MyIntentConstants.I_PHONENUMBER_KEY, item.phonenumber)
                     putExtra(MyIntentConstants.I_DESCRIPTION_KEY, item.description)
                }
                context.startActivity(intent)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientsHolder {

          val inflater =  LayoutInflater.from(parent.context)
        return  ClientsHolder(inflater.inflate(R.layout.item_rvclient, parent, false), context)

    }

    override fun onBindViewHolder(holder: ClientsHolder, position: Int) {
        holder.setData(listArray.get(position))
    }

    override fun getItemCount(): Int {
       return listArray.size
    }

    fun updateAdapter(listItems : List<ListItem>){
        listArray.clear()
        listArray.addAll(listItems)
        notifyDataSetChanged()

    }
}