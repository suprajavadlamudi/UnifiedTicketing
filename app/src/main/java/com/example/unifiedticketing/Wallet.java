package com.example.unifiedticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Wallet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        TextView textView = (TextView) findViewById(R.id.balanceText);

        float balance = 0;

        //retrieve balance from server

        textView.setText(Float.toString(balance));
    }

    public void addMoney(View view) {
        EditText editText = (EditText) findViewById(R.id.enteramount);
        TextView textView = (TextView) findViewById(R.id.balanceText);

        try {
            float amount = Float.parseFloat(editText.getText().toString());

            if(amount <= 0) {
                Toast.makeText(getApplicationContext(), "Enter positive amount",
                        Toast.LENGTH_LONG).show();
            } else {
                float currentBalance = Float.parseFloat(textView.getText().toString());
                textView.setText(Float.toString(currentBalance + amount));

                //update balance in server

            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Enter valid amount",
                    Toast.LENGTH_LONG).show();
        }
    }
}
