package com.example.unifiedticketing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class GenerateTicket extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.unifiedticketing.MESSAGE";
    Spinner fromspinner,tospinner;
    String from="",to="",string;
    EditText noptext;
    String nop,fare="75";
    RadioGroup option;
    RadioButton choosen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_ticket);

        fromspinner=findViewById(R.id.spinner_from);
        tospinner=findViewById(R.id.spinner_to);

        noptext=findViewById(R.id.enternoofpass);

        TextView dummy=findViewById(R.id.dummy);

        setupSpinner();
        setupSpinner1();

        dummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option = findViewById(R.id.rg);
                int choosenId = option.getCheckedRadioButtonId();
                choosen = findViewById(choosenId);
                option.setVisibility(View.VISIBLE);
            }
        });
    }

    public void generate(View view){
        nop= noptext.getText().toString();
        int fare1= (Integer.parseInt(nop)*Integer.parseInt(fare));
        fare=Integer.toString(fare1);
        string=from+","+to+","+nop+","+fare+"no";
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
        Intent i=new Intent(GenerateTicket.this,QrGeneration.class);
        i.putExtra(EXTRA_MESSAGE,string);
        startActivity(i);
        finish();
    }

    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout

        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        fromspinner.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        fromspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.from))) {
                        from = "PTC"; // Male
                    } else if (selection.equals(getString(R.string.to))) {
                        from = "LBN" ;// Female
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                from = "PTC"; // Unknown
            }
        });
    }
    private void setupSpinner1() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout

        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        tospinner.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        tospinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.from))) {
                        to = "PTC"; // Male
                    } else if (selection.equals(getString(R.string.to))) {
                        to = "LBN"; // Female
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                to = "LBN"; // Unknown
            }
        });
    }
}
