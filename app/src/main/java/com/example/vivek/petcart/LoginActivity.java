
package com.example.vivek.petcart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView SignUpView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SignUpView = findViewById(R.id.signup);

        SignUpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUp = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(SignUp);
                Toast.makeText(LoginActivity.this, "SignUp", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
