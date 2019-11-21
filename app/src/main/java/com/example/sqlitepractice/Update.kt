package com.example.sqlitepractice


import android.content.ContentValues
import android.os.Bundle
import android.provider.BaseColumns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sqlitepractice.databinding.FragmentUpdateBinding
import androidx.databinding.DataBindingUtil as DataBindingUtil1

/**
 * A simple [Fragment] subclass.
 */
class Update : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    val userEn = UserContract.UserEntry


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil1.inflate(inflater,R.layout.fragment_update,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myHelper = DatabaseHandler(view.context)

        binding.insert.setOnClickListener {
            if(binding.Name.text.toString().isNotBlank() && binding.Phone.toString().isNotBlank()){

                val db = myHelper.writableDatabase
                val user = User(binding.Name.text.toString(), binding.Phone.text.toString())

                val values = ContentValues().apply{
                    put(userEn.COL_NAME, user.name)
                    put(userEn.COL_PHONE, user.phone)
                }
                val newRowId = db?.insert(userEn.TABLE_NAME, null, values)
            }

        }

        binding.read.setOnClickListener {
            val db = myHelper.readableDatabase

            val projection = arrayOf(BaseColumns._ID, userEn.COL_NAME, userEn.COL_PHONE)

            val selection = "${userEn.COL_PHONE} = 1234567890"
            val selectionArgs = arrayOf("1234567890")

            val cursor = db.rawQuery(
                "Select * from ${userEn.TABLE_NAME}", null
            )
            var nameList : MutableList<User> = ArrayList()

            while(cursor.moveToNext()){
                var user = User(cursor.getString(1), cursor.getString(2))
                user.id = cursor.getString(0).toInt()
                nameList.add(user)
            }
            if(nameList.isNotEmpty()){
                binding.reading.text = nameList[0].formatStr()
            }

        }
        binding.delete.setOnClickListener {
            val db = myHelper.writableDatabase
            db.execSQL("delete from ${userEn.TABLE_NAME}")
        }


    }


}
