
public class Film {
    
    private String filmId, filmTitle, language, directorsOfFilm, runtime, country, cast;
    public String filmType = "";

    public Film(String filmId, String filmTitle, String language, String directorsOfFilm, String runtime, String country,  String cast) {
        this.filmId = filmId;
        this.filmTitle = filmTitle;
        this.language = language;
        this.directorsOfFilm = directorsOfFilm;
        this.runtime = runtime;
        this.country = country;
        this.cast = cast;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirectorsOfFilm() {
        return directorsOfFilm;
    }

    public void setDirectorsOfFilm(String directorsOfFilm) {
        this.directorsOfFilm = directorsOfFilm;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }
   
}
