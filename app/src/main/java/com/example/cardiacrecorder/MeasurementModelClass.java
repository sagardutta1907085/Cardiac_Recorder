package com.example.cardiacrecorder;

/**
 * This is a model class for uploading data into database
 */
public class MeasurementModelClass {
    String measureId,date,time,systolic,diastolic,heartRate,comment;

    public MeasurementModelClass(){}

    public MeasurementModelClass(String measureId, String date, String time, String systolic, String diastolic, String heartRate, String comment) {
        this.measureId = measureId;
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heartRate;
        this.comment = comment;
    }

    public String getMeasureId() {
        return measureId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getSystolic() {
        return systolic;
    }

    public String getDiastolic() {
        return diastolic;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public String getComment() {
        return comment;
    }

    public void setMeasureId(String measureId) {
        this.measureId = measureId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}