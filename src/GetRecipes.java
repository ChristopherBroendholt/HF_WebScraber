import Models.Recipe;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

public class GetRecipes {

    public List<Recipe> Recipes;

    private String AccessToken;
    private String Raw;

    private int Skip = 0;
    private int Take = 250;
    private int Total = 0;

    public GetRecipes(String accessToken, int take){
        AccessToken = accessToken;
        Take = take;
    }

    public GetRecipes(String accessToken){
        AccessToken = accessToken;
    }

    //Gets the total amount of recipes
    public int Browse() throws IOException {

        String url = "";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .followRedirects(false)
                .build();

        Request request = new Request.Builder()
                .url("https://www.hellofresh.dk/gw/recipes/recipes/search?country=DK&locale=da-DK&product=classic-box&skip=0&take=250")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        return Total;
    }

    //Get a json object of recipes using skip and take params.
    public void Shop(){

    }

    public void DiceAndSlice(){

    }

    public void Cook(){

    }

    public void Serve(){

    }
}
