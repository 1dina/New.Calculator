package com.example.calculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {
    lateinit var constraintOfHis: ConstraintLayout
    lateinit var recyclerView: RecyclerView
    lateinit var cardView: ConstraintLayout
    lateinit var textFirst: TextView
    lateinit var lastProcess: TextView
    lateinit var currentNumbers: String
    var isFirstTime = false
    val viewModel = CalculatorViewModel()
    var parentList: ArrayList<ParentBody> = arrayListOf()
    var childList: ArrayList<ChildBody> = arrayListOf()
    val parentBody = ParentBody(childList)
    val adapter = ParentAdaptar()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.parent_recycle_view)
        textFirst = findViewById(R.id.last_process)
        lastProcess = findViewById(R.id.process)
        setButtons()
        recyclerView.layoutManager = LinearLayoutManager(this)
        setUpRv()


    }


    fun setButtons() {
        val zero = findViewById<Button>(R.id.zero)
        val one = findViewById<Button>(R.id.one)
        val two = findViewById<Button>(R.id.two)
        val three = findViewById<Button>(R.id.three)
        val four = findViewById<Button>(R.id.four)
        val five = findViewById<Button>(R.id.five)
        val six = findViewById<Button>(R.id.six)
        val seven = findViewById<Button>(R.id.seven)
        val eight = findViewById<Button>(R.id.eight)
        val nine = findViewById<Button>(R.id.nine)
        val delete = findViewById<Button>(R.id.delete)
        val add = findViewById<Button>(R.id.add)
        val minus = findViewById<Button>(R.id.minus)
        val multiply = findViewById<Button>(R.id.multiply)
        val divide = findViewById<Button>(R.id.divide)
        val dot = findViewById<Button>(R.id.dot)
        val equal = findViewById<Button>(R.id.equal)
        zero.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append("0")
            })
           hideHis()
        }
        one.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append("1")
            })
            hideHis()
        }
        two.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append("2")
            })
            hideHis()
        }
        three.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append("3")
            })
            hideHis()
        }
        four.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append("4")
            })
            hideHis()
        }
        five.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append("5")
            })
            hideHis()

        }
        six.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append("6")
            })
            hideHis()

        }
        seven.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append("7")
            })
            hideHis()

        }
        eight.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append("8")
            })
            hideHis()

        }
        nine.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append("9")
            })
            hideHis()

        }
        multiply.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append(" * ")
            })
            hideHis()

        }
        add.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append(" + ")
            })
            hideHis()

        }

        minus.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append(" - ")
            })
            hideHis()

        }
        divide.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append(" / ")
            })
            hideHis()

        }
        dot.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = (buildString {
                append(currentNumbers)
                append(".")
            })
            hideHis()

        }
        equal.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            if (currentNumbers != "") {
                if (!(isFirstTime)) {
                    parentList.add(parentBody)
                    setUpRv()
                    isFirstTime = true
                }
                val result = viewModel.getResult(currentNumbers)
                lastProcess.text = currentNumbers
                childList.add(ChildBody(currentNumbers + "=" + result))
                textFirst.text = viewModel.result
            }
            hideHis()

        }

        delete.setOnClickListener {
            currentNumbers = textFirst.text.toString()
            textFirst.text = ""
            hideHis()

        }



    }


    fun setUpRv() {
        recyclerView.adapter = adapter
        adapter.setArrayList(parentList)
    }

    fun hideHis(){
        parentBody.isExpandable=false
        setUpRv()
    }

}