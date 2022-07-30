package p06_TirePressureMonitoringSystem;

import main.java.p06_TirePressureMonitoringSystem.Alarm;
import main.java.p06_TirePressureMonitoringSystem.Sensor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    @Test
    public void testAlarmWithLowPressure() {
        //Sensor sensor = new Sensor(); -> не, защото сензора е рандом true рандом false
        Sensor sensor = Mockito.mock(Sensor.class);

        //предефинирам това, което искам сензора да ми върне
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(12.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithHighPressure() {
        Sensor sensor= Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(12000.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithNormalPressure() {
        Sensor sensor= Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}