package com.example.calculatorapp.Utils;

import static android.app.ProgressDialog.show;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class AllMessages {

    public static void Toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
//        Handler handler = new Handler(Looper.getMainLooper());
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showToast(context,message, Toast.LENGTH_SHORT);
//            }
//        }, 1000);
    }

//    private static void showToast(Context context,String message, int lengthShort) {
//        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
//    }
}




