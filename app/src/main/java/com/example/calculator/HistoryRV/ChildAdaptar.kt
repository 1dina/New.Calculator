package com.example.calculator.HistoryRV


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.R

class ChildAdaptar : RecyclerView.Adapter<ChildAdaptar.ViewHolder>() {
    var childList : ArrayList<ChildBody> = arrayListOf()
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.findViewById<TextView>(R.id.card_text)
        val card = itemView.findViewById<CardView>(R.id.child_card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.child_card,parent,false))

    }


    fun setArray(array: ArrayList<ChildBody>){
        childList = array
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return childList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.setText(childList.get(position).text)
        if(position%2==0){
            holder.card.setBackgroundResource(R.color.grey)
        }


    }

}