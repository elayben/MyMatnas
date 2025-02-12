package com.example.mymatnasbz;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;



public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaration EditTexts
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;

    //Declaration TextInputLayout
    EditText textInputLayoutUserName;
    EditText textInputLayoutEmail;
    EditText textInputLayoutPassword;

    //Declaration Button
    Button buttonRegister;

    //Declaration SqliteHelper
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqliteHelper = new SqliteHelper(this);
        //initTextViewLogin();
        initViews();
        buttonRegister.setOnClickListener(this);

    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for UserName field
        if (UserName.equals("")) {
            valid = false;
            //textInputLayoutUserName.setError("Please enter valid username!");
        } else {
            if (UserName.length() > 5) {
                valid = true;
               // textInputLayoutUserName.setError(null);
            } else {
                valid = false;
              //  textInputLayoutUserName.setError("Username is to short!");
            }
        }

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
        //    textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid = true;
         //   textInputLayoutEmail.setError(null);
        }

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
           // textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid = true;
          //  textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
           // textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
              //  textInputLayoutPassword.setError(null);
            } else {
                valid = false;
              //  textInputLayoutPassword.setError("Password is to short!");
            }
        }


        return valid;
    }


    @Override
    public void onClick(View view) {
        if (view == buttonRegister) {
            if (validate()) {
                String UserName = editTextUserName.getText().toString();
                String Email = editTextEmail.getText().toString();
                String Password = editTextPassword.getText().toString();

                //Check in the database is there any user associated with  this email
                if (!sqliteHelper.isEmailExists(Email)) {

                    //Email does not exist now add new user to database
                    sqliteHelper.addUser(new User(null, UserName, Email, Password));
                    Snackbar.make(buttonRegister, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, Snackbar.LENGTH_LONG);
                } else {

                    //Email exists with email input provided so show error user already exist
                    Snackbar.make(buttonRegister, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
                }

            }
        }
    }
}