package com.allysa.registrasi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText nm,eml,pswrd,add,tmpt,tgl;
    private String nama,email,password,alamat,tempat,tanggal,jk;
    private RadioGroup radioGroupJK;
    private RadioButton radioButtonJK;

    private DatePicker datePicker;
    private Calendar calendar;
    private EditText dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateView = (EditText) findViewById(R.id.textTangal);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }




    public void sendExtrasBundle(View v){
        nm = (EditText) findViewById(R.id.textNamaLengkap);
        nama = nm.getText().toString();

        eml = (EditText) findViewById(R.id.textEmail);
        email = eml.getText().toString();

        pswrd = (EditText) findViewById(R.id.textPassword);
        password = pswrd.getText().toString();

        add = (EditText) findViewById(R.id.textAlamat);
        alamat = add.getText().toString();

        tmpt = (EditText) findViewById(R.id.textTempat);
        tempat = tmpt.getText().toString();

        tgl = (EditText) findViewById(R.id.textTangal);
        tanggal = tgl.getText().toString();

        //RadioGroup
        radioGroupJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        radioButtonJK = (RadioButton) findViewById(radioGroupJK.getCheckedRadioButtonId());
         jk = radioButtonJK.getText().toString();

        //create object intent
        Intent intent = new Intent(this, LoginActivity.class);

        //create bundle
        Bundle data = new Bundle();
        data.putString("name", nama);
        data.putString("eml", email);
        data.putString("pswrd", password);
        data.putString("almt", alamat);
        data.putString("tmpt", tempat);
        data.putString("tgl", tanggal);
        data.putString("jeniskelamin", jk);


        //put extras
        intent.putExtras(data);

        //start activity
        startActivity(intent);
    }
}
