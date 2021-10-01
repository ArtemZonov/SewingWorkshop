package com.jkdajac.sewingworkshop.clients


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jkdajac.sewingworkshop.MainActivity
import com.jkdajac.sewingworkshop.R
import com.jkdajac.sewingworkshop.clients.database.AppDatabase
import com.jkdajac.sewingworkshop.clients.database.Field
import com.jkdajac.sewingworkshop.clients.database.FieldAdapter
import kotlinx.android.synthetic.main.activity_clients.*



class ClientsActivity : AppCompatActivity(), FieldAdapter.ViewHolder.ItemCallback {

    lateinit var adapter: FieldAdapter
    lateinit var fieldDatabase: AppDatabase
    lateinit var fieldList: ArrayList<Field>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clients)

        fieldList = ArrayList<Field>()
        fieldDatabase = AppDatabase.getDatabase(this)
        getData()
        adapter = FieldAdapter(this, fieldList, this)
        rvKlients.layoutManager = LinearLayoutManager(this)
        rvKlients.adapter = adapter

        floatingNewKlient.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }
        ivBackKlients.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun deleteItem(index: Int) {
        val field = fieldList.get(index)
        fieldDatabase.fieldDao().deleteField(field)
        getData()
        adapter.notifyDataSetChanged()

    }

    fun getData() {
        val fieldFromDb: List<Field> = fieldDatabase.fieldDao().getAll()
        fieldList.clear()
        fieldList.addAll(fieldFromDb)
    }
}

