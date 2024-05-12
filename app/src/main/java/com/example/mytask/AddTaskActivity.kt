package com.example.mytask

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mytask.databinding.ActivityAddTaskBinding
import com.example.mytask.databinding.ActivityAddTaskBinding.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddTaskBinding
    private lateinit var db:TaskDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      binding = inflate(layoutInflater)

        setContentView(binding.root)

        db=TaskDatabase(this)

        binding.button2.setOnClickListener{
            val title=binding.titleEditText.text.toString()
            val content=binding.contentEditText.text.toString()
            val task=Task(0,title,content)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task Saved", Toast.LENGTH_SHORT).show()

        }
    }
}