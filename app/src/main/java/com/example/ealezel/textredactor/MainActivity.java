package com.example.ealezel.textredactor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    private final String internalFile = "internal.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView noteText = (TextView)findViewById(R.id.noteTextView);
        BufferedReader input = null;

        try {
            String filePath = getFilesDir() + "/" + internalFile;
            File file = new File(filePath);

            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = input.readLine()) != null) {
                buffer.append(line);
            }

            input.close();
            noteText.setText(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EditFile(View view)
    {
        Intent goToEditIntent = new Intent(this, EditActivity.class);
        TextView noteText = (TextView)findViewById(R.id.noteTextView);

        goToEditIntent.putExtra("FILE", noteText.getText().toString());
        startActivity(goToEditIntent);
    }

}
