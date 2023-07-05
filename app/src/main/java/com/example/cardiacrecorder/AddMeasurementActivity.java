package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

/**
 * AddMeasurement Activity
 * This activity is for adding a measurement to firebase database
 */
public class AddMeasurementActivity extends AppCompatActivity {
    EditText dateText,timeText,sysText,diasText,hrtText,cmntText;
    Button addButton;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_measurement);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.btn_dark_red)));

        myRef = FirebaseDatabase.getInstance().getReference("Measurements");

        dateText = (EditText) findViewById(R.id.editTextDateId);
        timeText = (EditText) findViewById(R.id.editTextTimeId);
        sysText = (EditText) findViewById(R.id.editTextSysId);
        diasText = (EditText) findViewById(R.id.editTextDiasId);
        hrtText = (EditText) findViewById(R.id.editTextHrtId);
        cmntText = (EditText) findViewById(R.id.editTextCommentId);
        addButton = (Button) findViewById(R.id.addButtonId);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMeasurement();
            }
        });
    }

    private void addMeasurement()
    {
        String date = dateText.getText().toString();
        String time = timeText.getText().toString();
        String systolic = sysText.getText().toString();
        String diastolic = diasText.getText().toString();
        String hrtRate = hrtText.getText().toString();
        String comment = cmntText.getText().toString();

        if(TextUtils.isEmpty(date))
        {
            Toast.makeText(this,"Please enter a date!",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(time))
        {
            Toast.makeText(this,"Please enter time!",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(systolic))
        {
            Toast.makeText(this,"Please enter systolic measurement value!",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(diastolic))
        {
            Toast.makeText(this,"Please enter diastolic measurement value!",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(hrtRate))
        {
            Toast.makeText(this,"Please enter measured heart rate!",Toast.LENGTH_LONG).show();
        }
        else{
            String id = myRef.push().getKey();
            MeasurementModelClass measurement = new MeasurementModelClass(id,date,time,systolic,diastolic,hrtRate,comment);
            myRef.child(id).setValue(measurement);
            Toast.makeText(this,"Measurement added!",Toast.LENGTH_LONG).show();
            dateText.setText(null);
            timeText.setText(null);
            sysText.setText(null);
            diasText.setText(null);
            hrtText.setText(null);
            cmntText.setText(null);
        }
    }
}