package calc.jahnke.im.calc;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Program started successfully");
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

    public void onButtonClick(View view){
        switch (view.getId()){
            case R.id.buttonPrime:
                startActivity(new Intent(this, IsPrimeActivity.class));
                break;
            case R.id.buttonAbout:
                Log.d("Meldung", "Über...");
                startActivity(new Intent(this, AboutDialogActivity.class));
                break;
            case R.id.buttonNumeralSystem:
                startActivity(new Intent(this, NumeralSystemActivity.class));
                break;
            case R.id.buttonEuklid:
                startActivity(new Intent(this, EuklidActivity.class));
                break;
            default:
                break;
        }
    }

    public void exitProgram(MenuItem item) {
        finish();
    }


    public void openSettings(MenuItem item) {
    }
}