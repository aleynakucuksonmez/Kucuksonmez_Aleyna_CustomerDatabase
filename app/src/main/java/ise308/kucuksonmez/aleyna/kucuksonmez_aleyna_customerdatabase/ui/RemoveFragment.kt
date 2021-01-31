package ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.R
import ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.db.DataManager

class RemoveFragment: Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.content_remove, container, false)
        val dm = DataManager(activity!!)
        val btnRemove = view.findViewById<Button>(R.id.btn_remove_customer)
        val etName = view.findViewById<EditText>(R.id.btn_remove_name)
       // val etEmail = view.findViewById<EditText>(R.id.btn_remove_email)
       // val etPhone_num = view.findViewById<EditText>(R.id.btn_remove_phone_num)

        btnRemove.setOnClickListener{
            dm.remove(etName.text.toString())

        }
        return view
        }

    }