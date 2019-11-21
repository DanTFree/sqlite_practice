package com.example.sqlitepractice

import android.provider.BaseColumns

object UserContract {

    object UserEntry : BaseColumns{
        const val TABLE_NAME = "Users"
        const val COL_NAME = "name"
        const val COL_PHONE = "phone"
        const val COL_ID = "id"
    }
}