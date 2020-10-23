package com.jydev.covidapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import com.jydev.covidapp.R
import com.jydev.covidapp.dialog.InfoDialog
import kotlinx.android.synthetic.main.activity_self_diagnosis.*

class SelfDiagnosisActivity : AppCompatActivity() {
    var one = -1
    var two = -1
    var three = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_self_diagnosis)
        rg_01.setOnCheckedChangeListener(onCheckedChangeListener)
        rg_02.setOnCheckedChangeListener(onCheckedChangeListener)
        rg_03.setOnCheckedChangeListener(onCheckedChangeListener)

        start_btn.setOnClickListener {
            if (temp_et.text.isEmpty()) {
                Toast.makeText(this, "체온을 입력 해주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (one == -1 || two == -1 || three == -1) {
                Toast.makeText(this, "모든 사항을 체크 해주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (temp_et.text.toString().toDouble() >= 37.5)
                InfoDialog(this, "temp") {
                    finish()
                }.show()
            else if (one == 1 || two == 1 || three == 1)
                InfoDialog(this, "rest") {
                    finish()
                }.show()
            else
                InfoDialog(this, "") {
                    finish()
                }.show()

        }
    }

    private val onCheckedChangeListener = RadioGroup.OnCheckedChangeListener { rg, id ->
        when (rg.id) {
            R.id.rg_01 -> one = getRdIndex(id)
            R.id.rg_02 -> two = getRdIndex(id)
            R.id.rg_03 -> three = getRdIndex(id)
        }
    }

    private fun getRdIndex(id: Int): Int {
        return when (id) {
            R.id.rd_01_no, R.id.rd_02_no, R.id.rd_03_no -> 0
            R.id.rd_01, R.id.rd_02, R.id.rd_03 -> 1
            else -> 0
        }
    }

}