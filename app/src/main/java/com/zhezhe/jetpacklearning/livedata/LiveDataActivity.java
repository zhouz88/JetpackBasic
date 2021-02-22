package com.zhezhe.jetpacklearning.livedata;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.zhezhe.jetpacklearning.R;

public class LiveDataActivity extends AppCompatActivity implements View.OnClickListener {
    private LiveDataViewModel viewModel;

    private TextView tx1;
    private TextView tx2;
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        viewModel = new ViewModelProvider(this).get(LiveDataViewModel.class);
        tx1 = findViewById(R.id.tv1);
        tx2 = findViewById(R.id.tv2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        viewModel.getData1().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.e("ThreadThread1 ", String.valueOf(Looper.getMainLooper().isCurrentThread()));
                // result is main
                tx1.setText(String.valueOf(viewModel.getData1().getValue()));
            }
        });

        viewModel.getData2().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.e("ThreadThread2 ", Thread.currentThread().getName().toString());
                tx2.setText(String.valueOf(viewModel.getData2().getValue()));
            }
        });
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                viewModel.addData1();
                break;
            case R.id.btn2:
                viewModel.addData2();
                break;
        }
    }
}