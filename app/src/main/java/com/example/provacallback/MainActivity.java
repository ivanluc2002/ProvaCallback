package com.example.provacallback;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button call;
private MyClass myClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call=findViewById(R.id.call);
        myClass=new MyClass();
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClass.aspetta(new MyClass.MyInterface() {
                    @Override
                    public void finish(String risultato) {
                        Log.d("finish", "finish: "+risultato);
                    }

                    @Override
                    public void crash(String errore) {
                        Log.d("crash", "crash: "+errore);
                    }
                });
            }
        });
    }

}