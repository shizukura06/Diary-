package com.shizukura.diary;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Loading extends AppCompatActivity {


    ImageView imago;
    TransitionDrawable asd;

    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg){
            if(msg.what == 1){
                asd.reverseTransition(3000);
                mHandler.sendEmptyMessageDelayed(2, 3300);
            }
            if(msg.what == 2){
                Intent intent = new Intent(Loading.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading);
        imago = findViewById(R.id.imageView);
        asd = (TransitionDrawable)imago.getDrawable();
        mHandler.sendEmptyMessageDelayed(1, 4000);
        asd.startTransition(1200);

    }
    @Override
    public void onBackPressed(){

    }
}
