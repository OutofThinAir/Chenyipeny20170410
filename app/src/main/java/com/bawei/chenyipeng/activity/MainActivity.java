package com.bawei.chenyipeng.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bawei.chenyipeng.R;
import com.bawei.chenyipeng.view.MyView;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    private int mix=0;
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView) findViewById(R.id.main_myview);
        Button button = (Button) findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                           mix++;
                            myView.setJindu(mix);
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (mix == 100) {
                                break;
                            }

                        }
                    }


                }).start();

            }
        });
    }
}
