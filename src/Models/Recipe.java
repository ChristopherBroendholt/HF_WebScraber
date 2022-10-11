package Models;

public class Recipe {

    public String Id;
    public String Title;
    public String Headline;
    public String Description;

    public Recipe(String id, String title, String headline, String description){
        Id = id;
        Title = title;
        Headline = headline;
        Description = description;
    }

    public String GetFullTitle(){
        return Title + " " + Headline;
    }
}
