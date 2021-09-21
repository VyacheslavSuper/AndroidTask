package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.models.Currency;
import com.example.myapplication.services.InfoService;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private Button update;
    public static Adapter adapter;
    private static final Timer timerUi = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv = findViewById(R.id.lv);
        update = findViewById(R.id.btn_update);
        adapter = new Adapter(getApplicationContext());
        init();
    }

    private void init() {
        lv.setAdapter(adapter);
        Intent intent = new Intent(this, SecondActivity.class);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Currency curr = Database.getList().get(i);
                Database.setPreview(curr.getCharCode());
                startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });
        timerUi.schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, Properties.DELAY_UPDATE);
    }

    private void update() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Database.update(InfoService.infoFromSite());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();

    }
}
