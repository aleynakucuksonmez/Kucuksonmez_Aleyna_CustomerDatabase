package ise308.kucuksonmez.aleyna.kucuksonmez_aleyna_customerdatabase.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

private const val TAG = "DataManager"
class DataManager(context: Context) {


      val db : SQLiteDatabase


    init{

        db = CustomSQLiteOpenHelper(context).writableDatabase

    }

    fun insert(name: String, email: String, phone_num: String){
        val insertQuery = "INSERT INTO"+ TABLE_CUSTOMER+" ("+ NAME +", "+EMAIL+" ,"+ PHONE_NUM +") VALUES('"+ name +"', '"+ email +"' , '"+ phone_num +"');"
        Log.i(TAG, "-----> insert: $insertQuery")
        db.execSQL(insertQuery)
    }

    fun remove(name: String) {
        val removeQuery= "DELETE FROM"+ TABLE_CUSTOMER +
                         " WHERE "+ NAME +" = '"+ name +"' ; "
        Log.i(TAG, "-----> remove: $removeQuery")
        db.execSQL(removeQuery)
}

    fun searchAll() : String {
        val resultsQuery = "SELECT * FROM " + TABLE_CUSTOMER
        var results: String = ""

        val resultsCursor = db.rawQuery(resultsQuery, null)

        while (resultsCursor.moveToNext()){
            results += resultsCursor.getString(1) +" -->" + resultsCursor.getString(2) + "\n"
        }
        return results
    }

    fun searchCustomerByName(name: String): String {
        val searchQuery = "SELECT * FROM"+ TABLE_CUSTOMER+
                          " WHERE " + NAME +" = '"+name+"';"
        var searchResults: String = ""
        val searchResultsCursor = db.rawQuery(searchQuery, null)
        while (searchResultsCursor.moveToNext()){
            searchResults += searchResultsCursor.getString(1) +" -->" + searchResultsCursor.getString(2) + "\n"
        }
        return searchResults
    }

    private inner class CustomSQLiteOpenHelper(context: Context) :
        SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
        override fun onCreate(db: SQLiteDatabase?) {

            val newTableQuery = "CREATE TABLE"+ TABLE_CUSTOMER + "( " +
                    _ID+ "integer primary key autoincrement not null , " +
                    NAME +" text not null ,"+
                    EMAIL+" text not null ," +
                    PHONE_NUM+" text not null);"
            Log.i(TAG, "-----> onCreate: $newTableQuery")

            db?.execSQL(newTableQuery)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }

    }

    companion object{
        private const val DB_NAME = "customer_database"
        private const val DB_VERSION = 1
        private const val TABLE_CUSTOMER = "customer_table"
        private const val _ID = "customer_id"
        private const val NAME = "customer_name"
        private const val EMAIL = "customer_email"
        private const val PHONE_NUM = "customer_phone_num"

    }
}