package com.example.createqr.model

data class QRITemRecycleView(
    var type: TypeQR,
    var image: Int
)

enum class TypeQR {
    PHONE,
    EMAIL,
    URL,
    SMS,
    CONTACT,
    TEXT,
    WIFI,
    CALENDER,
    LOCATION,
    CODE39,
    CODE93

}

