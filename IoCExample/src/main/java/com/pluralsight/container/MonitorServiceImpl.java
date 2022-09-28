package com.pluralsight.container;

public class MonitorServiceImpl implements MonitorService {

    private final MonitorDao monitorDao;
    private final String message;

    public MonitorServiceImpl(MonitorDao monitorDao, String test, int arg2) {
        this.monitorDao = monitorDao;
        this.message = test;
    }

    @Override
    public void sayHi() {
        System.out.println(monitorDao.getPesho() + message + ".");
    }
}
