package sanaa.emailintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView p1 = (TextView )findViewById(R.id.Person1);
        TextView p2 = (TextView) findViewById(R.id.Person2);

        p1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String pers1[] = new String[1];
                pers1[0] = "someone1@gmail.com";
                composeEmail(pers1);
            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String pers2[] = new String[1];
                pers2[0] = "someone2@gmail.com";
                composeEmail(pers2);
            }
        });
    }

    public void composeEmail(String[] addresses) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        try {
            startActivity(Intent.createChooser(intent, "Choose app to send mail:"));
        }catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
       }
    }



