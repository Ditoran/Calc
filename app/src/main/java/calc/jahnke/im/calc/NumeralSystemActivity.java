package calc.jahnke.im.calc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import calc.jahnke.im.calc.ModelClasses.NumberSystemConverter;


public class NumeralSystemActivity extends ActionBarActivity implements OnItemSelectedListener {

    private String[] systems = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
    Spinner systemsInputSpinner;
    Spinner systemsTargetSpinner;
    EditText input;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeral_system);

        input = (EditText)findViewById(R.id.inputNumber);
        result = (TextView)findViewById(R.id.textViewResult);

        systemsInputSpinner = (Spinner) findViewById(R.id.spinnerInputSystem);
        systemsTargetSpinner = (Spinner) findViewById(R.id.spinnerTargetSystem);
        ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, systems);
        adapter_state
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        systemsInputSpinner.setAdapter(adapter_state);
        systemsInputSpinner.setOnItemSelectedListener(this);
        systemsTargetSpinner.setAdapter(adapter_state);
        systemsTargetSpinner.setOnItemSelectedListener(this);
        systemsTargetSpinner.setSelection(8);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_numeral_system, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == findViewById(R.id.spinnerInputSystem).getId()){
            Log.d("Spinner Input", ""+parent.getSelectedItem().toString());
        } else {
            Log.d("Spinner Output", ""+parent.getSelectedItem().toString());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d("Spinner Input", ""+parent.getSelectedItem().toString());
    }

    public void onClickButton(View view){
        int currentSystem = systemsInputSpinner.getSelectedItemPosition()+2;
        int targetSystem = systemsTargetSpinner.getSelectedItemPosition()+2;
        Log.d("In On Click", "Input: "+input.getText().toString());
        Log.d("In On Click", "StartSystem: "+currentSystem);
        Log.d("In On Click", "TargetSystem: "+targetSystem);
        String converted = NumberSystemConverter.convert(input.getText().toString(), currentSystem, targetSystem);
        result.setText(converted);
    }
}
