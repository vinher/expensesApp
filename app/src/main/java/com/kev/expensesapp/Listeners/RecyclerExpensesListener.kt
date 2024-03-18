package com.kev.expensesapp.Listeners

import com.kev.expensesapp.Models.expensesModel

interface RecyclerExpensesListener {
    fun onClick(item:expensesModel,position: Int)
}
