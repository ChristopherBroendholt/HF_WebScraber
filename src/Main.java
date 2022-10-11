import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String accessToken = ServerAuth.GetAccessToken();

        GetRecipes getRecipes = new GetRecipes(accessToken, 100);
        System.out.println(getRecipes.Browse());
        getRecipes.Shop();

        System.out.println(accessToken);

    }
}