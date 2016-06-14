package com.example.kristian.activityhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {
    EditText txt_years;
    EditText txt_adress;
    EditText txt_city;
    EditText txt_date;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);
        txt_years = (EditText) findViewById(R.id.txt_years);
        txt_adress = (EditText) findViewById(R.id.txt_adress);
        txt_city = (EditText) findViewById(R.id.txt_city);
        txt_date = (EditText) findViewById(R.id.txt_date);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getIntent().getStringExtra("name");
                String sYears = txt_years.getText().toString();
                String sAdress = txt_adress.getText().toString();
                String sCity = txt_city.getText().toString();
                String sDate = txt_date.getText().toString();
                if (sYears.matches("")) {
                    txt_years.setError("Wrong information");
                } else if (sAdress.matches("")) {
                    txt_adress.setError("Wrong information");
                } else if (sCity.matches("")) {
                    txt_city.setError("Wrong information");
                } else if (sDate.matches("")) {
                    txt_date.setError("Wrong information");
                } else {
                    Intent intent = new Intent(DetailsActivity.this, SummaryActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("years", txt_years.getText().toString());
                    intent.putExtra("adress", txt_adress.getText().toString());
                    intent.putExtra("city", txt_city.getText().toString());
                    intent.putExtra("date", txt_date.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
