package com.kev.expensesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kev.expensesapp.Adapters.ExpensesAdpater
import com.kev.expensesapp.Listeners.RecyclerExpensesListener
import com.kev.expensesapp.Models.expensesModel
import com.kev.expensesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private val layoutManager by lazy { LinearLayoutManager(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        addData()
    }

    private fun addData(){

        val recyclerView:RecyclerView = viewBinding.recyclerId
        recyclerView.layoutManager = layoutManager
        Log.e("Funcion add data","AddData")
        val data:ArrayList<expensesModel> = ArrayList()
        data.add(expensesModel("gasto 1"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 2"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 3"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 4"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 5"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 6"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 7"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 8"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 9"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 10"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 11"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 12"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 13"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 14"," 20", "17/03/2024"))
        data.add(expensesModel("gasto 15"," 20", "17/03/2024"))

        Log.e("Funcion add data",data.toString())
        val costumerAdapter = ExpensesAdpater(data, object : RecyclerExpensesListener {
            override fun onClick(item: expensesModel, position: Int) {
                Log.e("puchado","Puchado")
            }

        })
        Log.e("Funcion add data",costumerAdapter.itemCount.toString())
        recyclerView.adapter = costumerAdapter

    }
}