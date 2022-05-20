
public class Documentary extends Film{
    
    private String releaseDate;

    // I did it like that because this constructor takes 8 attributes and writing them in a single line is getting harder to read
    public Documentary(String filmId, 
                       String filmTitle,
                       String language,
                       String directorsOfFilm,
                       String runtime, 
                       String country,
                       String cast,
                       String releaseDate) {
        
        super(filmId, filmTitle, language, directorsOfFilm, runtime, country, cast);
        this.releaseDate = releaseDate;
        super.filmType = "Documentary";
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
}
