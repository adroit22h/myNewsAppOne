package com.example.android.mynewsappone;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MyNewsLoader extends AsyncTaskLoader<List<MyNews>> {


    private static String REQUEST_URL =
           // "http://content.guardianapis.com/search?show-tags=contributor&api-key=test";
            "https://content.guardianapis.com/search?api-key=0bd3322e-7c04-40dd-9395-e9e9064ffc37";

    public MyNewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<MyNews> loadInBackground() {
        if (REQUEST_URL == null) {
            return null;
        }

        List<MyNews> newsList = MyNewsQueryUtils.fetchNewsData(REQUEST_URL);
        return newsList;
    }
}
