import Models.Recipe;
import Utils.UrlUtil;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.*;

import java.io.IOException;
import java.util.List;

public class GetRecipes {

    public List<Recipe> Recipes;

    private String AccessToken;
    private JSONArray Raw = new JSONArray();

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

        String url = UrlUtil.Generate(Take, Skip);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .followRedirects(false)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer "+AccessToken)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        String bodyStr = response.body().string().substring(0, 1000);

        String startQuery = "\"total\":";
        String endQuery = ",";

        int startIndex = bodyStr.indexOf(startQuery);
        int endIndex = bodyStr.indexOf(endQuery, startIndex + startQuery.length());
        Total = Integer.parseInt(bodyStr.substring(startIndex + startQuery.length(), endIndex));

        return Total;
    }

    //Get a json object of recipes using skip and take params.
    public void Shop() throws IOException {
        int trips = Math.round((Total / Take)+0.51f);
        for(int i = 0; i < trips; i++){
            String url = UrlUtil.Generate(Take, Skip);

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .followRedirects(false)
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "Bearer "+AccessToken)
                    .build();

            Call call = client.newCall(request);
            Response response = call.execute();

            String jsonString = response.body().string();
            JSONObject obj = new JSONObject(jsonString);
            JSONArray tmp = obj.getJSONArray("items");
            Raw.putAll(tmp);

            Skip += Take;
            System.out.println(i + "/" + trips + " - " + tmp.length());
        }

    }

    //Create array of recipe models based on json arrays in Raw
    public void SliceAndDice(){

    }

    public void Cook(){

    }

    public void Serve(){

    }
}
