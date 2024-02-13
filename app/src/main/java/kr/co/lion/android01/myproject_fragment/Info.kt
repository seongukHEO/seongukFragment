package kr.co.lion.android01.myproject_fragment

import android.content.Context
import android.content.DialogInterface
import android.os.SystemClock
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.concurrent.thread

class Info {
    var name = ""
    var age = 0
    var kor = 0
    var eng = 0
    var math = 0

    companion object{
        // 포커스를 주고 키보드를 올려주는 메서드
        //키보드를 올린다
        var infoList = mutableListOf<Info>()
        fun showSoftInput(view: View, context: Context){
            // 포커스를 준다.
            view.requestFocus()

            thread {
                SystemClock.sleep(1000)
                val inputMethodManager = context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.showSoftInput(view, 0)
            }
        }

        //키보드를 내려준다
        fun hideSoftInput(activity: AppCompatActivity){
            //현재 포커스를 가지고있는 뷰가 있다면 키보드를 내린다
            if(activity.window.currentFocus != null){
                val inputMethodManager = activity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(activity.window.currentFocus?.windowToken, 0);
            }
        }
        fun showDiaLog(context: Context, title:String, message:String, listener:(DialogInterface, Int) -> Unit){
            var diaLog = MaterialAlertDialogBuilder(context)
            diaLog.setTitle(title)
            diaLog.setMessage(message)
            diaLog.setPositiveButton("확인", listener)
            diaLog.show()
        }
    }
}