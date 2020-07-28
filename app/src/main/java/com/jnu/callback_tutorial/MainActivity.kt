package com.jnu.callback_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG: String = "로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"MainActivity - onCreate() called")
        
        someCallBackMethod(completion = {
                                                                //윗 문장의 it:String 으로 되있기때문에 it 을 호출한다.
            Log.d(TAG,"MainActivity - 컴프레션 블럭 호출됨 / it : $it")

       })


    }
    // 함수 선언해준다.
    fun someCallBackMethod(completion: (String) -> Unit){
        Log.d(TAG,"MainActivity - someCallBackMethod() called")

        //딜레이를 준다.
        Handler().postDelayed({
            //위에 String 으로 정의된 밑의 문장의 데이터를 보낸다.
            completion("하하 끝났다.")
        // 1000L = 1초
        },3000L)

    }



}