package com.example.crowcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.MessageFormat;

public class OneActivity extends AppCompatActivity {

    private TextView mTextViewCounterOtj;
    private TextView mTextViewCounterPod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        mTextViewCounterOtj = findViewById(R.id.textViewCounterOtj);
        mTextViewCounterPod = findViewById(R.id.textViewCounterPod);
        //mCount = getIntent().getExtras().getInt("count");
        mTextViewCounterOtj.setText(MessageFormat.format("{0}", Store.mCountPush));
        mTextViewCounterPod.setText(MessageFormat.format("{0}", Store.mCountPull));


    }

    public void onClickOtjimaniya(View view) {
        Intent intent = new Intent(OneActivity.this,MainActivity.class);
        //intent.putExtra("count",mCount);
        startActivity(intent);
    }

    public void onClickPodtyagivania(View view) {
        Intent intent = new Intent(OneActivity.this,TwoActivity.class);
        startActivity(intent);
    }
}