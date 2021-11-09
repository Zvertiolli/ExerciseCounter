package com.example.crowcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);
       // mCount = getIntent().getExtras().getInt("count");
        mTextView.setText(MessageFormat.format("{0}", Store.mCountPush));
    }

    public void onClickButtonPlus(View view) {
        Store.mCountPush++;
        mTextView.setText(MessageFormat.format("{0}", Store.mCountPush));
    }

    public void onClickButtonMinus(View view) {
        Store.mCountPush--;
        mTextView.setText(MessageFormat.format("{0}", Store.mCountPush));
    }


    public void onClickDone(View view) {
        Intent intent = new Intent(MainActivity.this, OneActivity.class);
        //intent.putExtra("count",mCount);
        startActivity(intent);
    }

    public void onClickSelectExercise(View view) {
        Intent intent = new Intent(MainActivity.this,ChoosingAnExerciseActivity.class);
        startActivity(intent);
    }
}
