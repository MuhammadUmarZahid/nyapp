package com.task.nytimes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NYTimesAPI {

    @GET("/svc/mostpopular/v2/mostviewed/all-sections/7.json?")
    Call<MultipleResource> getMostPopularArticles(@Query("api-key")String apikey);
}
