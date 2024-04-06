package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.HistoryRV.ChildBody
import com.example.calculator.HistoryRV.ParentAdaptar
import com.example.calculator.HistoryRV.ParentBody
import com.example.calculator.viewmodel.CalculatorViewModel
import com.example.calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var currentNumbers: String
    var isFirstTime = false
    var viewModel = CalculatorViewModel()
    var parentList: ArrayList<ParentBody> = arrayListOf()
    var childList: ArrayList<ChildBody> = arrayListOf()
    val parentBody = ParentBody(childList)
    val adapter = ParentAdaptar()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setButtons()
        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel ::class.java)
        viewModel.result.observe(this){value -> binding.lastProcess.text=value
        if (value=="Infinity") currentNumbers=""}
        binding.parentRecycleView.layoutManager = LinearLayoutManager(this)
        setUpRv()

    }


    fun setButtons() {

       binding.zero.setOnClickListener {
           checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append("0")
            })
           hideHis()
        }

        binding.one.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append("1")
            })
            hideHis()
        }
       binding.two.setOnClickListener {
           checkInf()
            currentNumbers =binding.lastProcess.text.toString()
           binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append("2")
            })
            hideHis()
        }
        binding.three.setOnClickListener {
            checkInf()
            currentNumbers =binding.lastProcess.text.toString()
            binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append("3")
            })
            hideHis()
        }
       binding.four.setOnClickListener {
           checkInf()
            currentNumbers = binding.lastProcess.text.toString()
           binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append("4")
            })
            hideHis()
        }
        binding.five.setOnClickListener {
            checkInf()
            currentNumbers =binding.lastProcess.text.toString()
            binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append("5")
            })
            hideHis()

        }
        binding.six.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text= (buildString {
                append(currentNumbers)
                append("6")
            })
            hideHis()

        }
        binding.seven.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append("7")
            })
            hideHis()

        }
        binding.eight.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append("8")
            })
            hideHis()

        }
        binding.nine.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append("9")
            })
            hideHis()

        }
        binding.multiply.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append(" * ")
            })
            hideHis()

        }
        binding.add.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text= (buildString {
                append(currentNumbers)
                append(" + ")
            })
            hideHis()

        }

        binding.minus.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text = (buildString {
                append(currentNumbers)
                append(" - ")
            })
            hideHis()

        }
        binding.divide.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text= (buildString {
                append(currentNumbers)
                append(" / ")
            })
            hideHis()

        }
        binding.dot.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text= (buildString {
                append(currentNumbers)
                append(".")
            })
            hideHis()

        }
        binding.equal.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            if (currentNumbers != "") {
                if (!(isFirstTime)) {
                    parentList.add(parentBody)
                    setUpRv()
                    isFirstTime = true
                }
                val result = viewModel.getResult(currentNumbers)
                binding.process.text = currentNumbers
                childList.add(ChildBody(currentNumbers + "=" + result))
            }
            hideHis()

        }

        binding.delete.setOnClickListener {
            checkInf()
            currentNumbers = binding.lastProcess.text.toString()
            binding.lastProcess.text = ""
            hideHis()

        } }

    fun setUpRv() {
        binding.parentRecycleView.adapter= adapter
        adapter.setArrayList(parentList)
    }

    fun hideHis(){
        parentBody.isExpandable=false
        setUpRv()
    }
    fun checkInf(){
        if(binding.lastProcess.text=="Infinity") binding.lastProcess.text=""
    }

}