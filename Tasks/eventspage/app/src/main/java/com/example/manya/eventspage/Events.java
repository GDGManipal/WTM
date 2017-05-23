package com.example.manya.eventspage;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.sql.Types.NULL;

public class Events extends AppCompatActivity {
private TextView t;
    private static ListView l;
    private static ArrayAdapter<String> adapter;
    final static ArrayList<String> arrayList = new ArrayList<String>();
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    protected DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        t = (TextView) findViewById(R.id.textView3);
        l = (ListView) findViewById(R.id.list_view);

        myRef=database.getReference().child("events");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                    event val=childSnapshot.getValue(event.class);
                    arrayList.add(val.event_detail);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });

        // Adapter: You need three parameters 'the context, id of the layout (it will be where the data is shown),
        // and the array that contains the data
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        l.setAdapter(adapter);
    }
   protected void onResume()
    {
        super.onResume();
Intent in=getIntent();
if(in.hasExtra(Intent.EXTRA_TEXT))
{


    String d=in.getStringExtra(Intent.EXTRA_TEXT);
  DatabaseReference postsRef = database.getReference().child("events");

    DatabaseReference newPostRef = postsRef.push();
    if(postsRef!=null)
    newPostRef.setValue(new event(d));

   // arrayList.add(d);

    // next thing you have to do is check if your adapter has changed
    adapter.notifyDataSetChanged();

}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add_event) {
Context context=Events.this;
            Class destclass=addevent.class;
            Intent str=new Intent(context,destclass);
            startActivity(str);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
