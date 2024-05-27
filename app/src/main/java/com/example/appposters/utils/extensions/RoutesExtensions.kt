package com.example.appposters.utils.extensions

import com.example.appposters.utils.routes.Routes
import com.google.gson.Gson

fun Routes.setParams(vararg args: Any): String {
    var path: String = this.name
    args.forEach {
        path += "/$it"
    }
    print(path)
    return path
}

fun <C> Routes.addClassArguments(args: C): String {
    val path = "${this.name}/${Gson().toJson(args)}"
    return path;
}