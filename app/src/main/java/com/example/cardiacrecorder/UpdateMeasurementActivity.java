package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * This activity is for updating measurement
 */
public class UpdateMeasurementActivity extends AppCompatActivity {

    EditText dateUpdateText, timeUpdateText, sysUpdateText, diasUpdateText, hrtUpdateText, cmntUpdateText;
    Button updateButton;

    String upId, upDate, upTime, upSys, upDias, upHrt, upCmnt;

    DatabaseReference upRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_measurement);

        upId = getIntent().getStringExtra("up_Id");
        upDate = getIntent().getStringExtra("up_Date");
        upTime = getIntent().getStringExtra("up_Time");
        upSys = getIntent().getStringExtra("up_Sys");
        upDias = getIntent().getStringExtra("up_Dias");
        upHrt = getIntent().getStringExtra("up_Hrt");
        upCmnt = getIntent().getStringExtra("up_Cmnt");

        dateUpdateText = (EditText) findViewById(R.id.editTextDateUpdateId);
        timeUpdateText = (EditText) findViewById(R.id.editTextTimeUpdateId);
        sysUpdateText = (EditText) findViewById(R.id.editTextSysUpdateId);
        diasUpdateText = (EditText) findViewById(R.id.editTextDiasUpdateId);
        hrtUpdateText = (EditText) findViewById(R.id.editTextHrtUpdateId);
        cmntUpdateText = (EditText) findViewById(R.id.editTextCommentUpdateId);
        updateButton = (Button) findViewById(R.id.updateButtonId);

        dateUpdateText.setText(upDate);
        timeUpdateText.setText(upTime);
        sysUpdateText.setText(upSys);
        diasUpdateText.setText(upDias);
        hrtUpdateText.setText(upHrt);
        cmntUpdateText.setText(upCmnt);

        upRef = FirebaseDatabase.getInstance().getReference("Measurements");

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMeasurement();
                Intent intent = new Intent(UpdateMeasurementActivity.this,ViewMeasurementActivity.class);
                startActivity(intent);
            }
        });

    }

    private void updateMeasurement() {
        String date = dateUpdateText.getText().toString();
        String time = timeUpdateText.getText().toString();
        String systolic = sysUpdateText.getText().toString();
        String diastolic = diasUpdateText.getText().toString();
        String hrtRate = hrtUpdateText.getText().toString();
        String comment = cmntUpdateText.getText().toString();

        if(TextUtils.isEmpty(date))
        {
            date = upDate;
        }
        if(TextUtils.isEmpty(time))
        {
            time = upTime;
        }
        if(TextUtils.isEmpty(systolic))
        {
            systolic = upSys;
        }
        if(TextUtils.isEmpty(diastolic))
        {
            diastolic = upDias;
        }
        if(TextUtils.isEmpty(hrtRate))
        {
            hrtRate = upHrt;
        }
        if(TextUtils.isEmpty(comment))
        {
            comment = upCmnt;
        }
        String id = upId;
        MeasurementModelClass measurement = new MeasurementModelClass(id,date,time,systolic,diastolic,hrtRate,comment);
        upRef.child(id).setValue(measurement);
        Toast.makeText(UpdateMeasurementActivity.this,"Updated",Toast.LENGTH_LONG).show();
    }


}