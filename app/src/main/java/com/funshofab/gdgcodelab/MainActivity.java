package com.funshofab.gdgcodelab;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // The minimum number of characters allowed for a username
    private final int MINIMUM_CHARACTERS_ALLOWED = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeWidgets();
    }

    private void initializeWidgets() {
        // Get reference to the widgets
        TextInputEditText usernameEditText = findViewById(R.id.username_edit_text);
        final Button registerButton = findViewById(R.id.register_button);

        // Disable the register button until a username longer than MINIMUM_CHARACTERS_ALLOWED characters is entered
        registerButton.setEnabled(false);

        // Listen for changes on the username EditText
        usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ignore this
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Check if the length of the text is greater than or equal to MINIMUM_CHARACTERS_ALLOWED.
                // If it is, enable the register button
                if (s.length() >= MINIMUM_CHARACTERS_ALLOWED) {
                    registerButton.setEnabled(true);
                } else {
                    registerButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Ignore this
            }
        });
    }
}
