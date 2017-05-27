package com.cem.shoppingmall.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.cem.shoppingmall.R;

/**
 * Created by huangqigen on 2017/5/25.
 */

//电话客服页面
public class CallCenterActivity extends Activity{
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activitry_message_center);
        webView= (WebView) findViewById(R.id.webview);
    }

    private void setWebView(String url){

        if(url!=null){
            webView.loadUrl(url);

            //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，是网页用WebView打开
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {

                    //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                    view.loadUrl(url);
                    return true;
                }
            });
            //启用支持javascript
            WebSettings settings=webView.getSettings();
            settings.setJavaScriptEnabled(true);

            //优先使用缓存
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
    }

}
