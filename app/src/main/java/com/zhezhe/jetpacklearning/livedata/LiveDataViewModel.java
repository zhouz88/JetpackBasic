package com.zhezhe.jetpacklearning.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiveDataViewModel extends ViewModel {
    private MutableLiveData<Integer> data1, data2;

    @Builder
    public LiveDataViewModel() {
        data1 = new MutableLiveData<>();
        data1.setValue(0);
        data2 = new MutableLiveData<>();
        data2.setValue(0);
    }

    public void addData1() {
        this.data1.setValue(this.data1.getValue() + 1);
    }

    public void addData2() {
        this.data2.setValue(this.data2.getValue() + 1);
    }
}
