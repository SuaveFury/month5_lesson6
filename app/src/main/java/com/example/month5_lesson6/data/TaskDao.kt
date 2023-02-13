package com.example.month5_lesson6.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface TaskDao {
@Insert
fun insert(task: Task)
@Query("SELECT * FROM task ")
fun get():List<Task>
@Delete
fun delete(task: Task)
}