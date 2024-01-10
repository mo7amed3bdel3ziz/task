package com.example.androidtask.business.models

data class AddressesModel(
    var id        : Int   ,
    var lat       : String,
    var lng       : String,
    var address   : String,
    var street    : String,
    var building  : String,
    var apartment : String,
    var floor     : String,
    var name      : String
)
