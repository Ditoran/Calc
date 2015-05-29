package calc.jahnke.im.calc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import calc.jahnke.im.calc.ModelClasses.EuklidModule;


public class EuklidActivity extends ActionBarActivity {

    TextView ggtResult;
    TextView kgvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_euklid);

        ggtResult = (TextView)findViewById(R.id.ggtResult);
        kgvResult = (TextView)findViewById(R.id.kgvResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_euklid, menu);
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

        Log.d("EuklidActivity", "Button clicked");

        int a = Integer.parseInt(((EditText)findViewById(R.id.numberA)).getText().toString());
        int b = Integer.parseInt(((EditText)findViewById(R.id.numberB)).getText().toString());

        EuklidModule euklid = new EuklidModule(a, b);

        ((TextView)findViewById(R.id.ggtText)).setVisibility(View.VISIBLE);
        ((TextView)findViewById(R.id.kgvText)).setVisibility(View.VISIBLE);

        ggtResult.setText(""+euklid.getGgt());
        kgvResult.setText(""+euklid.getKgv());
    }
}
