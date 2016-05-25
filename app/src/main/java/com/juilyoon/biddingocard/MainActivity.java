package com.juilyoon.biddingocard;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToFb (View view) {
        goToUrl("https://m.facebook.com/biddingo");
        // For opening in the Facebook app. Doesn't work yet.
        // startActivity(newFacebookIntent(this.getPackageManager(), "http://facebook.com/biddingo"));
    }
    public void goToTwitter (View view) {
        goToUrl("https://mobile.twitter.com/biddingo");
    }
    public void goToCom (View view) {
        goToUrl("http://biddingo.com");
    }

    // Credit: http://stackoverflow.com/a/5026626/745776
    public void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    /**
     * <p>Intent to open the official Facebook app. If the Facebook app is not installed then the
     * default web browser will be used.</p>
     *
     * <p>Example usage:</p>
     *
     * {@code newFacebookIntent(ctx.getPackageManager(), "https://www.facebook.com/JRummyApps");}
     *
     * @param pm
     *     The {@link PackageManager}.
     * @param url
     *     The full URL to the Facebook page or profile.
     * @return An intent that will open the Facebook page/profile.
     *
     * Credit: http://stackoverflow.com/a/24547437/745776
     */
    public static Intent newFacebookIntent(PackageManager pm, String url){
        Uri uri = Uri.parse(url);
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                // http://stackoverflow.com/a/24547437/1048340
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }
}



