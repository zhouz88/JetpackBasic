package com.zhezhe.jetpacklearning.livedata;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.zhezhe.jetpacklearning.R;
import com.zhezhe.jetpacklearning.databinding.MainActivityBinding;

public class LiveDataActivity extends AppCompatActivity implements View.OnClickListener {
    private LiveDataViewModel viewModel;
    private MainActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        viewModel = new ViewModelProvider(this).get(LiveDataViewModel.class);
        binding.setData(viewModel);
        binding.setLifecycleOwner(this);
        binding.btn1.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
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