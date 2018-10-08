package com.hafidzcode.myasynctask_dicodingp4;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

//topik threads,handler,asynctask-latihan: asynctask sederhana
public class MainActivity extends AppCompatActivity {
    //todo 2
    public static final String DEMO_ASYNC = "DemoAsync";
    private TextView tvStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //todo 3
        tvStatus = (TextView)findViewById(R.id.tv_status);
        DemoAsync demoAsync = new DemoAsync();
        demoAsync.execute("Halo Ini Demo AsyncTask");

    }
    //todo 4
    //become red > alt + enter
    private class DemoAsync extends AsyncTask<String, Void, String>{

        //todo 5
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvStatus.setText("status : onPreExecute");
        }

        //todo 6
        //the result after alt + enter code above
        @Override
        protected String doInBackground(String... params) {
            Log.d(DEMO_ASYNC, "status : doInBackground");
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                Log.d(DEMO_ASYNC, e.getMessage());
            }
            return params[0];
        }
        //todo 7
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            tvStatus.setText("status : onPostExecute : "+s);
        }
    }
}
