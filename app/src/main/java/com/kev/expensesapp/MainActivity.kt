package com.kev.expensesapp

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kev.expensesapp.Adapters.ExpensesAdpater
import com.kev.expensesapp.Listeners.RecyclerExpensesListener
import com.kev.expensesapp.Models.expensesModel
import com.kev.expensesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private val layoutManager by lazy { LinearLayoutManager(this) }
    private lateinit var dialog_expenses:Dialog
    private lateinit var dialog_presupuesto:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        addData()
        viewBinding.addGasto.setOnClickListener {
            dialog_expenses.show()
        }
        viewBinding.addPresupuesto.setOnClickListener {
            dialog_presupuesto.show()
        }
    }

    private fun addData(){
        dialog_expenses = initDialog(this,R.layout.dialog_agregar_gasto,0.90,0.45,true,true)
        dialog_presupuesto = initDialog(this,R.layout.dialog_add_presupuesto,0.90,0.45,true,true)
        val recyclerView:RecyclerView = viewBinding.recyclerId
        recyclerView.layoutManager = layoutManager
        Log.e("Funcion add data","AddData")
        val data:ArrayList<expensesModel> = ArrayList()
        //limitar a 100 caracteres la descripcion del gasto
        data.add(expensesModel("Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha "," 20", "17/03/2024"))
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


     fun initDialog(
        activity: Activity,
        layout: Int,
        ancho: Double,
        alto: Double,
        cancelable: Boolean,
        transparente: Boolean
    ): Dialog {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(cancelable)
        dialog.setContentView(layout)
        val width = (resources.displayMetrics.widthPixels * ancho).toInt()
        val height = (resources.displayMetrics.heightPixels * alto).toInt()
        dialog.window?.setLayout(width, height)
        if (transparente)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return dialog
    }

}