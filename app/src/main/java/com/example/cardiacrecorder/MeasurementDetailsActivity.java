package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * This activity is for showing detailed measurements
 */
public class MeasurementDetailsActivity extends AppCompatActivity {

    TextView dateUpdateText, timeUpdateText, sysUpdateText, diasUpdateText, hrtUpdateText, cmntUpdateText;
    Button updateActivityButton;

    String upId, upDate, upTime, upSys, upDias, upHrt, upCmnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_details);

        upId = getIntent().getStringExtra("up_Id");
        upDate = getIntent().getStringExtra("up_Date");
        upTime = getIntent().getStringExtra("up_Time");
        upSys = getIntent().getStringExtra("up_Sys");
        upDias = getIntent().getStringExtra("up_Dias");
        upHrt = getIntent().getStringExtra("up_Hrt");
        upCmnt = getIntent().getStringExtra("up_Cmnt");

        dateUpdateText = (TextView) findViewById(R.id.dateDetailsTextId);
        timeUpdateText = (TextView) findViewById(R.id.timeDetailsTextId);
        sysUpdateText = (TextView) findViewById(R.id.sysDetailsTextId);
        diasUpdateText = (TextView) findViewById(R.id.diasDetailsTextId);
        hrtUpdateText = (TextView) findViewById(R.id.hrtDetailsTextId);
        cmntUpdateText = (TextView) findViewById(R.id.cmntDetailsTextId);
        updateActivityButton = (Button) findViewById(R.id.updateActivityButtonId);

        dateUpdateText.setText("Date (dd-mm-yy):\n"+ upDate);
        timeUpdateText.setText("Time (hh:mm):\n"+upTime);
        sysUpdateText.setText("Systolic (mmHg):\n"+upSys);
        diasUpdateText.setText("Diastolic (mmHg):\n"+upDias);
        hrtUpdateText.setText("Heart Rate (bpm):\n"+upHrt);
        cmntUpdateText.setText("Comment:\n"+upCmnt);

        updateActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeasurementDetailsActivity.this,UpdateMeasurementActivity.class);
                intent.putExtra("up_Id",upId);
                intent.putExtra("up_Date",upDate);
                intent.putExtra("up_Time",upTime);
                intent.putExtra("up_Sys",upSys);
                intent.putExtra("up_Dias",upDias);
                intent.putExtra("up_Hrt",upHrt);
                intent.putExtra("up_Cmnt",upCmnt);
                startActivity(intent);
            }
        });
    }
}