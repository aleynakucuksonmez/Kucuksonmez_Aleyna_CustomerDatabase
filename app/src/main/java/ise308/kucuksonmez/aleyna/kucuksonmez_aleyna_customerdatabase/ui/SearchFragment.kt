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

class SearchFragment: Fragment() {
    override fun onCreateView (
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.content_search, container, false)

        val dm = DataManager(activity!!)

        val btnSearch = view.findViewById<Button>(R.id.btn_search_customer)
        val etName = view.findViewById<EditText>(R.id.btn_search_name)
       val tvSearchResults = view.findViewById<TextView>(R.id.tv_search_result)

        btnSearch.setOnClickListener{
            tvSearchResults.text = dm.searchCustomerByName(etName.text.toString())

        }
        return view
    }

}