package com.loc.mypexelapp.domain

import android.content.Context

interface NetworkProvider {
    fun isNetworkAvailable(): Boolean
}