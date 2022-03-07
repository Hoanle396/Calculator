package com.example.caculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var show:EditText
    lateinit var btn0:Button
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btn4:Button
    lateinit var btn5:Button
    lateinit var btn6:Button
    lateinit var btn7:Button
    lateinit var btn8:Button
    lateinit var btn9:Button
    lateinit var btndot:Button
    lateinit var btnplusmin:Button
    lateinit var btnmul:Button
    lateinit var btndiv:Button
    lateinit var btnsum:Button
    lateinit var btnsub:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        show=findViewById(R.id.editTextTextPersonName)
        btn0=findViewById(R.id.btn0)
        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        btn3=findViewById(R.id.btn3)
        btn4=findViewById(R.id.btn4)
        btn5=findViewById(R.id.btn5)
        btn6=findViewById(R.id.btn6)
        btn7=findViewById(R.id.btn7)
        btn8=findViewById(R.id.btn8)
        btn9=findViewById(R.id.btn9)
        btndot=findViewById(R.id.btndot)
        btnplusmin=findViewById(R.id.btnplusmins)
        btnmul=findViewById(R.id.btnmul)
        btndiv=findViewById(R.id.btndiv)
        btnsum=findViewById(R.id.btnsum)
        btnsub=findViewById(R.id.btnsub)
    }
    fun btnNumber(view:View){
        if(newOp==true){
            show.setText("")
        }
        newOp=false
        var btnselecd= view as Button
        var number:String=show.text.toString()
        when(btnselecd.id){
            btn0.id->{
                number+="0"
            }
            btn1.id->{
                number+="1"
            }
            btn2.id->{
                number+="2"
            }
            btn3.id->{
                number+="3"
            }
            btn4.id->{
                number+="4"
            }
            btn5.id->{
                number+="5"
            }
            btn6.id->{
                number+="6"
            }
            btn7.id->{
                number+="7"
            }
            btn8.id->{
                number+="8"
            }
            btn9.id->{
                number+="9"
            }
            btndot.id->{
                number+="."
            }
            btnplusmin.id->{
                number="-${number}"
            }
        }
        show.setText(number)
    }
    var op =""
    var oldnumber=""
    var newOp=true
    fun btnOption(view: View){
        val btnselecd= view as Button
        when (btnselecd.id){
            btnmul.id->{
                op="*"
            }
            btndiv.id->{
                op="/"
            }
            btnsum.id->{
                op="+"
            }
            btnsub.id->{
                op="-"
            }
        }
        oldnumber=show.text.toString()
        newOp=true
    }
    fun btnEquals(view: View){
        var newnumber=show.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber=oldnumber.toDouble() * newnumber.toDouble()
            }
            "/"->{
                finalNumber=oldnumber.toDouble() / newnumber.toDouble()
            }
            "-"->{
                finalNumber=oldnumber.toDouble() - newnumber.toDouble()
            }
            "+"->{
                finalNumber=oldnumber.toDouble() + newnumber.toDouble()
            }
        }
        show.setText(finalNumber.toString())
    }
    fun btnPercent(view:View){
        val number:Double=show.text.toString().toDouble()/100

        show.setText(number.toString())
        newOp=true

    }
    fun btnClear(view: View){
        show.setText("0")
        newOp=true
    }
}