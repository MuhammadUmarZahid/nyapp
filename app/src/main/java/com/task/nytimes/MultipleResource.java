package com.task.nytimes;

import android.media.MediaMetadata;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MultipleResource implements Serializable{

    @SerializedName("results")
    public List<Article> articles=null;

    public class Article implements Serializable{

        @SerializedName("title")
        public String title;

        @SerializedName("url")
        public String url;

        @SerializedName("byline")
        public String byline;

        @SerializedName("published_date")
        public String publishedDate;

        @SerializedName("abstract")
        public String abs;

        @SerializedName("media")
        public List<Media> media;

        public class Media implements Serializable{


            @SerializedName("media-metadata")
            List<mediaMetadata> metadataList;

            public class mediaMetadata implements Serializable{

                @SerializedName("url")
                public String url;

                @SerializedName("format")
                public String format;

                @SerializedName("height")
                public String height;

                @SerializedName("width")
                public String width;


            }

        }

    }
}
