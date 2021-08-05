package com.example.bus.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bus.database.schedule.Schedule
import com.example.bus.database.schedule.ScheduleDao
import kotlinx.coroutines.flow.Flow

class ScheduleViewModel(private val scheduleDao: ScheduleDao):ViewModel() {

    fun fullSchedule(): Flow<List<Schedule>> =scheduleDao.getAll()

    fun scheduleByName(name:String):Flow<List<Schedule>> =scheduleDao.getByStopName(name)
}
class ScheduleViewModelFactory(private val scheduleDao: ScheduleDao) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}