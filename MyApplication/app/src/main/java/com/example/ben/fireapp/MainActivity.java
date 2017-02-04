package com.example.ben.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

////////////////////////////////////////////////////////////*
// This program writes to a FireBase Database               *
// Dependencies needed to be added are on the FB website    *
// or FireBase tools on android studio.                     *
// Note: This is letting anybody write to the database      *
// under the JSON rules for the database                    *
////////////////////////////////////////////////////////////*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button submitData = (Button)findViewById(R.id.submitData);
        final EditText textField = (EditText)findViewById(R.id.editText);


        // On button click, push data in editText to Database
        submitData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                // Makes it so it doesn't overwrite the previous submission on the database
                DatabaseReference myRef = database.getReference().push();
                // Sets the value of the DB reference that's being pushed
                myRef.setValue(textField.getText().toString());
            }
        });

    }
}
