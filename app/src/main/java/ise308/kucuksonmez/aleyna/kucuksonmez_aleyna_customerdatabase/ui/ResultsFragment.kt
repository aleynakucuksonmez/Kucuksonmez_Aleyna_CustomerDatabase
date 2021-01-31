package ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.R
import ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.db.DataManager

class ResultsFragment: Fragment() {
     fun OncreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View?{

        val view = inflater.inflate(R.layout.content_result, container, false)

        val tvResults = view.findViewById<TextView>(R.id.tv_results)

        val dm = DataManager(activity!!)
        tvResults.text = dm.searchAll()
         val assignedBy = view.findViewById<TextView>(R.id.listAssignedBy)
         val assignedTo = view.findViewById<TextView>(R.id.listAssignedTo)
        return view
    }
}