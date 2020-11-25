package com.example.mybrowser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends MainActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Uri url = getIntent().getData();
        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new Callback());
        webView.loadUrl(url.toString());
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading
                (WebView view, String url) {
            return(false);
        }
        public void onClick(View view) {
            Intent intent = new
                    Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://developer.alexanderklimov.ru/android/"));
            startActivity(Intent.createChooser(intent, "Мяу..."));

        }

        public static final java.lang.String ACTION_VIEW = "android.intent.action.VIEW";
    }
}
