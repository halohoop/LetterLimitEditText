package com.halohoop.letterlimitedittext_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.halohoop.letterlimitedittext.LetterLimitEditText;

public class MainActivity extends AppCompatActivity {

    private LetterLimitEditText letterlimitet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        letterlimitet = (LetterLimitEditText) findViewById(R.id.letterlimitet);
    }
}
