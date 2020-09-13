package com.tsofen.agsenceapp.BackgroundServices;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import com.tsofen.agsenceapp.dataServices.OnDataReadyHandler;
import com.tsofen.agsenceapp.dataServices.OnDevicesReadyHandler;
import com.tsofen.agsenceapp.dataServices.OnLogin;
import com.tsofen.agsenceapp.dataServices.TextDownloader;
import com.tsofen.agsenceapp.entities.Admin;
import com.tsofen.agsenceapp.entities.Devices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CacheMgr {
    private static CacheMgr cacheMgr = null;

    //handles
    private HandlerThread handlerThreadServerPeriodic = new HandlerThread("serverPeriodicJobHandler");
    private HandlerThread handlerThreadLogin = new HandlerThread("handlerThreadLogin");
    private Handler threadHandler;
    private CacheMgr() {
        initializeAllServices();
    }

    public static CacheMgr getInstance()
    {
        if (cacheMgr == null)
            cacheMgr = new CacheMgr(); // TODO - add synchronized.

        return cacheMgr;
    }


    public class getDevicesRunnable implements Runnable // TODO - transform to anonymous class
    {
        private OnDevicesReadyHandler handler;
        @Override
        public void run()
        {
                TextDownloader downloader = new TextDownloader();
                downloader.setOnDownloadCompletedListener(new OnDataReadyHandler() { // specifying a new handler for textDownloader
                    @Override
                    public void onDataDownloadCompleted(String downloadedData) { // creating a new OnDataReadyHandler, and inserting it to downloader as handler.
                        Log.d("DOWNLOAD","Download text is "+downloadedData);

                        // we have  results at downloadedData, but we now presenting dummy data.

                        Date date = new Date();
                        date.getTime();
                        Date date1 = new Date();
                        date.setTime(20102020);

                        List<Devices> devices = new ArrayList<>();
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));
                        devices.add(new Devices(0,1,1,"Device",date,date1,true));

                        if (handler != null) {
                            handler.onDevicesReady(devices); //  chaining the handlers. -> updating the main handler that devices are ready ---changing
                        }
                    }
                });
                downloader.getText("https://www.google.com"); // TODO create the URL in getDevicesRunnable Ctor. // via field.


        }
    }


    private void initializeAllServices() // remove public
    {
        //initializing the serverPeriodJob
        handlerThreadLogin.start();
        threadHandler = new Handler(handlerThreadLogin.getLooper());


    }

   // public void serverPeriodicJob()
   // {
            //threadHandler.post(new getDevicesRunnable());

            //threadHandler.post(new WaitPeriod());

   // }

   public void loginJob(final OnLogin handler)
    {
        threadHandler.post(new Runnable() {
            @Override
            public void run() {
                TextDownloader downloader = new TextDownloader();
                downloader.setOnDownloadCompletedListener(new OnDataReadyHandler() {
                    @Override
                    public void onDataDownloadCompleted(String downloadedData) {
                        Admin user = new Admin(1, "Admin", "rami@gmail.com");
                        handler.onLoginSuccess(user);
                    }
                });
                downloader.getText("https://www.google.com");

            }
        });
    }

}
