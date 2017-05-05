package com.sukriti.mailanexpert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button   send;
    EditText sendto;
    EditText sub;
    EditText message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize objects (Widgets)
        send=(Button) findViewById(R.id.buttonSend);
        sendto = (EditText) findViewById(R.id.editTextTo);
        sub = (EditText) findViewById(R.id.editTextSubject);
        message = (EditText) findViewById(R.id.editTextMessage);

        //On Clicking the Button object
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String to = sendto.getText().toString();
                String subject = sub.getText().toString();
                String query = message.getText().toString();

                //Email Intent
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, query);

                //Prompt email client
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

    }
}
