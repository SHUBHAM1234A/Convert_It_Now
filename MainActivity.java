package com.example.convertitnow;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//  private TextView textView;
    private Button button;
    private EditText editText;
    private EditText editText2;
    private Spinner spinnr;
    private Spinner spinnr2;
    private Spinner spinnr3;

    String [] q;
    String [] w;
    String [] e;
    String CS = "KG to POUND";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextNumber);
        editText2 = findViewById(R.id.editTextNumber2);
        spinnr = findViewById(R.id.spinner);
        spinnr2 = findViewById(R.id.spinner2);
        spinnr3 = findViewById(R.id.spinner3);



        q = getResources().getStringArray(R.array.Mass);
        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item,q);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnr.setAdapter(a);

        w = getResources().getStringArray(R.array.Data);
        ArrayAdapter b = new ArrayAdapter(this, android.R.layout.simple_spinner_item,w);
        b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnr2.setAdapter(b);

        e = getResources().getStringArray(R.array.All);
        ArrayAdapter c = new ArrayAdapter(this, android.R.layout.simple_spinner_item,e);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnr3.setAdapter(c);

        if (editText.length() >= 10){
            editText.setError("Can't calculate for more than 10 digits");
            Toast.makeText(MainActivity.this, "Can't calculate for more than 10 digits ", Toast.LENGTH_SHORT).show();

        }

        spinnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int e, long id) {
                String state = spinnr.getSelectedItem().toString();
                if(state == "kilogram"){
                    Toast.makeText(MainActivity.this, state, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                String s = editText.getText().toString();
                if (editText.length() < 10) {

                    if (TextUtils.isEmpty(s)) {
                        editText.setError("This Field cannot be empty");
                        Toast.makeText(MainActivity.this, "Please enter any value", Toast.LENGTH_SHORT).show();
                        editText.setText("Error");
                    }

                    if (!TextUtils.isEmpty(s)) {
                        Toast.makeText(MainActivity.this, "Converted! Kilograms to Pounds", Toast.LENGTH_SHORT).show();
                        int kg = Integer.parseInt(s);
                        double pound = kg * 2.205;
                        editText2.setText(pound+"");
                    }
                }
                if (editText.length() >= 10){
                    editText.setError("Can't calculate for more than 10 digits");
                    Toast.makeText(MainActivity.this, "Can't calculate for more than 10 digits ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}