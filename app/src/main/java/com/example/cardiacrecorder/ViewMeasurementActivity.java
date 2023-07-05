package com.example.cardiacrecorder;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This activity is for viewing all measurements in a list
 */
public class ViewMeasurementActivity extends AppCompatActivity {
    DatabaseReference mylRef;
    ListView listViewMeasurement;
    List<MeasurementModelClass> measureList;

    FloatingActionButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_measurement);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.btn_dark_red)));

        mylRef = FirebaseDatabase.getInstance().getReference("Measurements");

        listViewMeasurement = (ListView) findViewById(R.id.measureListViewId);

        measureList = new ArrayList<>();

        addBtn = (FloatingActionButton) findViewById(R.id.floatAddBtnId);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewMeasurementActivity.this,AddMeasurementActivity.class);
                startActivity(intent);
            }
        });

        listViewMeasurement.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MeasurementModelClass measurement = measureList.get(i);
                String upId = measurement.getMeasureId().toString();
                String upDate = measurement.getDate().toString();
                String upTime = measurement.getTime().toString();
                String upSys = measurement.getSystolic().toString();
                String upDias = measurement.getDiastolic().toString();
                String upHrt = measurement.getHeartRate().toString();
                String upCmnt = measurement.getComment().toString();

                Intent intent = new Intent(ViewMeasurementActivity.this,MeasurementDetailsActivity.class);
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

        listViewMeasurement.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(ViewMeasurementActivity.this)
                        .setMessage("Are you sure you want to delete the data permanently?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int j) {
                                MeasurementModelClass measurement = measureList.get(i);
                                String delId = measurement.getMeasureId().toString();
                                deleteMeasurement(delId);
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();

                return true;
            }
        });
    }

    private void deleteMeasurement(String delId) {
        DatabaseReference delRef = FirebaseDatabase.getInstance().getReference("Measurements").child(delId);
        delRef.removeValue();
        Toast.makeText(ViewMeasurementActivity.this,"Measurement deleted!",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(ViewMeasurementActivity.this,"Long press on the delete button to delete any measurement",Toast.LENGTH_LONG).show();

        mylRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                measureList.clear();
                for(DataSnapshot measureSnapshot: snapshot.getChildren()){
                    MeasurementModelClass modelMeasure = measureSnapshot.getValue(MeasurementModelClass.class);
                    measureList.add(modelMeasure);
                }

                MeasurementListAdapter adapter =new MeasurementListAdapter(ViewMeasurementActivity.this,measureList);
                listViewMeasurement.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}