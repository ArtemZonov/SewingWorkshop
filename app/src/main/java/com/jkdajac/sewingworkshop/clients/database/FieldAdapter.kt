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
                    putExtra(MyIntentConstants.I_ETDIS_KEY, item.etDis)
                    putExtra(MyIntentConstants.I_ETOSH_KEY, item.etOsh)
                    putExtra(MyIntentConstants.I_ETOG1_KEY, item.etOg1)
                    putExtra(MyIntentConstants.I_ETOG2_KEY, item.etOg2)
                    putExtra(MyIntentConstants.I_ETOG3_KEY, item.etOg3)
                    putExtra(MyIntentConstants.I_ETOTA_KEY, item.etOta)
                    putExtra(MyIntentConstants.I_ETOB_KEY, item.etOb)
                    putExtra(MyIntentConstants.I_ETDT_B_KEY, item.etDt_b)
                    putExtra(MyIntentConstants.I_ETSHG_KEY, item.etSHg)
                    putExtra(MyIntentConstants.I_ETSHG2_KEY, item.etSHg2)
                    putExtra(MyIntentConstants.I_ETSHS_KEY, item.etSHs)
                    putExtra(MyIntentConstants.I_ETSHP_KEY, item.etSHp)
                    putExtra(MyIntentConstants.I_ETDTP_KEY, item.etDtp)
                    putExtra(MyIntentConstants.I_ETDTS_KEY, item.etDts)
                    putExtra(MyIntentConstants.I_ETVG_KEY, item.etVg)
                    putExtra(MyIntentConstants.I_ETCG_KEY, item.etCg)
                    putExtra(MyIntentConstants.I_ETVPKP_KEY, item.etVpkp)
                    putExtra(MyIntentConstants.I_ETVPKS_KEY, item.etVpks)
                    putExtra(MyIntentConstants.I_ETVPRZ_KEY, item.etVprz)
                    putExtra(MyIntentConstants.I_ETDR_KEY, item.etDr)
                    putExtra(MyIntentConstants.I_ETOR_KEY, item.etOr)
                    putExtra(MyIntentConstants.I_ETOZAP_KEY, item.etOzap)
                    putExtra(MyIntentConstants.I_ETDUB_KEY, item.etDub)
                    putExtra(MyIntentConstants.I_ETDSP_KEY, item.etDsp)
                    putExtra(MyIntentConstants.I_ETDZB_KEY, item.etDzb)
                    putExtra(MyIntentConstants.I_ETDZZ_KEY, item.etDzz)
                    putExtra(MyIntentConstants.I_ETDB_KEY, item.etDb)
                    putExtra(MyIntentConstants.I_ETVS_KEY, item.etVs)
                    putExtra(MyIntentConstants.I_ETOBED_KEY, item.etObed)
                    putExtra(MyIntentConstants.I_ETDT_K_KEY, item.etDt_k)
                    putExtra(MyIntentConstants.I_ETSHK_KEY, item.etSHk)
                    putExtra(MyIntentConstants.I_ETSHN_KEY, item.etSHn)
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


