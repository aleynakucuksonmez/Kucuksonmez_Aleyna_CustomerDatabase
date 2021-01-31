package ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.R
import ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.db.DataManager

class InsertFragment: Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.content_add, container, false)

        val dm= DataManager(activity!!)

        val btnInsert = view.findViewById<Button>(R.id.btn_insert_customer)
        val etName = view.findViewById<EditText>(R.id.btn_insert_name)
        val etEmail = view.findViewById<EditText>(R.id.btn_insert_email)
        val etPhone_num = view.findViewById<EditText>(R.id.btn_insert_phone_num)

        btnInsert.setOnClickListener{
            dm.insert(etName.text.toString(),etEmail.text.toString(),etPhone_num.text.toString())
        }
        return view
    }

}