package com.example.staff4health;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Backgroundtask extends AsyncTask<String,String,String> {

    Context context;
    AlertDialog alertDialog;
    Backgroundtask (Context ctx)
    {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
        String login_url = "http://192.168.0.101:80/staff4healt.com/v1/api/registration"; //declare want you want to connect with

        if (type.equals("register"))
        {
            try {
                String user_name = params[1];
                String password = params[2];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection(); //declare http connection class
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8") + "=" +URLEncoder.encode(user_name, "UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8") + "=" +URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                //below: read and get post respone
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result="";
                String line="";

                while ((line = bufferedReader.readLine())!=null)
                {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            //Clause for httpurlconnection
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }
}
