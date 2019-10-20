package com.example.unifiedticketing;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        String activeuser = intent.getStringExtra(Login.EXTRA_MESSAGE);

        final CardView generateticketcard = (CardView) findViewById(R.id.generateticketcard);
        final CardView myticketscard = (CardView) findViewById(R.id.myticketscard);
        final CardView applypasscard = (CardView) findViewById(R.id.applypasscard);
        final CardView renewpasscard = (CardView) findViewById(R.id.renewpasscard);
        final CardView mypasscard=(CardView) findViewById(R.id.passcard);
        final CardView walletcard=(CardView) findViewById(R.id.walletcard);

        generateticketcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,GenerateTicket.class);
                startActivity(i);
            }
        });

        myticketscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,TicketHistory.class);
                startActivity(i);
            }
        });

        applypasscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ApplyPass.class);
                startActivity(i);
            }
        });

        renewpasscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,RenewPass.class);
                startActivity(i);
            }
        });

        mypasscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MyPass.class);
                startActivity(i);
            }
        });

        walletcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Wallet.class);
                startActivity(i);
            }
        });
    }
}
