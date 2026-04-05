package com.browser.multi;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView wv = new WebView(this);
        setContentView(wv);
        
        WebSettings s = wv.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setDatabaseEnabled(true);
        
        // Ключевой момент для "каждая вкладка - новая сессия"
        // Очищаем куки и кэш при каждом запуске приложения
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();
        wv.clearCache(true);
        
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("https://whoer.net");
    }
}