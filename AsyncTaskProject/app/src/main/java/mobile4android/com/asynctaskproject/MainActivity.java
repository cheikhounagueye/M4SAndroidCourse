package mobile4android.com.asynctaskproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import data.ConnexionDistant;

public class MainActivity extends AppCompatActivity {
    TextView welcomLabel;
    FrameLayout frameLayout;
    ImageView imageView2;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       welcomLabel = (TextView) findViewById(R.id.welcomTxb);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        //imageView2.setVisibility(View.INVISIBLE);
        setSupportActionBar(toolbar);



       ConnexionDistant con = new ConnexionDistant(welcomLabel,imageView2);
        con.execute("http://layepro.com/wp-content/uploads/2015/08/IMG_2231-copy.jpg");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
