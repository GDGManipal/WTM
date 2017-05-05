package com.example.manya.eventspage;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.*;
import java.text.DateFormat;
import java.util.Calendar;

import android.view.View;
import android.widget.*;
public class Events extends AppCompatActivity {DateFormat formatdatetime=new SimpleDateFormat("dd MM yyyy, HH:mm");
Calendar datetime=Calendar.getInstance();
    private TextView text;
private Button buttondate;
    private Button buttontime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        text = (TextView) findViewById(R.id.textView2);
        buttondate = (Button) findViewById(R.id.button);
        buttontime = (Button) findViewById(R.id.button2);

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
