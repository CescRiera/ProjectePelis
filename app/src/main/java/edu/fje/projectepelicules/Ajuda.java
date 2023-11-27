package edu.fje.projectepelicules;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class Ajuda extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript

        // Add JavaScript interface to communicate with Android code
        webView.addJavascriptInterface(new WebAppInterface(), "Android");

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/ajuda.html");

        setContentView(webView);
    }

    // Class to handle communication from JavaScript to Android
    private class WebAppInterface {
        @android.webkit.JavascriptInterface
        public void goBackFromWebView() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    onBackPressed(); // Simulate the back button press
                }
            });
        }
    }
}
