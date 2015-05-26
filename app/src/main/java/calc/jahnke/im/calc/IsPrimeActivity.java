package calc.jahnke.im.calc;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import calc.jahnke.im.calc.ModelClasses.PrimeChecker;


public class IsPrimeActivity extends ActionBarActivity {

    Button button;
    EditText input;
    TextView result;
    int number;
    boolean isPrime;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_prime);

        button = (Button) findViewById(R.id.button);
        input = (EditText) findViewById(R.id.editText);
        result = (TextView) findViewById(R.id.resultText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_is_prime, menu);
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

    public void onButtonClick(View v) {
        checkPrime();
    }


    private void checkPrime() {
        ((ProgressBar) findViewById(R.id.progressBar)).setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {

                final Runnable myRunnable;

                int number = Integer.parseInt(input.getText().toString());
                if(number < 15000000){
                    isPrime = new PrimeChecker(number).isPrime();
                    myRunnable = new Runnable() {
                        public void run() {
                            if (isPrime) {
                                result.setText("Primzahl");
                                result.setTextColor(Color.GREEN);
                            } else {
                                result.setText("Keine Primzahl");
                                result.setTextColor(Color.RED);
                            }
                            ((ProgressBar) findViewById(R.id.progressBar)).setVisibility(View.INVISIBLE);
                        }
                    };
                    handler.post(myRunnable);
                } else {
                    myRunnable = new Runnable() {
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Number must be between 1 and 15.000.000", Toast.LENGTH_SHORT).show();
                            ((ProgressBar) findViewById(R.id.progressBar)).setVisibility(View.INVISIBLE);
                        }
                    };

                }
                handler.post(myRunnable);
            }
        }).start();
    }
}
