package br.edu.unijui.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    String[] temperatureLabels = { "Celsius", "Farenheit", "Kelvin" };
    Spinner cbOrigin;
    Spinner cbOutput;

    EditText inputText;
    EditText outputText;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponents();
        setComboBoxes();
    }

    private void setComponents() {
        cbOrigin = findViewById(R.id.cbOrigin);
        cbOutput = findViewById(R.id.cbOutput);

        inputText = findViewById(R.id.originText);
        outputText = findViewById(R.id.outputText);

        submitButton = findViewById(R.id.submitButton);
    }

    private void setComboBoxes() {
        cbOrigin.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, temperatureLabels));
        cbOutput.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, temperatureLabels));
    }

    
}