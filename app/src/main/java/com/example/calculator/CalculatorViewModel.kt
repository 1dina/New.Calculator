package com.example.calculator

import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable


class CalculatorViewModel : ViewModel() {
    var text : String = ""
    var result : String =""


        fun getResult(data: String): String {
            try{
            val context: Context = Context.enter()
            context.optimizationLevel = -1
            val scriptable: Scriptable = context.initStandardObjects()
            val finalResult = context.evaluateString(
                scriptable,
                data, "JavaScript", 1, null
            ).toString()

           result=finalResult
            return finalResult

    } catch (e:Exception){
        return "Err"
    } }

}