package com.example.send_mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtto;
    private EditText mEtcc;
    private EditText mEtbody;
    private Button mBtnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtto = findViewById(R.id.etto);
        mEtcc = findViewById(R.id.etcc);
        mEtbody = findViewById(R.id.etbody);
        mBtnsend = findViewById(R.id.btnsend);


        mBtnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String body = mEtbody.getText().toString();
                String[] cc =  mEtcc.getText().toString().split(",");
                String[] to = mEtto.getText().toString().split(",");

                Intent send = new Intent(Intent.ACTION_SEND);
                send.setType("text/plain");
                send.putExtra(Intent.EXTRA_EMAIL,to);
                send.putExtra(Intent.EXTRA_CC,cc);
                send.putExtra(Intent.EXTRA_TEXT,body);
                send.setType("message/rfc822");
                startActivity(send);
            }
        });

    }
}