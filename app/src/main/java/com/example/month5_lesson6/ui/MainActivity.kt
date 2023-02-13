package com.example.month5_lesson6.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.month5_lesson6.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel :ViewModel  by viewModels()
   private lateinit var binding: ActivityMainBinding
    @Inject lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        initModel()
        logicButtons()
    }
    private fun logicButtons() {
        binding.btn.setOnClickListener {
            viewModel.proofing(binding.generalEdit.text.toString())
        }
        binding.mainContainer.setOnRefreshListener {
            viewModel.getAll()
        }
    }
    private fun initModel() {
        viewModel.items.observe(this){
            adapter.updateArray(it)
            binding.mainContainer.isRefreshing = false

        }
        viewModel.mutableLiveData.observe(this){
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        }
        viewModel.deletedTAsk.observe(this){
            viewModel.delete(it)
        }
    }
    private fun init() {
        viewModel.getAll()
        binding.rv.adapter = adapter

    }
}