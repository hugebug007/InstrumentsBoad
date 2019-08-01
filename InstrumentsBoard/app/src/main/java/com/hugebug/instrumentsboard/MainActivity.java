package com.hugebug.instrumentsboard;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.hugebug.instrumentsboard_library.InstrumentsBoard;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MainActivity extends AppCompatActivity {


    private InstrumentsBoard instrumentsBoard;
    private float value = 0;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1)
                instrumentsBoard.setTestValue(value);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        instrumentsBoard = findViewById(R.id.instrumentsboard);
        final List<Float> speeds = new ArrayList<Float>();
//        speeds.add(25f);
//        speeds.add(44f);
//        speeds.add(60f);
//        speeds.add(120f);
//        speeds.add(130f);
//        speeds.add(150f);
        speeds.add(180f);


        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (i < speeds.size()) {
                    value = speeds.get(i);
                    i++;
                    Message msg = Message.obtain();
                    msg.what = 1;
                    handler.sendMessage(msg);
                    if(i== speeds.size()-1)
                        i=0;
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }.start();


    }
}
