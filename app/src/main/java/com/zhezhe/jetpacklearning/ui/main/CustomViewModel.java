package com.zhezhe.jetpacklearning.ui.main;

import androidx.lifecycle.ViewModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomViewModel extends ViewModel {
    private int ticketCxt = 0;
    private int ticketJay = 0;
}