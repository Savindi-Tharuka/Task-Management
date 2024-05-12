package com.example.mytask


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var db:TaskDatabase
    private lateinit var taskAdapter:TaskAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        db = TaskDatabase(this)
        taskAdapter = TaskAdapter(db.getAllTasks(), this)

        binding.taskView.layoutManager= LinearLayoutManager(this)
        binding.taskView.adapter = taskAdapter

        binding.Button1.setOnClickListener{
            val intent= Intent(this,AddTaskActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        taskAdapter.refreshData(db.getAllTasks())
    }
}