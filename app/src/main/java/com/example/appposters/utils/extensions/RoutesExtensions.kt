package com.example.appposters.utils.extensions

import com.example.appposters.utils.routes.Routes

fun Routes.addArguments(vararg args: Any): String {
    var path: String = this.name
    args.forEach {
        path += "/$it"
    }
    print(path)
    return path
}

