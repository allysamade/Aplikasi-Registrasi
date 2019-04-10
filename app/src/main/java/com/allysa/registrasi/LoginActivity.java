package com.allysa.registrasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //get Intent
        Intent intent = getIntent();

        Bundle data = intent.getExtras();
        String nama = data.getString("name");
        String email = data.getString("eml");
        String password = data.getString("pswrd");
        String alamat = data.getString("almt");
        String jenisK = data.getString("jeniskelamin");
        String tempat = data.getString("tmpt");
        String tanggal = data.getString("tgl");


        TextView nm = (TextView) findViewById(R.id.labelNama);
        nm.setText(nama);
        TextView eml = (TextView) findViewById(R.id.labelEmail);
        eml.setText(email);
        TextView pswrd = (TextView) findViewById(R.id.lblPassword);
        pswrd.setText(password);
        TextView add = (TextView) findViewById(R.id.labelAlamat);
        add.setText(alamat);
        TextView jk = (TextView) findViewById(R.id.labelJenisKelamin);
        jk.setText(jenisK);
        TextView tmpt = (TextView) findViewById(R.id.labelTempat);
        tmpt.setText(tempat);
        TextView tgl = (TextView) findViewById(R.id.labelTanggal);
        tgl.setText(tanggal);
    }
}
