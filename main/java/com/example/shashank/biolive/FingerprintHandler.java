package com.example.shashank.biolive;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import javax.crypto.Cipher;

import static android.support.v4.content.ContextCompat.startActivity;
@android.support.annotation.RequiresApi(api = Build.VERSION_CODES.M)
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {
    public Timer timer;

    private Context context;
    public int flag = 0;
    public FingerprintHandler(Context context){

        this.context = context;
    }

    public void startAuth(FingerprintManager fingerprintManager,FingerprintManager.CryptoObject cryptoObject){

        CancellationSignal cancellationSignal = new CancellationSignal();

        fingerprintManager.authenticate(cryptoObject,cancellationSignal ,0,this,null);

    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {

        this.update("Place Your Finger On The Scanner To Continue",false);
    }

    @Override
    public void onAuthenticationFailed() {
        this.update("Authentication Failed",false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        this.update("Error" + helpString,false);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        Toast.makeText(context,"SUCCESS",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context,loginDetails.class);
        context.startActivity(intent);
    }



    private void update(String s, boolean b) {

        TextView paraLabel = (TextView)((Activity)context).findViewById(R.id.paraLabel);
        ImageView imageView = (ImageView)((Activity)context).findViewById(R.id.fingerprintImage);
        paraLabel.setText(s);

        if (b == false){

            paraLabel.setTextColor(ContextCompat.getColor(context,R.color.colorAccent));

        }else {

            paraLabel.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
            imageView.setImageResource(R.mipmap.tick);
        }
    }


}
