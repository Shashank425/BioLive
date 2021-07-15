package com.example.shashank.biolive;

    import android.Manifest;
    import android.animation.ObjectAnimator;
    import android.content.Intent;
    import android.content.pm.PackageManager;
    import android.support.annotation.NonNull;
    import android.support.v4.app.ActivityCompat;
    import android.support.v4.content.ContextCompat;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.widget.ImageView;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            Thread xyz = new Thread()
            {
                public void run()
                {
                    try {
                        sleep(3000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        Intent intent = new Intent(MainActivity.this,login.class);
                        startActivity(intent);
                    }
                }

            };
            xyz.start();
        }

        @Override
        protected void onPause() {
            super.onPause();
            finish();
        }
    }
