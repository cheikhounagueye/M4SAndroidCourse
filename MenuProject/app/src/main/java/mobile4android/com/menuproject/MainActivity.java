package mobile4android.com.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button smsButton;
    private Button phButton;
    private Button webBtutton;
    private Button mapBtutton;
    private  Button shareBtutton;
   private Button newActivityBtutton;
    public static final String EXTRA_MESSAGE = "mobile4android.menuprojet.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //initialisation des boutons
     initialiseButton();
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "SMS CLICK", Toast.LENGTH_LONG).show();
                final Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto: "+Uri.encode("777834274")));
                intent.putExtra("sms_body","Hello Bamba");
                startActivity(intent);
            }
        });
        phButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new  Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:777834274"));
                startActivity(intent);
            }
        });
        webBtutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent webSiteintent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.fr"));
                startActivity(webSiteintent);
            }
        });

        mapBtutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = String.format("geo:38.899533,-77.036476");
                Uri geo  = Uri.parse(geoUri);
                final Intent intentmap = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(intentmap);
            }
        });

        shareBtutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent sendIntent = new Intent(getBaseContext(), ShareActivity.class);
                //startActivity(intent);
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Share the love");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
            }
        });

        newActivityBtutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getBaseContext(), NewActivityShow.class);
                startActivity(newIntent);
            }
        });
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
        }else if (id==R.id.action_help){
            Toast.makeText(this, "Merci de cliquer ", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
   public void initialiseButton(){
        smsButton = (Button) findViewById(R.id.smsBtn);
        phButton = (Button) findViewById(R.id.phoneBtn);
        webBtutton = (Button) findViewById(R.id.webBtn);
        mapBtutton = (Button) findViewById(R.id.mapBtn);
        shareBtutton = (Button) findViewById(R.id.shareBtn);
        newActivityBtutton = (Button) findViewById(R.id.newActivitybtn);

    }
}
