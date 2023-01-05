package com.masiad.myapplication_l1;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class RandNumber implements Runnable{

    private View app;

    public RandNumber(View application){
        app = application;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        Random rand = new Random();
        double doubleNumber = rand.nextDouble();
        System.out.println(name + " wylosował " + doubleNumber );
        Toast.makeText(app.getContext(), name + " wylosował " + doubleNumber,
                Toast.LENGTH_SHORT).show();
        try {
            Thread.sleep(rand.nextInt(5000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
