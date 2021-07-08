package sg.edu.rp.c346.id20022226.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());

        SharedPreferences pref = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor prefEdit  = pref.edit();

        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        String strName = pref.getString("name", "John");
        Float gpa = pref.getFloat("gpa", 0.000000f);
        etName.setText(strName);
        etGPA.setText(gpa + "");
    }
}