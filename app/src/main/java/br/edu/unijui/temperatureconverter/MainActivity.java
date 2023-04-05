package br.edu.unijui.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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

        setupButton();
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

    private void setupButton() {
        submitButton.setOnClickListener(view -> System.out.println("cricou"));
    }

    private float celsiusToFarenheit(float celsius) {
        float farenheit = (celsius * 1.8f) + 32;

        return farenheit;
    }

    private float celsiusToKelvin(float celsius) {
        return celsius + 273.15f;
    }

    private float kelvinToCelsius(float kelvin) {
        return  kelvin - 273.15f;
    }

    private float kelvinToFarenheit(float kelvin) {
        float farenheint = ((kelvin - 273.15f) * 1.8f) + 32;

        return farenheint;
    }

    private float farenheitToCelsius(float far) {
        float celsius = (far - 32) * (5/9f);

        return celsius;
    }

    private float farenheitToKelvin(float far) {
        float kelvin = (far - 32) * (5/9f) + 273.15f;

        return kelvin;
    }

}