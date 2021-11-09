package com.example.crowcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.MessageFormat;

public class TwoActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);
        // mCount = getIntent().getExtras().getInt("count");
        mTextView.setText(MessageFormat.format("{0}", Store.mCountPull));
    }

    public void onClickButtonPlus(View view) {
        Store.mCountPull++;
        mTextView.setText(MessageFormat.format("{0}", Store.mCountPull));
    }

    public void onClickButtonMinus(View view) {
        Store.mCountPull--;
        mTextView.setText(MessageFormat.format("{0}", Store.mCountPull));
    }


    public void onClickDone(View view) {
        Intent intent = new Intent(TwoActivity.this, OneActivity.class);
        //intent.putExtra("count",mCount);
        startActivity(intent);
    }
}