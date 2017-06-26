package pt.evote.evote.screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import pt.evote.evote.R;
import pt.evote.evote.eVoteApplication;

public class MainActivity extends AppCompatActivity {

    private static final int LOGIN = 1;
    private static final int LOGOUT = 2;
    TextView user;
    TextView pass;
    Context c;
    private eVoteApplication myApplication;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApplication = (eVoteApplication) getApplication();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        user = (TextView) findViewById(R.id.editUsername);
        pass = (TextView) findViewById(R.id.editPassword);

        c = this.getApplicationContext();
    }


    public void onButtonClick(View v) {

        progressBar.bringToFront();
        progressBar.setVisibility(View.VISIBLE);


        new Thread(new Runnable() {
            public void run() {
                try {
                    myApplication.logIn(user.toString(), pass.toString());
                } catch (Exception ex) {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.activity_main),
                            ex.getMessage(), Snackbar.LENGTH_SHORT);
                    mySnackbar.show();
                } finally {
                    Intent intent = new Intent(c, MainMenuActivity.class);
                    startActivityForResult(intent, LOGIN);
                }
            }
        }).start();

    }

    public void onAboutClick(View v) {
        Intent intent = new Intent(this, CreditsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == LOGIN) {
            if (resultCode != LOGOUT) {
                finish();
            }
        }
    }
}
