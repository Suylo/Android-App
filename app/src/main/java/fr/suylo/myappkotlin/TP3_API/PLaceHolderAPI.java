package fr.suylo.myappkotlin.TP3_API;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PLaceHolderAPI {
    @GET("random")
    Call<PlaceHolderPost> getPosts();
}
