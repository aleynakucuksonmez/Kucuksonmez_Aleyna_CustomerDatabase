package ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.icu.lang.UProperty.NAME
import android.provider.BaseColumns._ID
import android.provider.ContactsContract.DisplayNameSources.EMAIL
import android.util.Log
import ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.db.DataManager
import java.util.ArrayList


class CustomerData(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {


        val newTableQuery = "CREATE TABLE"+ TABLE_CUSTOMER + "( " +
                _ID + "integer primary key autoincrement not null , " +
                NAME +" text not null ,"+
                EMAIL +" text not null ," +
               PHONE_NUM +" text not null)"
        Log.i(db.TAG, "-----> onCreate: $newTableQuery")

        db?.execSQL(newTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER)

        // create table again
        onCreate(db)
    }
    val db : SQLiteDatabase


    init{

        db = CustomSQLiteOpenHelper(context).writableDatabase

    }
    fun createCustomer(customer: Customer) {

        val values: ContentValues = ContentValues()
        values.put(NAME, customer.NAME)
        values.put(CUSTOMER_ASSIGNED_TO, customer.assignedTo)
        values.put(CUSTOMER_ASSIGNED_BY, customer.assignedBy)

        values.put(EMAIL, customer.EMAIL)
        values.put(CUSTOMER_ASSIGNED_TO, customer.assignedTo)
        values.put(CUSTOMER_ASSIGNED_BY, customer.assignedBy)

        values.put(PHONE_NUM, customer.PHONE_NUM)
        values.put(CUSTOMER_ASSIGNED_TO, customer.assignedTo)
        values.put(CUSTOMER_ASSIGNED_BY, customer.assignedBy)

        db.insert(TABLE_CUSTOMER, null, values)


        db.close()
    }
    fun readCustomer(): ArrayList<Customer> {

        val list: ArrayList<Customer> = ArrayList()


        val selectAll = "SELECT * FROM " + TABLE_CUSTOMER
        val cursor: Cursor = db.rawQuery(selectAll, null)


        if(cursor.moveToFirst()) {
            do {
                var customer = Customer()
                customer._ID = cursor.getInt(cursor.getColumnIndex(_ID))
                customer.NAME = cursor.getString(cursor.getColumnIndex(NAME))
                customer.assignedBy = cursor.getString(cursor.getColumnIndex(CUSTOMER_ASSIGNED_BY))
                customer.assignedTo = cursor.getString(cursor.getColumnIndex(CUSTOMER_ASSIGNED_TO))

                list.add(customer)

            } while (cursor.moveToNext())
        }
        return list
    }


}

}