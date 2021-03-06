package com.example.numbertowords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etnumber;
    private TextView result;
    private Button btnconvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnumber = findViewById(R.id.etnumber);
        result = findViewById(R.id.result);
        btnconvert = findViewById(R.id.btnconvert);

        btnconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty()) {
                    int number = Integer.parseInt(etnumber.getText().toString());
                    Convert c = new Convert();
                    String word = c.conversion(number);
                    result.setText(word);
                }
            }
        });
    }

    public boolean isEmpty() {
        if (TextUtils.isEmpty(etnumber.getText().toString())) {
            etnumber.setError("Please enter number");
            etnumber.requestFocus();
            return true;
        } else {
            return false;
        }
    }
}