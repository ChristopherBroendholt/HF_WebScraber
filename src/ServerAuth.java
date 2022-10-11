import okhttp3.*;

import java.io.IOException;

public class ServerAuth {
    public static String GetAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .followRedirects(false)
                .build();

        Request request = new Request.Builder()
                .url("https://www.hellofresh.dk/recipes/most-popular-recipes")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        return SplitBody(response.body());
    }

    public static String SplitBody(ResponseBody body) throws IOException {
        String bodyStr = body.string().substring(0, 200000);

        String startQuery = "\"access_token\":\"";
        String endQuery = "\",";

        int startIndex = bodyStr.indexOf(startQuery);
        int endIndex = bodyStr.indexOf(endQuery, startIndex + startQuery.length());

        System.out.println("START: " + startIndex + " END: " + endIndex);

        return bodyStr.substring(startIndex + startQuery.length(), endIndex);
    }
}
