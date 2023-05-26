package com.example.daggersample.model

class Photo(
    val urls: Urls? = Urls()
)
class Urls(val regular: String? = "")
