package com.example.month5_lesson6.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.month5_lesson6.data.Task
import com.example.month5_lesson6.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val dao: TaskDao):ViewModel() {
    val items = MutableLiveData<List<Task>>().apply {
        value = ArrayList()
    }
    val mutableLiveData =MutableLiveData<String>()

    val deletedTAsk=MutableLiveData<Task>()
    fun delete(task: Task){
        dao.delete(task)
    }
    fun getAll(){
        items.value = dao.get()
    }
    fun proofing(task :String){
        if (task.isNotEmpty() &&task.isNotBlank())dao.insert(Task(task = task))
        else mutableLiveData.value = "Currently this item is empty"
    }
}