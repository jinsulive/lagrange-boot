package com.jinsulive.lagrange.spring.autoconfigure.client;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.TimerTask;

/**
 * @author lxy
 * @since 2024年03月18日 17:56:36
 */
public abstract class ReconnectTimerTask extends TimerTask {

    public void reSchedule(int newCheckInterval) throws NoSuchFieldException, IllegalAccessException {
        Date now = new Date();
        long nextExecutionTime = now.getTime() + newCheckInterval;
        Class<TimerTask> timerTaskClass = TimerTask.class;
        setDeclaredField(timerTaskClass, this, "nextExecutionTime", nextExecutionTime);
        setDeclaredField(timerTaskClass, this, "period", newCheckInterval);
    }

    private void setDeclaredField(Class<?> clazz, Object obj, String name, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getDeclaredField(name);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
