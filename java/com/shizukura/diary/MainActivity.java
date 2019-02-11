package com.shizukura.diary;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public SharedPreferences db;
    public SharedPreferences.Editor dbEdit;
    Button submitName;
    //ImageView imago;
    //TransitionDrawable asd;
    EditText textName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = getSharedPreferences("DB", 0);
        name = db.getString("name","");
        if(name == ""){

            overridePendingTransition(R.anim.fade, R.anim.fade_out);
            setContentView(R.layout.name_layout);
            //imago = findViewById(R.id.imageView2);
            //asd = (TransitionDrawable)imago.getDrawable();
            //asd.startTransition(1200);
            submitName = findViewById(R.id.submit_name);
            textName = findViewById(R.id.editText);
            submitName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name = textName.getText().toString();
                    dbEdit = getSharedPreferences("DB", 0).edit();
                    dbEdit.putString("name", name);
                    dbEdit.apply();
                    overridePendingTransition(R.anim.fade, R.anim.fade_out);
                    setContentView(R.layout.activity_main);
                }
            });
        }
        else{
            overridePendingTransition(R.anim.fade, R.anim.fade_out);
            setContentView(R.layout.activity_main);
        }
        //        Don't forget to use this Steven hahaha or you'll mess up
        //
        //        dbEdit = getSharedPreferences("DB", 0).edit();
        //        dbEdit.apply();


    }
}
