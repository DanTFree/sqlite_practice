package com.example.sqlitepractice


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.sqlitepractice.databinding.FragmentReadBinding

/**
 * A simple [Fragment] subclass.
 */
class Read : Fragment() {

    private lateinit var binding: FragmentReadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_read,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myHelper = DatabaseHandler(view.context)

        val db = myHelper.readableDatabase
    }


}
