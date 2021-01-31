package ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.db.DataManager


private const val TAG = "Main Activity:----> "
class MainActivity : AppCompatActivity() {

    //private lateinit var rvCustomer: RecyclerView
    var dbHandler = CustomerData(this)
    private lateinit var customerList:ArrayList<Customer> =



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveCustomer.setOnClickListener {

                var customer = Customer()
                customer.NAME = enterCustomer.text.toString()
                customer.assignedTo = assignToNAME.text.toString()
                customer.assignedBy = assignedByNAME.text.toString()

                customer.EMAIL = enterCustomer.text.toString()
                customer.assignedTo = assignToEMAIL.text.toString()
                customer.assignedBy = assignedById.text.toString()

                customer.PHONE_NUM= enterCustomer.text.toString()
                customer.assignedTo = assignToPHONE_NUM.text.toString()
                customer.assignedBy = assignedById.text.toString()

        //rvCustomer = findViewById(R.id.rv_customer)

        //rvCustomer!!.LayoutManager = LinearLayoutManager(applicationContext)
        //rvCustomer!!.itemAnimator = DefaultItemAnimator()

        var customer = DataManager(applicationContext)
        //val db = customer.readableDatabase
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {        //Action bar
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
        }





}


