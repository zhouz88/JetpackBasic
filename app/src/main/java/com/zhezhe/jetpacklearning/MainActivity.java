package com.zhezhe.jetpacklearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhezhe.jetpacklearning.ui.main.CustomViewModel;
import com.zhezhe.jetpacklearning.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomViewModel viewModel;

    private TextView tx1;
    private TextView tx2;
    private Button btn1;
    private Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
        viewModel = new ViewModelProvider(this).get(CustomViewModel.class);
        tx1 = findViewById(R.id.tv1);
        tx2 = findViewById(R.id.tv2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        tx1.setText(String.valueOf(viewModel.getTicketCxt()));
        tx2.setText(String.valueOf(viewModel.getTicketJay()));

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                viewModel.setTicketCxt(viewModel.getTicketCxt() + 1);
                tx1.setText(String.valueOf(viewModel.getTicketCxt()));
                break;
            case R.id.btn2:
                viewModel.setTicketJay(viewModel.getTicketJay() + 1);
                tx2.setText(String.valueOf(viewModel.getTicketJay()));
                break;
        }
    }
}