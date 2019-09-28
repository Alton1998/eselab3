package com.example.alton.eselab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView t,t2;
    EditText e1,e2,e3,e4;
    Button b1;
    ArrayList<String> items;
    ArrayList<Integer> price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView) findViewById(R.id.textView2);
        t2=(TextView) findViewById(R.id.textView3);
        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText) findViewById(R.id.editText2);
        e3=(EditText) findViewById(R.id.editText3);
        e4=(EditText) findViewById(R.id.editText4);
        b1=(Button) findViewById(R.id.button);
        items=new ArrayList<String>();
        price=new ArrayList<Integer>();
        items.add("Rice");
        items.add("Toor Dall");
        items.add("wheat");
        items.add("Oil");
        price.add(52);
        price.add(78);
        price.add(32);
        price.add(92);
        StringBuffer s=new StringBuffer();
        s.append("Items\tPrice\n");
        for(int i=0;i<items.size();i++)
        {
            s.append(items.get(i)+"\t"+price.get(i)+"\n");
        }
        t.setText(s);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String number=e2.getText().toString();
                String grocery_type=e3.getText().toString();
                String qty_string=e4.getText().toString();
                int qty=Integer.parseInt(qty_string);
                int priceofitem=0;
                double total;
                int flag=0;
                for(int i=0;i<items.size();i++)
                {
                    if(grocery_type.equalsIgnoreCase(items.get(i)))
                    {
                        priceofitem=price.get(i);
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    t2.setText("No such item available");
                }
                if(flag==1)
                {
                    total=qty*priceofitem;
                    total=total+0.2*total;
                    Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                    i.putExtra("name",name+"");
                    i.putExtra("number",number+"");
                    i.putExtra("Bill",total+"");
                    startActivity(i);
                }
            }
        });

    }
}
