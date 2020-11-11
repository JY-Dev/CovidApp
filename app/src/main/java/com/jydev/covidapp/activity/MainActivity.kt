package com.jydev.covidapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jydev.covidapp.R
import com.jydev.covidapp.network.ApiClient
import com.jydev.covidapp.network.ApiService
import com.jydev.covidapp.network.data.CovidData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_btn.setOnClickListener {
            startActivity(Intent(this, SelfDiagnosisActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        reqData()
    }

    private fun reqData() {
        val cal = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("YYYYMMdd", Locale.KOREA)
        val date = simpleDateFormat.format(cal.time)

        val service = ApiClient.getRetrofit()?.create(ApiService::class.java)
        val call = service?.getData(ApiClient.apiKey, 1, 10, date, date)
        call?.enqueue(object : Callback<CovidData> {
            override fun onFailure(call: Call<CovidData>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<CovidData>,
                response: Response<CovidData>
            ) {
                runOnUiThread {
                    val myFormatter = DecimalFormat("###,###")
                    if (response.body()?.itemList?.size!! > 0)
                        response.body()?.itemList?.get(0)?.apply {
                            totalTv.text = myFormatter.format(decideCnt).toString()
                            careTv.text = myFormatter.format(careCnt).toString()
                            deathTv.text = myFormatter.format(deathCnt).toString()
                            clearTv.text = myFormatter.format(clearCnt).toString()
                        }
                }
            }

        })
    }
}