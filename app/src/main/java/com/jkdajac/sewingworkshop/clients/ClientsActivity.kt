package com.jkdajac.sewingworkshop.clients

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
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
            finish()
        }
    }

    override fun deleteItem(index: Int) {
        val field = fieldList.get(index)
        fieldDatabase.fieldDao().deleteField(field)
        getData()
        adapter.notifyDataSetChanged()

    }

    @SuppressLint("InflateParams")
    override fun editItem(index: Int) {

       val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.activity_edit, null)
        val name = v.findViewById<EditText>(R.id.etName)
        val lastname = v.findViewById<EditText>(R.id.etLastName)
        val field = fieldList.get(index)
        field.name = name.text.toString()
        field.lastname = lastname.text.toString()
        fieldDatabase.fieldDao().updateField(field)
        getData()
        adapter.notifyDataSetChanged()


//        val addDialog = AlertDialog.Builder(this)
//        addDialog
//            .setView(v)
//            .setPositiveButton("Ok") { dialog, _ ->
//                val note = notesList.get(index)
//                note.title = title.text.toString()
//                note.description = description.text.toString()
//                noteDatabase.noteDao().updateNote(note)
//                getData()
//                adapter.notifyDataSetChanged()
//                Toast.makeText(this, "User Information is Edited", Toast.LENGTH_SHORT).show()
//                dialog.dismiss()
//
//            }
//            .setNegativeButton("Cancel") { dialog, _ ->
//                dialog.dismiss()
//            }
//            .create()
//            .show()
    }

    fun getData() {
        val fieldFromDb: List<Field> = fieldDatabase.fieldDao().getAll()
        fieldList.clear()
        fieldList.addAll(fieldFromDb)
    }
}

