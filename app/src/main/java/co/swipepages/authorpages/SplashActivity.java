package co.swipepages.authorpages;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;
    Animation androidZoomOutAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        androidZoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animate);
        imageView.startAnimation(androidZoomOutAnimation);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
                //     }

            }
        }, SPLASH_TIME_OUT);
    }
}
