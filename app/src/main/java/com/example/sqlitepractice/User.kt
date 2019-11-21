package com.example.sqlitepractice

class User {

    var id: Int = 0
    var name: String = ""
    var phone: String = ""

    constructor(name:String, phone:String){
        this.name = name
        this.phone = phone
    }

    fun formatStr(): String{
        return "$id $name $phone"
    }
}