package com.example.android.mynewsappone;

public class MyNews {
    private String mArticleTitle;
    private String mArticleSectionName;
    private String mArticlePubdate;

    private String mArticleAuthorName;
    private String mArticleUrl;

    public MyNews(String mArticleTitle, String mArticleSectionName, String mArticlePubdate, String mArticleAuthorName, String mArticleUrl) {
        this.mArticleTitle = mArticleTitle;
        this.mArticleSectionName = mArticleSectionName;
        this.mArticlePubdate = mArticlePubdate;

        this.mArticleAuthorName = mArticleAuthorName;
        this.mArticleUrl = mArticleUrl;
    }

    public String getmArticleTitle() {
        return mArticleTitle;
    }

    public String getmArticleSectionName() {
        return mArticleSectionName;
    }

    public String getmArticlePubdate() {
        return mArticlePubdate;
    }



    public String getmArticleAuthorName() {
        return mArticleAuthorName;
    }

    public String getmArticleUrl() {
        return mArticleUrl;
    }

}
