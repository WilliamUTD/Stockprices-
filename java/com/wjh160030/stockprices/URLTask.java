package com.wjh160030.stockprices;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AbsListView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class URLTask extends AsyncTask<String, Integer, ArrayList<StockItemInfo>> {


    String response;
    Context context;
    ArrayList information = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();

    URLTask(Context c){
        this.context = c;
    }

    @Override
    protected void onPostExecute(ArrayList<StockItemInfo> v) {
        super.onPostExecute(v);
        //do the adapter here?
    }


    @Override
    protected ArrayList<StockItemInfo> doInBackground(String... params) {
        try{
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            publishProgress(5);
            //set up params
            connection.setDoInput(true);
            connection.setConnectTimeout(1000);
            connection.setRequestMethod("GET");
            //open connection
            connection.connect();
            publishProgress(10);

            //check response
            if(connection.getResponseCode() == 200){
                Scanner in = new Scanner( new InputStreamReader(connection.getInputStream()));
                publishProgress(20);
                while(in.hasNext()){
                    sb = null;
                    sb.append(in.nextLine());
                    information.add(new StockItemInfo(sb.toString()));
                }

            }
            //return bad response
            else{
                information.add("Server returned HTTP " + connection.getResponseCode() + " " + connection.getResponseMessage());
                publishProgress(100);
                return  information;
            }

        }
        catch(Exception e){

        }


        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onProgressUpdate(Integer[] progress) {
        super.onProgressUpdate(progress);
    }
}
