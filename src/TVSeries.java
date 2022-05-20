
public class TVSeries extends Film{
    
    private String genre, writers, startDate, endDate, numberOfSeasons, numberOfEpisodes;

    // I did it like that because this constructor takes 13 attributes and writing them in a single line is getting harder to read
    public TVSeries(String filmId, 
                    String filmTitle,
                    String language,
                    String directorsOfFilm,
                    String runtime, 
                    String country,
                    String cast,
                    String genre, 
                    String writers, 
                    String startDate, 
                    String endDate, 
                    String numberOfSeasons, 
                    String numberOfEpisodes) {
        super(filmId, filmTitle, language, directorsOfFilm, runtime, country, cast);
        this.genre = genre;
        this.writers = writers;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
        super.filmType = "TVSeries";
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }
    
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(String numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public String getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(String numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

}
