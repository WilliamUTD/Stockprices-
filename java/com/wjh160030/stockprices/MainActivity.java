package com.wjh160030.stockprices;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;

import com.google.android.material.textfield.TextInputLayout;

import java.net.URL;


public class MainActivity extends AppCompatActivity {

    URLTask task;
    String symbol;
    String filetype = ".txt";
    String url_s = "http://utdallas.edu/~John.Cole/2017Spring";
    String default_text;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        default_text = ((TextView)findViewById(R.id.info)).getText().toString();
        //mProgressDialog = new ProgressDialog(this);
        task = new URLTask(this);

    }


    public void getInputText(View view) {
        //get the text input and clear the field
        EditText mEdit = findViewById(R.id.textField);
        symbol = mEdit.getText().toString().toUpperCase();
        mEdit.setText("");
        TextView tv = findViewById(R.id.info);
        //set the info text
        String text = default_text + " " +  symbol.toUpperCase();
        tv.setText(text);
        //create the link
        String link = url_s + symbol + filetype;

        try {
            if(task.getStatus() == )
            //execute
            task.execute(link);

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
