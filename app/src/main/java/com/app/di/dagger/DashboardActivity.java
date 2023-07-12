package com.app.di.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.di.R;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
}