package com.example.android.mynewsappone;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<MyNews>> {
    private MyNewsAdapter mAdapter;
    private TextView mNoContentTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        ListView newsListView = findViewById(R.id.list_item);
        mNoContentTextView = findViewById(R.id.view_empty1);
        newsListView.setEmptyView(mNoContentTextView);
        mAdapter = new MyNewsAdapter(this, new ArrayList<MyNews>());

        newsListView.setAdapter(mAdapter);
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                MyNews currentNews = mAdapter.getItem(position);
                Uri newsUri = Uri.parse(currentNews.getmArticleUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(websiteIntent);
            }
        });
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(0, null, this);
        } else {


            View loadingIndicator = findViewById(R.id.myprogressbar);
            loadingIndicator.setVisibility(View.GONE);
            mNoContentTextView.setText(R.string.error_message);
        }
    }

    @Override
    public Loader<List<MyNews>> onCreateLoader(int id, Bundle args) {
        return new MyNewsLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<MyNews>> loader, List<MyNews> news) {
        View loadingIndicator = findViewById(R.id.myprogressbar);
        loadingIndicator.setVisibility(View.GONE);
        mNoContentTextView.setText(R.string.error_message);
        mAdapter.clear();

        if (news != null && !news.isEmpty()) {
            mAdapter.addAll(news);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<MyNews>> loader) {
        mAdapter.clear();
    }
}



