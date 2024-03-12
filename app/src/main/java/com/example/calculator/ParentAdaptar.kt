package com.example.calculator


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ParentAdaptar : RecyclerView.Adapter<ParentAdaptar.ViewHolder>() {
    var parentList: ArrayList<ParentBody> = arrayListOf()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.findViewById<TextView>(R.id.parentHis)
        val image = itemView.findViewById<ImageView>(R.id.parentImg)
        val childRec = itemView.findViewById<NoScrollRecycleView>(R.id.child_content)
        val constraint = itemView.findViewById<RelativeLayout>(R.id.constraint)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.parent_card, parent, false)
        )
    }

    fun setArrayList(array: ArrayList<ParentBody>) {
        parentList = array
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return parentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentParent = parentList[position]

        holder.text.text = currentParent.text
        holder.childRec.layoutManager = LinearLayoutManager(holder.itemView.context)

        // Use GridLayoutManager for a grid layout if needed
        // holder.childRec.layoutManager = GridLayoutManager(holder.itemView.context, spanCount)

        val childAdapter = ChildAdaptar()
        childAdapter.setArray(currentParent.childItems)
        holder.childRec.adapter = childAdapter

        // Set the height of the child RecyclerView (consider using wrap_content or fixed height)
        // val params = holder.childRec.layoutParams as RecyclerView.LayoutParams
        // params.height = // Set your height here
        // holder.childRec.layoutParams = params

            val isExpandable = currentParent.isExpandable
            if (isExpandable)
            {
                holder.childRec.visibility = View.VISIBLE
                holder.image.setImageResource(R.drawable.baseline_expand_less_24)
            } else
            {
                holder.childRec.visibility = View.GONE
                holder.image.setImageResource(R.drawable.baseline_expand_more_24)
            }


        holder.constraint.setOnClickListener {
            currentParent.isExpandable = !currentParent.isExpandable
            notifyItemChanged(position)
        }
    }
}
