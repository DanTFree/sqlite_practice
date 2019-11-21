package com.example.sqlitepractice

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


class DatabaseHandler( var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val table = "CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_NAME TEXT," +
                "$COL_PHONE VARCHAR(15))"
        db.execSQL(table)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        val deleteTable = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(deleteTable)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    fun insertData(user: User){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME,user.name)
        cv.put(COL_PHONE,user.name)
        var result = db.insert(TABLE_NAME,null,cv)

    }

    companion object {

        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "MyDB"
        const val TABLE_NAME = "Users"
        const val COL_NAME = "name"
        const val COL_PHONE = "phone"
        const val COL_ID = "id"

    }
}