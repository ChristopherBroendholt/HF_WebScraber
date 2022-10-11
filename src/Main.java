import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String accessToken = ServerAuth.GetAccessToken();

        GetRecipes getRecipes = new GetRecipes(accessToken, 10);
        getRecipes.Shop();

        System.out.println(accessToken);
    }
}