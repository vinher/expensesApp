package com.kev.expensesapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kev.expensesapp.Listeners.RecyclerExpensesListener
import com.kev.expensesapp.Models.expensesModel
import com.kev.expensesapp.R

class ExpensesAdpater(
    private val expense: List<expensesModel>,
    private val listener:RecyclerExpensesListener
):RecyclerView.Adapter<ExpensesAdpater.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_gasto,parent,false)
    )




    override fun getItemCount()= expense.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =  holder.bind(expense[position],listener)



    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
            fun bind(item:expensesModel,listener: RecyclerExpensesListener) = with(itemView){
                itemView.findViewWithTag<TextView>("description").text = item.gasto
                itemView.setOnClickListener { listener.onClick(item,adapterPosition) }
            }
        }
    }