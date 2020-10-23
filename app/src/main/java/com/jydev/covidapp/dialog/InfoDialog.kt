package com.jydev.covidapp.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.view.View
import android.view.Window
import com.jydev.covidapp.R
import kotlinx.android.synthetic.main.dialog_info.*

class InfoDialog(context: Context , isStatus : String, callback :  () -> Unit) : Dialog(context) {

    init {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setContentView(R.layout.dialog_info)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.setCanceledOnTouchOutside(false)

        info_tv.text = if(isStatus=="temp") "\" 가까운 보건소로 연락주세요\"" else if(isStatus=="rest") " \"집에서 3~4일간 휴식을 취해주세요\"" else " \"이상 없습니다. 안심하셔도 좋습니다.\""
        if(isStatus=="temp") call_1339_btn.visibility = View.VISIBLE
        else ok_btn.visibility = View.VISIBLE

        call_1339_btn.setOnClickListener {
            val activity = context as Activity
            activity.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:1339")))
            dismiss()
            callback()
        }
        ok_btn.setOnClickListener {
            dismiss()
            callback()
        }
    }


}