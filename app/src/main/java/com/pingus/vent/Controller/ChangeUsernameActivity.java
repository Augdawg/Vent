package com.pingus.vent.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.pingus.vent.R;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ishanwaykul on 4/25/17.
 * Changes the username via the profile page
 */

public class ChangeUsernameActivity extends AppCompatActivity {
    private EditText entry;
    private EditText confirmEntry;
    private Button end;
    private FirebaseUser user;
    private DatabaseReference database;
    private TextView currentUsername;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_username);
        entry = (EditText) findViewById(R.id.userEntry);
        confirmEntry = (EditText) findViewById(R.id.confirmEntry);


        end = (Button) findViewById(R.id.usernameChange);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entered = entry.getText().toString().trim();
                String confirmentered = confirmEntry.getText().toString().trim();
                Intent intent = new Intent(getBaseContext(), ProfileActivity.class);
                if(!entered.equals(confirmentered)) {
                    Toast.makeText(getBaseContext(),"Sorry, Fields Do Not Match",Toast.LENGTH_SHORT).show();
                    return;
                }
                changeUsername(entered);
                startActivity(intent);
            }
        });



    }

    /**
     * Helper function to change the username
     * @param username to be changed to
     */
    public void changeUsername(String username) {
        //database.getRoot().child("users").child(user.getUid()).child("userName").setValue(username);
        //currentUsername = (TextView) findViewById(R.id.currentUsername);
       // currentUsername.setText(username);
    }
}
