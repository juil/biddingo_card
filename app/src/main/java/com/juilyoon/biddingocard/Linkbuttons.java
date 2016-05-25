package com.juilyoon.biddingocard;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Linkbuttons extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToFb (View view) {
        goToUrl ("https://www.facebook.com/Biddingo/");
    }

    public void goToTwitter (View view) {
        goToUrl("https://twitter.com/biddingo");
    }

    public void goToCom (View view) {
        goToUrl("http://biddingo.com");
    }

    public void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
