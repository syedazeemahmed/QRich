package com.trifecta.team.qrich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

public class BarcodeAvtivity extends AppCompatActivity {

    TextView txtBarcode;
    Button btnSendSms,btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_avtivity);

        btnSendSms = (Button)findViewById(R.id.btnSendSms);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        txtBarcode = (TextView)findViewById(R.id.txtBarcode);
        Barcode barcode = getIntent().getParcelableExtra("barcode");
        txtBarcode.setText(barcode.displayValue);

        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BarcodeAvtivity.this, "SMS send successfully!",
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(BarcodeAvtivity.this,SmsCodeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
