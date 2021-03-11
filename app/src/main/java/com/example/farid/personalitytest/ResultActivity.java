package com.example.farid.personalitytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.setTitle("Personality test");

        textView = findViewById(R.id.textViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String string = bundle.getString("tag");
            textView.setText(string);
        }

    }
}
