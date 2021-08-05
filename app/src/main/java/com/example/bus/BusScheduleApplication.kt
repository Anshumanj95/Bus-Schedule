package com.example.bus

import android.app.Application
import com.example.bus.database.AppDatabase

class BusScheduleApplication :Application() {
    val database:AppDatabase by lazy { AppDatabase.getDatabase(this) }

}