package fr.suylo.myappkotlin.TP3_API;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import fr.suylo.myappkotlin.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView zeTextView;
    private PLaceHolderAPI zePlaceHolderAPI;
    public String content;
    ImageView zeImageView = findViewById(R.id.imageView2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_apiactivity);
        zeTextView = findViewById(R.id.textdefou);
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.chucknorris.io/jokes/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        zePlaceHolderAPI = retrofit.create(PLaceHolderAPI.class);
        Call<PlaceHolderPost> call = zePlaceHolderAPI.getPosts();
        call.enqueue(

                new Callback<PlaceHolderPost>() {
                    @Override
                    public void onResponse(Call<PlaceHolderPost> call, Response<PlaceHolderPost> response) {
                        if (response.isSuccessful()) {
                            PlaceHolderPost p = response.body();
                            content = p.getValue();
                        }
                    }
                    @Override
                    public void onFailure(Call<PlaceHolderPost> call, Throwable t) {
                        zeTextView.setText(t.getMessage());
                    }
                }
        );
        content.replaceAll(" ", "_");
        Picasso.get().load("https://api.memegen.link/images/aag/"+ content + "/e.png").into(zeImageView);
    }
}


