package br.edu.unijui.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TemperatureType[] temperatureLabels = { TemperatureType.Celsius, TemperatureType.Fahrenheit, TemperatureType.Kelvin };
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
        submitButton.setOnClickListener(view -> ConvertTemperature());
    }

    private void ConvertTemperature() {
        TemperatureType inputType = (TemperatureType) cbOrigin.getSelectedItem();
        TemperatureType outputType = (TemperatureType) cbOutput.getSelectedItem();
        float temperature = Float.parseFloat(inputText.getText().toString());

        float result = 0f;

        switch (inputType){
            case Celsius:
                result = convertCelsius(outputType, temperature);
                break;
            case Fahrenheit:
                result = convertFahrenheit(outputType, temperature);
                break;
            case Kelvin:
                result = convertKelvin(outputType, temperature);
                break;
        }

        outputText.setText(Float.toString(result));
    }

    private float convertCelsius(TemperatureType outputType, float value) {
        switch (outputType) {
            case Celsius:
                return value;

            case Fahrenheit:
                return celsiusToFahrenheit(value);

            case Kelvin:
                return celsiusToKelvin(value);
        }

        return value;
    }

    private float convertFahrenheit(TemperatureType outputType, float value) {
        switch (outputType) {
            case Celsius:
                return fahrenheitToCelsius(value);

            case Fahrenheit:
                return value;

            case Kelvin:
                return fahrenheitToKelvin(value);
        }

        return value;
    }

    private float convertKelvin(TemperatureType outputType, float value) {
        switch (outputType) {
            case Celsius:
                return kelvinToCelsius(value);

            case Fahrenheit:
                return kelvinToFahrenheit(value);

            case Kelvin:
                return value;
        }

        return value;
    }
    private float celsiusToFahrenheit(float celsius) {
        return (celsius * 1.8f) + 32;
    }

    private float celsiusToKelvin(float celsius) {
        return celsius + 273.15f;
    }

    private float kelvinToCelsius(float kelvin) {
        return  kelvin - 273.15f;
    }

    private float kelvinToFahrenheit(float kelvin) {
        return ((kelvin - 273.15f) * 1.8f) + 32;
    }

    private float fahrenheitToCelsius(float far) {
        return (far - 32) * (5/9f);
    }

    private float fahrenheitToKelvin(float far) {
        return (far - 32) * (5/9f) + 273.15f;
    }

}