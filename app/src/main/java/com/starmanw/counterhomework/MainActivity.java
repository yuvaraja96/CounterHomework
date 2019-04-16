package com.starmanw.counterhomework;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCount;
    private TextView txtCount;
    private EditText editText;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        initUI();
        if (savedInstanceState != null) {
            restoreUI(savedInstanceState);
        }
        txtCount.setText(String.format(getString(R.string.counterTxt), counter));
    }

    private void initUI() {
        btnCount = findViewById(R.id.btnCounter);
        txtCount = findViewById(R.id.txtViewCounter);
        editText = findViewById(R.id.editText);
    }

    private void restoreUI(Bundle savedInstanceState) {
        this.counter = savedInstanceState.getInt("count");
        Log.i("COUNTER AFTER", String.valueOf(counter));
        txtCount.setText(String.format(getString(R.string.counterTxt), counter));
        txtCount.setText(savedInstanceState.getString("text"));
    }

    public void incrementCounter(View view) {
        counter++;
        txtCount.setText(String.format(getString(R.string.counterTxt), counter));
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.i("COUNTER BEFORE", String.valueOf(counter));
        outState.putString("text", editText.getText().toString());
        outState.putInt("count", counter);
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
