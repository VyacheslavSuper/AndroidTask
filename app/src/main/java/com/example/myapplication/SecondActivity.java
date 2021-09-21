package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.models.Currency;
import com.example.myapplication.services.ExchangeServices;

public class SecondActivity extends AppCompatActivity {
    private TextView id;
    private TextView name;
    private TextView code;
    private TextView value;

    private Button exchange;
    private TextView result;
    private EditText textRub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        find();
        updateInfo();
        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Currency curr =  Database.getPreview();
                    double rub = Double.parseDouble(textRub.getText().toString());
                    double exchangeCur = ExchangeServices.exchangeRubToCurrency(curr, rub);
                    result.setText(Double.toString(exchangeCur));
                } catch (RuntimeException e) {
                    Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void find() {
        id = findViewById(R.id.idCur);
        name = findViewById(R.id.nameCur);
        code = findViewById(R.id.codeCur);
        value = findViewById(R.id.valueCur);
        exchange = findViewById(R.id.exchange);

        result = findViewById(R.id.result);
        textRub = findViewById(R.id.editTextNumber);
    }

    private void updateInfo() {
        Currency currency = Database.getPreview();
        id.setText(currency.getId());
        name.setText(currency.getName());
        code.setText(currency.getCharCode());
        value.setText(Float.toString(currency.getValue()));
    }
}