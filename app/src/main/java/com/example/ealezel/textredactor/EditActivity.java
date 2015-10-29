package com.example.ealezel.textredactor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditActivity extends AppCompatActivity {

    private final String internalFile = "internal.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        EditText editText = (EditText) findViewById(R.id.noteEditText);

        Intent intent = getIntent();
        String fileContent = intent.getStringExtra("FILE");


        editText.setText(fileContent);
    }


    public void SaveFile(View view)
    {
        EditText editText = (EditText) findViewById(R.id.noteEditText);
        String content = editText.getText().toString();

        FileOutputStream outputStream = null;
        try {
            outputStream = openFileOutput(internalFile, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();

            Intent goToMainIntent = new Intent(this, MainActivity.class);
            startActivity(goToMainIntent);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
