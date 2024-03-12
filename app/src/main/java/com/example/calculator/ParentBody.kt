package com.example.calculator

import android.widget.ImageView

data class ParentBody (var childItems : ArrayList<ChildBody>,
    var isExpandable : Boolean = false ,val text: String = "History")