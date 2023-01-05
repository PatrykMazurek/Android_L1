package com.masiad.myapplication_l1;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button bSave = findViewById(R.id.bSave);
        Button bPrev = findViewById(R.id.bPrev);
        EditText etName = findViewById(R.id.eTPersonName);
        EditText etLastName = findViewById(R.id.eTPersonLastName);
        EditText etTitleMessage = findViewById(R.id.eTTitleMessage);
        EditText etMessage = findViewById(R.id.eTMessage);

        int number = getIntent().getIntExtra("id", 0);

        Toast.makeText(this, number+"", Toast.LENGTH_SHORT).show();

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // dodanie wiadomości do listy
                String name = "", lastName = "", title = "", textMessage = "";
                if(!etName.getText().toString().isEmpty()){
                    name = etName.getText().toString();
                }
                if(!etLastName.getText().toString().isEmpty()){
                    lastName = etLastName.getText().toString();
                }
                if(!etTitleMessage.getText().toString().isEmpty()){
                    title = etTitleMessage.getText().toString();
                }
                if(!etMessage.getText().toString().isEmpty()){
                    textMessage = etMessage.getText().toString();
                }
//                MainActivity.messageList.add(new Message(name, lastName, title, textMessage));
                MainActivity.repository.insertMessage(
                        new Message(name, lastName, title, textMessage));
                Toast.makeText(FormActivity.this, "Dodano wiadomość do listy", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT).show();
    }
}