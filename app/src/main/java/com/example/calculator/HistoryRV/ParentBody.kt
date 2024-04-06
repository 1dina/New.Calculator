package com.example.calculator.HistoryRV

import com.example.calculator.HistoryRV.ChildBody

data class ParentBody (var childItems : ArrayList<ChildBody>,
                       var isExpandable : Boolean = false, val text: String = "History")