package com.example.cardiacrecorder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnitTest {

    /**
     * Creating a mock list
     * @return
     */
    private MeasurementListUnit mockList()
    {
        MeasurementListUnit mList=new MeasurementListUnit();
        mList.add(mockMeasure());
        return mList;
    }

    /**
     * Adding mock measure
     * @return
     */
    private Measurement mockMeasure()
    {
        return new Measurement("28-07-2022","11:20pm",130,90,80,"good");
    }

    /**
     * Testing add option
     */
    @Test
    public void testAdd()
    {
        MeasurementListUnit mList=mockList();
        assertEquals(1,mList.getMeasure().size());

        Measurement m=new Measurement("28/07/2022","10:45pm",120,70,85,"Good");
        mList.add(m);

        assertEquals(2,mList.getMeasure().size());
        assertTrue(mList.getMeasure().contains(m));
    }


    /**
     * Testing get measurement function
     */
    @Test
    public void testGetMeasure()
    {
        MeasurementListUnit mList = mockList();
        assertEquals(0, mockMeasure().compareTo(mockList().getMeasure().get(0)));

        Measurement measure = new Measurement("23/07/2022","10:45pm",120,70,85,"Sitting");
        mList.add(measure);

        assertEquals(0, measure.compareTo(mList.getMeasure().get(1)));
        assertEquals(0, mockMeasure().compareTo(mList.getMeasure().get(0)));
    }

    /**
     * Testing delete function
     */
    @Test
    public void testDelete()
    {
        MeasurementListUnit mList=mockList();
        Measurement measure = new Measurement("23/07/2022","8:45pm",140,90,100,"Walking");
        mList.add(measure);
        assertTrue(mList.getMeasure().contains(measure));
        mList.remove(measure);
        assertFalse(mList.getMeasure().contains(measure));

    }

    /**
     * Testing update functionality
     */
    @Test
    public void testUpdate()
    {
        MeasurementListUnit mList=mockList();
        Measurement measure = new Measurement("23/07/2022","8:45pm",140,90,100,"Walking");
        mList.add(measure);
        assertTrue(mList.getMeasure().contains(measure));
        Measurement another=new Measurement("28/07/2022","1:45am",120,80,80,"Resting");
        mList.edit(1,another);
        assertFalse(mList.getMeasure().contains(measure));
        assertTrue(mList.getMeasure().contains(another));
    }
}
