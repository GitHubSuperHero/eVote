package pt.evote.evote.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pt.evote.evote.eVoteApplication;

public class SplashActivity extends AppCompatActivity {

    private static final int LOGIN = 1;
    private eVoteApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myApplication = (eVoteApplication) getApplication();

        //Fixed wait time

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (myApplication.getLoggedIn()) {
            Intent intent = new Intent(this, MainMenuActivity.class);
            startActivityForResult(intent, LOGIN);
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        finish();
    }
}
