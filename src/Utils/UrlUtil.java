package Utils;

public class UrlUtil {
    public static String Generate(int take, int skip){
        String base = "https://www.hellofresh.dk/gw/recipes/recipes/search?country=DK&locale=da-DK&product=classic-box&";

        String url = String.format("%stake=%s&skip=%s", base, take, skip);
        return url;
    }
}
