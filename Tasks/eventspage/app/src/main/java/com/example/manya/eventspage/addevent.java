package com.example.manya.eventspage;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class addevent extends AppCompatActivity {DateFormat formatdatetime=new SimpleDateFormat("dd MM yyyy, HH:mm");
    Calendar datetime=Calendar.getInstance();
    private TextView text;
    private TextView text2;
    private Button buttondate;
    private Button buttontime;
    private Button buttoninfo;
    private Button buttonaddevent;
    private EditText tex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);
        text = (TextView) findViewById(R.id.textView);
        buttondate = (Button) findViewById(R.id.button);
        buttontime = (Button) findViewById(R.id.button2);
buttoninfo=(Button)findViewById(R.id.button6) ;
        tex=(EditText)findViewById(R.id.editText);
        text2=(TextView)findViewById(R.id.textView2);
        buttonaddevent=(Button)findViewById(R.id.button3);
        text.setText("");
        buttonaddevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=text.getText().toString();
                data=data+" \n Event detail: "+ text2.getText().toString();
                Class dc=Events.class;
                Context con=addevent.this;
Intent intent=new Intent(con,dc);
                intent.putExtra(Intent.EXTRA_TEXT,data);
                startActivity(intent);
            }
        });
        buttondate.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                updateDate();
            }
        });
        buttontime.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                updateTime();
            }
        });
        buttoninfo.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v)
            {

                String inf=tex.getText().toString();
                text2.setText(inf);
            }

        });
        updateTextLabel();
    }
    private void updateDate(){
        new DatePickerDialog(this,d,datetime.get(Calendar.YEAR),datetime.get(Calendar.MONTH),datetime.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void updateTime() {
        new TimePickerDialog(this,t,datetime.get(Calendar.HOUR_OF_DAY),datetime.get(Calendar.MINUTE),true).show();

    }
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            datetime.set(Calendar.YEAR,year);

            datetime.set(Calendar.MONTH,month);
            datetime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            updateTextLabel();

        }
    };
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            datetime.set(Calendar.HOUR_OF_DAY,hourOfDay);
            datetime.set(Calendar.MINUTE,minute);
            updateTextLabel();
        }
    };
    private void updateTextLabel()
    {
        text.setText(formatdatetime.format(datetime.getTime()));
    }
}
