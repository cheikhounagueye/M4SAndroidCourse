package data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 14/06/2017.
 */

public class ConnexionDistant extends AsyncTask<String, Integer, String> {
    private final TextView ui_statusLabel;
    private ImageView ui_imagevw;
    private int progress;
    private String[] voids;
    private Bitmap bitMap;



    @Override
    protected String doInBackground(String... params) {
        int handledParamCount =0;
        for (String param:params)
        {
            try {
                URL uri = new URL("http://layepro.com/wp-content/uploads/2015/08/IMG_2231-copy.jpg");
                HttpURLConnection connection= (HttpURLConnection) uri.openConnection();
                InputStream inputStream= connection.getInputStream();
                bitMap = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i("CacheChecker","Startin : "+param);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.i("CacheChecker","Ended : "+param);
            handledParamCount = handledParamCount+1;
            progress = (int)handledParamCount / (int)params.length * 100 ;

                Log.i("progress"," test progress "+progress);
        }
        return null;
        }



    public ConnexionDistant(TextView statusLabel, ImageView img) {
        ui_statusLabel = statusLabel;
        ui_imagevw = img;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //ui_statusLabel.setText(" "+progress);
        ui_statusLabel.setText(" loading started...");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //ui_statusLabel2.setText("  "+progress);
        ui_statusLabel.setText(" Loading Finished");
        ui_imagevw.setImageBitmap(bitMap);


    }
}
