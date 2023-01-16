package com.example.provacallback;

import android.util.Log;

public class MyClass {
    public interface MyInterface {
        public void finish(String risultato);
        public void crash(String errore);
    }
    public void aspetta(final MyInterface callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    callback.finish("FINITO");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    callback.crash("404");
                }

            }

        }).start();

    }
}
