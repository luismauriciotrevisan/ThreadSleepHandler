package com.example.threadsleephandler;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/*
Based on Lecheta, Google Android, CAP 13 - Hanlders, Threads and AsyncTAsk.
This example is in 13.9 "Não utilize Thread.sleep"
 */

public class MainActivity extends AppCompatActivity implements Runnable {
    private static final String CATEGORIA = "Lecheta, Thread Sleep";
    private int count;
    private TextView text;
    private Handler handler;
    private boolean on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = new TextView(this);
        setContentView(text);
        handler = new Handler();
        handler.post(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        on = true;
        Log.i(CATEGORIA, "onStart()");
    }

    public void run(){
        if(on){
            count++;
            Log.i(CATEGORIA, "Handler.run() count: " + count);
            text.setText("Contador: " + count);
            //Repetir depois de 1s
            handler.postDelayed(this, 1000);
        }else{
            Log.i(CATEGORIA, "Handler fim");
        }

    }

    public void onDestroy(){
        super.onDestroy();
        //Encerrar as mensagens do handler
        Log.i(CATEGORIA, "onDestroy()");
        on = false;
    }
}
