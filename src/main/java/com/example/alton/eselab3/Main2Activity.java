package com.example.alton.eselab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e=(TextView) findViewById(R.id.textView4) ;
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String bill=extras.getString("Bill");
        Log.i("Name:",name+"");
        e.setText(name+""+bill);
    }
}
