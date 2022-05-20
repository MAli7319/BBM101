
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// There is not too many methods so that i did not add so many comments.

public class Commands {
    
    // To store the defined objects
    private static LinkedList<Person> definedPeople = new LinkedList<>();
    private static LinkedList<Film> definedFilms = new LinkedList<>();
    
    
    public Commands(){
        
        // Defining person by looking at the input file
        for(int i = 0; i < Main.people_input.size(); i++){
            if(Main.people_input.get(i).split("\t")[0].equals("Actor:")){
                Actor actor = new Actor(Main.people_input.get(i).split("\t")[1], 
                                        Main.people_input.get(i).split("\t")[2], 
                                        Main.people_input.get(i).split("\t")[3], 
                                        Main.people_input.get(i).split("\t")[4], 
                                        Main.people_input.get(i).split("\t")[5]);
                definedPeople.add(actor);
            }
            else if(Main.people_input.get(i).split("\t")[0].equals("ChildActor:")){
                ChildActor childActor = new ChildActor(Main.people_input.get(i).split("\t")[1], 
                                                       Main.people_input.get(i).split("\t")[2], 
                                                       Main.people_input.get(i).split("\t")[3], 
                                                       Main.people_input.get(i).split("\t")[4], 
                                                       Main.people_input.get(i).split("\t")[5]);
                definedPeople.add(childActor);
            }
            else if(Main.people_input.get(i).split("\t")[0].equals("StuntPerformer:")){
                StuntPerformer stuntPerformer = new StuntPerformer(Main.people_input.get(i).split("\t")[1], 
                                                                   Main.people_input.get(i).split("\t")[2], 
                                                                   Main.people_input.get(i).split("\t")[3], 
                                                                   Main.people_input.get(i).split("\t")[4], 
                                                                   Main.people_input.get(i).split("\t")[5],
                                                                   Main.people_input.get(i).split("\t")[6]);
                definedPeople.add(stuntPerformer);
            }
            else if(Main.people_input.get(i).split("\t")[0].equals("Director:")){
                Director director = new Director(Main.people_input.get(i).split("\t")[1], 
                                                 Main.people_input.get(i).split("\t")[2], 
                                                 Main.people_input.get(i).split("\t")[3], 
                                                 Main.people_input.get(i).split("\t")[4], 
                                                 Main.people_input.get(i).split("\t")[5]);
                definedPeople.add(director);
            }
            else if(Main.people_input.get(i).split("\t")[0].equals("Writer:")){
                Writer writer = new Writer(Main.people_input.get(i).split("\t")[1], 
                                           Main.people_input.get(i).split("\t")[2], 
                                           Main.people_input.get(i).split("\t")[3], 
                                           Main.people_input.get(i).split("\t")[4], 
                                           Main.people_input.get(i).split("\t")[5]);
                definedPeople.add(writer);
            }
            else{
                User user = new User(Main.people_input.get(i).split("\t")[1], 
                                     Main.people_input.get(i).split("\t")[2], 
                                     Main.people_input.get(i).split("\t")[3], 
                                     Main.people_input.get(i).split("\t")[4]);
                definedPeople.add(user);
            }
        }
        
        // Defining the film by looking at input file
        for(int i = 0; i < Main.films_input.size(); i++){
            if(Main.films_input.get(i).split("\t")[0].equals("FeatureFilm:")){
                Film featureFilm = new FeatureFilm(Main.films_input.get(i).split("\t")[1], 
                                                          Main.films_input.get(i).split("\t")[2], 
                                                          Main.films_input.get(i).split("\t")[3], 
                                                          Main.films_input.get(i).split("\t")[4], 
                                                          Main.films_input.get(i).split("\t")[5], 
                                                          Main.films_input.get(i).split("\t")[6], 
                                                          Main.films_input.get(i).split("\t")[7], 
                                                          Main.films_input.get(i).split("\t")[8], 
                                                          Main.films_input.get(i).split("\t")[9], 
                                                          Main.films_input.get(i).split("\t")[10], 
                                                          Main.films_input.get(i).split("\t")[11]);
                definedFilms.add(featureFilm);
            }
            else if(Main.films_input.get(i).split("\t")[0].equals("ShortFilm:")){
                if(Integer.valueOf(Main.films_input.get(i).split("\t")[5]) > 40){
                    System.out.println("Runtime of short film cannot be bigger than 40 minutes");
                }
                else{
                Film shortFilm = new ShortFilm(Main.films_input.get(i).split("\t")[1], 
                                                    Main.films_input.get(i).split("\t")[2], 
                                                    Main.films_input.get(i).split("\t")[3], 
                                                    Main.films_input.get(i).split("\t")[4], 
                                                    Main.films_input.get(i).split("\t")[5], 
                                                    Main.films_input.get(i).split("\t")[6], 
                                                    Main.films_input.get(i).split("\t")[7], 
                                                    Main.films_input.get(i).split("\t")[8], 
                                                    Main.films_input.get(i).split("\t")[9], 
                                                    Main.films_input.get(i).split("\t")[10]);
                definedFilms.add(shortFilm);
                }
            }
            else if(Main.films_input.get(i).split("\t")[0].equals("Documentary:")){
                Film documentary = new Documentary(Main.films_input.get(i).split("\t")[1], 
                                                          Main.films_input.get(i).split("\t")[2], 
                                                          Main.films_input.get(i).split("\t")[3], 
                                                          Main.films_input.get(i).split("\t")[4], 
                                                          Main.films_input.get(i).split("\t")[5], 
                                                          Main.films_input.get(i).split("\t")[6], 
                                                          Main.films_input.get(i).split("\t")[7], 
                                                          Main.films_input.get(i).split("\t")[8]);
                definedFilms.add(documentary);
            }
            else{
                Film tvSeries = new TVSeries(Main.films_input.get(i).split("\t")[1], 
                                                 Main.films_input.get(i).split("\t")[2], 
                                                 Main.films_input.get(i).split("\t")[3], 
                                                 Main.films_input.get(i).split("\t")[4], 
                                                 Main.films_input.get(i).split("\t")[5], 
                                                 Main.films_input.get(i).split("\t")[6], 
                                                 Main.films_input.get(i).split("\t")[7], 
                                                 Main.films_input.get(i).split("\t")[8], 
                                                 Main.films_input.get(i).split("\t")[9], 
                                                 Main.films_input.get(i).split("\t")[10],
                                                 Main.films_input.get(i).split("\t")[11],
                                                 Main.films_input.get(i).split("\t")[12],
                                                 Main.films_input.get(i).split("\t")[13]);
                definedFilms.add(tvSeries);
            }
        }
        
        // So many lists and maps in order to store more detailed informations
        ArrayList<String> ratedFilmsAndUsers = new ArrayList<>();
        ArrayList<String> addedFilms = new ArrayList<>();
        ArrayList<String> userFilmAndRating = new ArrayList<>();
        LinkedList<FeatureFilm> featureFilms = new LinkedList<>();
        LinkedList<ShortFilm> shortFilm = new LinkedList<>();
        LinkedList<Documentary> documentary = new LinkedList<>();
        LinkedList<TVSeries> series = new LinkedList<>();
        
        LinkedHashMap<String,LinkedList<String>> userAndRatedFilms = new LinkedHashMap<>();
        LinkedHashMap<String,LinkedHashMap<String, ArrayList<Double>>> userRates = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> numberOfRates = new LinkedHashMap<>();
        LinkedHashMap<String,ArrayList<Double>> filmAndRates = new LinkedHashMap<>();
        ArrayList<Double> list = new ArrayList<>();
        LinkedList<String> list1 = new LinkedList<>();
        
        
        for(int i = 0; i < Main.commands_input.size(); i++){
            
            // Considers the input file which contains the commands 
            if(Main.commands_input.get(i).split("\t")[0].equals("RATE")){
                
                WriteOutputFile.writeOutput(Main.commands_input.get(i) + "\n\n");
                String userId = findUserId(definedPeople, Main.commands_input.get(i).split("\t")[1]);
                String filmId = findFilmId(definedFilms, Main.commands_input.get(i).split("\t")[2]);
                
                if(userId.equals("") || filmId.equals("")){
                    WriteOutputFile.writeOutput("Command Failed\n"
                            + "User ID: " + Main.commands_input.get(i).split("\t")[1] + "\n"
                            + "Film ID: " + Main.commands_input.get(i).split("\t")[2] + "\n\n");  
                }
                else if(ratedFilmsAndUsers.contains(Main.commands_input.get(i).split("\t")[2] + "-" + Main.commands_input.get(i).split("\t")[1])){
                    WriteOutputFile.writeOutput("This film was earlier rated\n\n");
                }
                else if(Integer.valueOf(Main.commands_input.get(i).split("\t")[3]) > 10){
                    System.out.println("Given rate for the films cannot be bigger than 10 points");
                }
                else{
                    WriteOutputFile.writeOutput("Film rated successfully\n"
                            + "Film type: " + findFilmType(definedFilms, filmId) + "\n"
                            + "Film title: " + findFilmTitle(definedFilms, filmId) + "\n\n");
                    
                    
                    list.add(Double.valueOf(Main.commands_input.get(i).split("\t")[3]));
                    filmAndRates.put(filmId, list);
                    userRates.put(userId, filmAndRates);
                    numberOfRates.put(filmId, 1);
                    ratedFilmsAndUsers.add(filmId + "-" + userId);
                    list1.add(filmId);
                    userAndRatedFilms.put(userId, list1);
                    userFilmAndRating.add(userId + "-" + filmId + "-" + Main.commands_input.get(i).split("\t")[3]);
                }
                
                WriteOutputFile.writeOutput("----------------------------------------------------------------------------------------\n");
                
            }
            else if(Main.commands_input.get(i).split("\t")[0].equals("ADD")){
                
                WriteOutputFile.writeOutput(Main.commands_input.get(i) + "\n\n");
                String filmId = findFilmId(definedFilms, Main.commands_input.get(i).split("\t")[2]);
                String[] director = Main.commands_input.get(i).split("\t")[5].split(",");
                String[] writer = Main.commands_input.get(i).split("\t")[11].split(",");
                String[] performer = Main.commands_input.get(i).split("\t")[8].split(",");
                
                
                if(!filmId.equals("") || addedFilms.contains(filmId)
                                      || !ifPersonContains("Director", definedPeople, Arrays.asList(director))
                                      || !ifPersonContains("Writer", definedPeople, Arrays.asList(writer)) 
                                      || !ifPersonContains("Performer", definedPeople, Arrays.asList(performer))){
                    
                    WriteOutputFile.writeOutput("Command Failed\n");  
                }
                else{
                    Film featureFilm = new FeatureFilm(Main.commands_input.get(i).split("\t")[2], 
                                                       Main.commands_input.get(i).split("\t")[3], 
                                                       Main.commands_input.get(i).split("\t")[4],      
                                                       Main.commands_input.get(i).split("\t")[5], 
                                                       Main.commands_input.get(i).split("\t")[6],
                                                       Main.commands_input.get(i).split("\t")[7], 
                                                       Main.commands_input.get(i).split("\t")[8], 
                                                       Main.commands_input.get(i).split("\t")[9], 
                                                       Main.commands_input.get(i).split("\t")[10], 
                                                       Main.commands_input.get(i).split("\t")[11], 
                                                       Main.commands_input.get(i).split("\t")[12]);
                    definedFilms.add(featureFilm);
                    WriteOutputFile.writeOutput("FeatureFilm added successfully\n");
                    addedFilms.add(filmId);
                }
                
                WriteOutputFile.writeOutput("Film ID: " + Main.commands_input.get(i).split("\t")[2] + "\n"
                                          + "Film title: " + Main.commands_input.get(i).split("\t")[3] + "\n\n");
                WriteOutputFile.writeOutput("----------------------------------------------------------------------------------------\n");
                
            }
            else if(Main.commands_input.get(i).split("\t")[0].equals("VIEWFILM")){
                
                WriteOutputFile.writeOutput(Main.commands_input.get(i) + "\n\n");
                for(Film f : definedFilms){
                    if(f.getFilmId().equals(Main.commands_input.get(i).split("\t")[1])){
                        if(f.filmType.equals("FeatureFilm")){
                            featureFilms.add((FeatureFilm) f);
                            LinkedList<String> writers= new LinkedList<>();
                            LinkedList<String> directors = new LinkedList<>();
                            LinkedList<String> stars = new LinkedList<>();
                            for(FeatureFilm ff : featureFilms){
                                if(ff.getWriters().length() == 3){
                                    writers = findPerson(definedPeople, ff.getWriters());
                                }
                                else{
                                    writers = findPersonArray(definedPeople, ff.getWriters());
                                }
                                
                                if(ff.getDirectorsOfFilm().length() == 3){
                                    directors = findPerson(definedPeople, ff.getDirectorsOfFilm());
                                }
                                else{
                                    directors = findPersonArray(definedPeople, ff.getDirectorsOfFilm());
                                }
                                
                                if(ff.getCast().length() == 3){
                                    stars = findPerson(definedPeople, ff.getCast());
                                }
                                else{
                                    stars = findPersonArray(definedPeople, ff.getCast());
                                }
                                
                                WriteOutputFile.writeOutput(ff.getFilmTitle() + " (" + ff.getReleaseDate().substring(ff.getReleaseDate().length() - 4)  + ")\n"
                                                          + ff.getFilmGenre() + "\nWriters: " + String.valueOf(writers).replace("[", "").replace("]", "") + "\n"
                                                          + "Directors: " + String.valueOf(directors).replace("[", "").replace("]", "") + "\n"
                                                          + "Stars: " + String.valueOf(stars).replace("[", "").replace("]", "") + "\nRatings: "
                                                          + "\n\n");
                                break;
                            }
                            break;
                        }
                        else if(f.filmType.equals("ShortFilm")){
                            shortFilm.add((ShortFilm) f);
                            LinkedList<String> writers= new LinkedList<>();
                            LinkedList<String> directors = new LinkedList<>();
                            LinkedList<String> stars = new LinkedList<>();
                            for(ShortFilm sf : shortFilm){
                                if(sf.getWriters().length() == 3){
                                    writers = findPerson(definedPeople, sf.getWriters());
                                }
                                else{
                                    writers = findPersonArray(definedPeople, sf.getWriters());
                                }
                                
                                if(sf.getDirectorsOfFilm().length() == 3){
                                    directors = findPerson(definedPeople, sf.getDirectorsOfFilm());
                                }
                                else{
                                    directors = findPersonArray(definedPeople, sf.getDirectorsOfFilm());
                                }
                                
                                if(sf.getCast().length() == 3){
                                    stars = findPerson(definedPeople, sf.getCast());
                                }
                                else{
                                    stars = findPersonArray(definedPeople, sf.getCast());
                                }
                                
                                
                                WriteOutputFile.writeOutput(sf.getFilmTitle() + " (" + sf.getReleaseDate().substring(sf.getReleaseDate().length() - 4) + ")\n"
                                                          + sf.getFilmGenre() + "\nWriters: " + String.valueOf(writers).replace("[", "").replace("]", "") + "\n"
                                                          + "Directors: " + String.valueOf(directors).replace("[", "").replace("]", "") + "\n"
                                                          + "Stars: " + String.valueOf(stars).replace("[", "").replace("]", "") + "\nRatings: "
                                                          + " from "  + " users\n\n");
                                break;
                            }
                            break;
                        }
                        else if(f.filmType.equals("Documentary")){
                            documentary.add((Documentary) f);
                            LinkedList<String> directors = new LinkedList<>();
                            LinkedList<String> stars = new LinkedList<>();
                            for(Documentary d : documentary){
                                if(d.getDirectorsOfFilm().length() == 3){
                                    directors = findPerson(definedPeople, d.getDirectorsOfFilm());
                                }
                                else{
                                    directors = findPersonArray(definedPeople, d.getDirectorsOfFilm());
                                }
                                
                                if(d.getCast().length() == 3){
                                    stars = findPerson(definedPeople, d.getCast());
                                }
                                else{
                                    stars = findPersonArray(definedPeople, d.getCast());
                                }
                                
                                WriteOutputFile.writeOutput(d.getFilmTitle() + " (" + d.getReleaseDate().substring(d.getReleaseDate().length() - 4) + ")\n"
                                                          + "Directors: " + String.valueOf(directors).replace("[", "").replace("]", "") + "\n"
                                                          + "Stars: " + String.valueOf(stars).replace("[", "").replace("]", "") + "\nRatings: "
                                                          + "\n\n");
                                break;
                            }
                            break;
                        }
                        else{
                            series.add((TVSeries) f);
                            LinkedList<String> writers= new LinkedList<>();
                            LinkedList<String> directors = new LinkedList<>();
                            LinkedList<String> stars = new LinkedList<>();
                            for(TVSeries s : series){
                                if(s.getWriters().length() == 3){
                                    writers = findPerson(definedPeople, s.getWriters());
                                }
                                else{
                                    writers = findPersonArray(definedPeople, s.getWriters());
                                }
                                
                                if(s.getDirectorsOfFilm().length() == 3){
                                    directors = findPerson(definedPeople, s.getDirectorsOfFilm());
                                }
                                else{
                                    directors = findPersonArray(definedPeople, s.getDirectorsOfFilm());
                                }
                                
                                if(s.getCast().length() == 3){
                                    stars = findPerson(definedPeople, s.getCast());
                                }
                                else{
                                    stars = findPersonArray(definedPeople, s.getCast());
                                }
                                
                                
                                WriteOutputFile.writeOutput(s.getFilmTitle() + " (" + s.getStartDate().substring(s.getStartDate().length() - 4) + "-"
                                                          + s.getEndDate().substring(s.getEndDate().length() - 4) + ")\n"
                                                          + s.getNumberOfSeasons() + " seasons, " + s.getNumberOfEpisodes() + " episodes\n"
                                                          + s.getGenre() + "\nWriters: " + String.valueOf(writers).replace("[", "").replace("]", "") + "\nDirectors: "
                                                          + String.valueOf(directors).replace("[", "").replace("]", "") + "\nStars: " 
                                                          + String.valueOf(stars).replace("[", "").replace("]", "") + "\nRatings: "
                                                          + "\n\n");
                                break;
                            }
                            break;
                        }
                    }
                }
                WriteOutputFile.writeOutput("----------------------------------------------------------------------------------------\n");
                
                featureFilms.clear();
                shortFilm.clear();
                documentary.clear();
                series.clear();
                
            }
            
            
            else if(Main.commands_input.get(i).split("\t")[0].equals("REMOVE")){
                
                WriteOutputFile.writeOutput(Main.commands_input.get(i) + "\n\n");
                String userId = findUserId(definedPeople, Main.commands_input.get(i).split("\t")[2]);
                String filmId = findFilmId(definedFilms, Main.commands_input.get(i).split("\t")[3]);
                String filmTitle = findFilmTitle(definedFilms, filmId);
                
                if(userId.equals("") || filmId.equals("") || !ratedFilmsAndUsers.contains(filmId + "-" + userId)){
                    WriteOutputFile.writeOutput("Command Failed\nUser ID: " + Main.commands_input.get(i).split("\t")[2] + "\n"
                                              + "Film ID: " + Main.commands_input.get(i).split("\t")[3] + "\n\n");
                }
                else{
                    WriteOutputFile.writeOutput("Your film rating was removed successfully\n"
                                              + "Film title: " + filmTitle + "\n\n");
                    for(int j = 0; j < ratedFilmsAndUsers.size(); j++){
                        if(ratedFilmsAndUsers.get(j).equals(filmId + "-" + userId)){
                            int newRateCount = numberOfRates.get(filmId) - 1;
                            userAndRatedFilms.remove(userId, filmId);
                            filmAndRates.remove(filmId);
                            userRates.remove(userId, filmAndRates);
                            numberOfRates.put(filmId, newRateCount);
                            ratedFilmsAndUsers.remove(j);
                        }
                    }
                }
                
                WriteOutputFile.writeOutput("----------------------------------------------------------------------------------------\n");
                
            }
            else if(Main.commands_input.get(i).split("\t")[0].equals("EDIT")){
                
                WriteOutputFile.writeOutput(Main.commands_input.get(i) + "\n\n");
                String userId = findUserId(definedPeople, Main.commands_input.get(i).split("\t")[2]);
                String filmId = findFilmId(definedFilms, Main.commands_input.get(i).split("\t")[3]);
                String filmTitle = findFilmTitle(definedFilms, filmId);
                
                if((userId.equals("") || filmId.equals("")) && !ratedFilmsAndUsers.contains(filmId + "-" + userId)){
                    WriteOutputFile.writeOutput("Command Failed\nUser ID: " + Main.commands_input.get(i).split("\t")[2] + "\n"
                                              + "Film ID: " + Main.commands_input.get(i).split("\t")[3] + "\n\n");
                }
                else{
                    WriteOutputFile.writeOutput("New ratings done successfully\n"
                                              + "Film title: " + filmTitle + "\n"
                                              + "Your rating: " + Math.round(Integer.valueOf(Main.commands_input.get(i).split("\t")[4])) + "\n\n");
                    for(int j = 0; j < userFilmAndRating.size(); j++){
                        if(userFilmAndRating.get(j).substring(0,7).equals(userId + "-" + filmId)){
                            userFilmAndRating.remove(j);
                            userFilmAndRating.add(userId + "-" + filmId + "-" + Main.commands_input.get(i).split("\t")[4]);
                            filmAndRates.get(filmId).add(Double.valueOf(Main.commands_input.get(i).split("\t")[4]));
                            userRates.put(userId, filmAndRates);
                        }
                    }
                }
                
                WriteOutputFile.writeOutput("----------------------------------------------------------------------------------------\n");
                
            }
            
            else{
                
                if(Main.commands_input.get(i).split("\t")[1].equals("USER")){
                    
                    WriteOutputFile.writeOutput(Main.commands_input.get(i) + "\n\n");
                    String userId = findUserId(definedPeople, Main.commands_input.get(i).split("\t")[2]);
                    
                    if(userId.equals("")){
                        WriteOutputFile.writeOutput("Command Failed\nUser ID: " + Main.commands_input.get(i).split("\t")[2] + "\n\n");
                    }
                    else if(userAndRatedFilms.get(userId).isEmpty()){
                        WriteOutputFile.writeOutput("There is not any ratings so far\n\n");
                    }
                    else{
                        for(Map.Entry<String, Integer> entry : numberOfRates.entrySet()){
                            
                        }
                        
                    }
                    
                    WriteOutputFile.writeOutput("----------------------------------------------------------------------------------------\n");
                    
                }
                else if(Main.commands_input.get(i).split("\t")[1].equals("FILM")){
                    
                    WriteOutputFile.writeOutput(Main.commands_input.get(i) + "\n\n");
                    
                    int counter = 0;
                    for(Film f : definedFilms){
                        if(f.filmType.equals("TVSeries")){
                            series.add((TVSeries) f);
                            counter++;
                        }
                    }
                    
                    if(counter == 0){
                        WriteOutputFile.writeOutput("No result\n\n");
                    }
                    else{
                        for(TVSeries tvs : series){
                            WriteOutputFile.writeOutput(tvs.getFilmTitle() + " (" + tvs.getStartDate().substring(tvs.getStartDate().length() - 4) 
                                                      + "-" + tvs.getEndDate().substring(tvs.getEndDate().length() - 4) + ")\n"
                                                      + tvs.getNumberOfSeasons() + " seasons and " + tvs.getNumberOfEpisodes() + " episodes\n\n");
                        }
                    }
                    
                    WriteOutputFile.writeOutput("----------------------------------------------------------------------------------------\n");
                    series.clear();
                    
                }
                else if(Main.commands_input.get(i).split("\t")[1].equals("FILMS")){
                    
                    if(Main.commands_input.get(i).split("\t")[3].equals("COUNTRY")){
                        
                        WriteOutputFile.writeOutput(Main.commands_input.get(i) + "\n\n");
                        
                        int counter = 0;
                        for(Film f : definedFilms){
                            if(f.getCountry().equals(Main.commands_input.get(i).split("\t")[4])){
                                counter++;
                            }
                        }
                        
                        if(counter == 0){
                            WriteOutputFile.writeOutput("No result\n\n");
                        }
                        else{
                            for(Film f : definedFilms){
                                if(f.getCountry().equals(Main.commands_input.get(i).split("\t")[4])){
                                    WriteOutputFile.writeOutput("Film title: " + f.getFilmTitle() + "\n"
                                                              + f.getRuntime() + " min\n"
                                                              + "Language: " + f.getLanguage() + "\n\n");
                                }
                            }
                        }
                        
                        WriteOutputFile.writeOutput("----------------------------------------------------------------------------------------\n");
                     
                    }
                    else{
                        
                        
                    }
                    
                }
                else if(Main.commands_input.get(i).split("\t")[1].equals("FEATUREFILMS")){
                    
                    WriteOutputFile.writeOutput(Main.commands_input.get(i) + "\n\n");
                    LinkedList<FeatureFilm> tempFeatureFilms = new LinkedList<>(); 
                    
                    for(Film f : definedFilms){
                            if(f.getClass().equals(FeatureFilm.class)){
                                tempFeatureFilms.add((FeatureFilm) f);
                            }
                        }
                        
                    if(Main.commands_input.get(i).split("\t")[2].equals("BEFORE")){
                        
                        
                        for(int j = 0; j < tempFeatureFilms.size(); j++){
                            if(Integer.parseInt(tempFeatureFilms.get(j).getReleaseDate().substring(tempFeatureFilms.get(j).getReleaseDate().length() - 4)) 
                             >= Integer.parseInt(Main.commands_input.get(i).split("\t")[3])){
                                tempFeatureFilms.remove(tempFeatureFilms.get(j));
                            }
                        }
                        
                       
                        if(tempFeatureFilms.isEmpty()){
                            WriteOutputFile.writeOutput("No result\n\n");
                        }
                        else{
                            for(FeatureFilm ff1 : tempFeatureFilms){
                                WriteOutputFile.writeOutput("Film title: " + ff1.getFilmTitle() + " (" + 
                                                            ff1.getReleaseDate().substring(ff1.getReleaseDate().length() - 4) + ")\n"
                                                          + ff1.getRuntime() + " min\nLanguage: " + ff1.getLanguage() + "\n\n");
                            }
                        }
                        
                        tempFeatureFilms.clear();
                        
                    }
                    else{
                        for(int j = 0; j < tempFeatureFilms.size(); j++){
                            if(Integer.parseInt(tempFeatureFilms.get(j).getReleaseDate().substring(tempFeatureFilms.get(j).getReleaseDate().length() - 4)) 
                             < Integer.parseInt(Main.commands_input.get(i).split("\t")[3])){
                               tempFeatureFilms.remove(tempFeatureFilms.get(j));
                            }
                        }
                        
                        if(tempFeatureFilms.isEmpty()){
                            WriteOutputFile.writeOutput("No result\n\n");
                        }
                        else{
                            for(FeatureFilm ff1 : tempFeatureFilms){
                                WriteOutputFile.writeOutput("Film title: " + ff1.getFilmTitle() + " (" + 
                                                            ff1.getReleaseDate().substring(ff1.getReleaseDate().length() - 4) + ")\n"
                                                          + ff1.getRuntime() + " min\nLanguage: " + ff1.getLanguage() + "\n\n");
                            }
                        }
                        
                        tempFeatureFilms.clear();
                        
                    }
                    
                    WriteOutputFile.writeOutput("----------------------------------------------------------------------------------------\n");
                }
                else{
                    
                    WriteOutputFile.writeOutput(Main.commands_input.get(i) + "\n\nDirectors:\n");
                    LinkedList<Director> directors = new LinkedList<>();
                    
                    for(Person p : definedPeople){
                        if(p.personType.equals("Director") && p.getCountry().equals(Main.commands_input.get(i).split("\t")[3])){
                            directors.add((Director) p);
                        }
                    }
                    
                    if(directors.isEmpty()){
                        WriteOutputFile.writeOutput("No result\n");
                    }
                    else{
                        for(Director d : directors){
                            WriteOutputFile.writeOutput(d.getName() + " " + d.getSurname() + " " + d.getAgent() + "\n");
                        }
                    }
                    
                    WriteOutputFile.writeOutput("\nWriters:\n");
                    LinkedList<Writer> writers = new LinkedList<>();
                    
                    for(Person p : definedPeople){
                        if(p.personType.equals("Writer") && p.getCountry().equals(Main.commands_input.get(i).split("\t")[3])){
                            writers.add((Writer) p);
                        }
                    }
                    
                    if(writers.isEmpty()){
                        WriteOutputFile.writeOutput("No result\n");
                    }
                    else{
                        for(Writer w : writers){
                            WriteOutputFile.writeOutput(w.getName() + " " + w.getSurname() + " " + w.getWritingType() + "\n");
                        }
                    }
                    
                    WriteOutputFile.writeOutput("\nActors:\n");
                    LinkedList<Actor> actors = new LinkedList<>();
                    
                    for(Person p : definedPeople){
                        if(p.subPersonType.equals("Actor") && p.getCountry().equals(Main.commands_input.get(i).split("\t")[3])){
                            actors.add((Actor) p);
                        }
                    }
                    
                    if(actors.isEmpty()){
                        WriteOutputFile.writeOutput("No result\n");
                    }
                    else{
                        for(Actor a : actors){
                            WriteOutputFile.writeOutput(a.getName() + " " + a.getSurname() + " " + a.getHeight() + " cm\n");
                        }
                    }
                    
                    WriteOutputFile.writeOutput("\nChildActors:\n");
                    LinkedList<ChildActor> childActors = new LinkedList<>();
                    
                    for(Person p : definedPeople){
                        if(p.subPersonType.equals("ChildActor") && p.getCountry().equals(Main.commands_input.get(i).split("\t")[3])){
                            childActors.add((ChildActor) p);
                        }
                    }
                    
                    if(childActors.isEmpty()){
                        WriteOutputFile.writeOutput("No result\n");
                    }
                    else{
                        for(ChildActor c : childActors){
                            WriteOutputFile.writeOutput(c.getName() + " " + c.getSurname() + " " + c.getAge() + "\n");
                        }
                    }
                    
                    WriteOutputFile.writeOutput("\nStuntPerformers:\n");
                    LinkedList<StuntPerformer> stuntPerformers = new LinkedList<>();
                    
                    for(Person p : definedPeople){
                        if(p.subPersonType.equals("StuntPerformer") && p.getCountry().equals(Main.commands_input.get(i).split("\t")[3])){
                            stuntPerformers.add((StuntPerformer) p);
                        }
                    }
                    
                    if(stuntPerformers.isEmpty()){
                        WriteOutputFile.writeOutput("No result\n");
                    }
                    else{
                        for(StuntPerformer s : stuntPerformers){
                            WriteOutputFile.writeOutput(s.getName() + " " + s.getSurname() + " " + s.getHeight() + " cm\n");
                        }
                    }
                    
                    WriteOutputFile.writeOutput("----------------------------------------------------------------------------------------\n");
                    
                    directors.clear();
                    writers.clear();
                    actors.clear();
                    childActors.clear();
                    stuntPerformers.clear();
                }
            }
            
        }
        
    }
    
    // This method finds the person in order to write the output correctly which is defined before
    // Considers the id number of him/her and returns the actual name and surname
    public LinkedList<String> findPerson(LinkedList<Person> list, String idList){
        
        String name = "";
        String surname = "";
        LinkedList<String> persons = new LinkedList<>();
        
        for(Person p : list){
            if(p.getId().equals(idList)){
                name = p.getName();
                surname = p.getSurname();
                persons.add(name + " " + surname);
                break;
            }
        }
        return persons;
        
    }
    
    // This method finds the people in order to write the output correctly which is defined before
    // Considers the id number of him/her and storing them in linked list and at the end it returns this linked list
    public LinkedList<String> findPersonArray(LinkedList<Person> list, String idList){
        
        String[] array = idList.split(",");
        String personName = "";
        String personSurname = "";
        LinkedList<String> persons = new LinkedList<>();
        
        for(int i = 0; i < array.length; i++){
            for(Person p : list){
                if(p.getId().equals(array[i])){
                    personName = p.getName();
                    personSurname = p.getSurname();
                    persons.add(personName + " " + personSurname);
                }
            }
        }
        
        return persons;
    }
    
    // This method looks for the list and searchs for the person by looking at the type
    // Returns the boolean which determines the answer: yes or no
    public boolean ifPersonContains(String type, LinkedList<Person> list, List<String> input){
        
        for(Person p : list){
            if(p.personType.equals(type) && input.contains(p.getId())){
                return true;
            }
        }
        return false;
    }
    
    // This method searchs the list which contains Person object
    // If the object's id is equal to desired id, return this id
    public String findUserId(LinkedList<Person> list, String inputId){
        
        String id = "";
        for(Person p : list){
            if(p.getClass().equals(User.class) && p.getId().equals(inputId)){
                id = p.getId();
            }
        }
        return id;
    }
    
    // This method searchs the list which contains Film object
    // If the object's id is equal to desired id, return this id
    public String findFilmId(LinkedList<Film> list, String inputId){
        
        String id = "";
        for(Film f : list){
            if(f.getFilmId().equals(inputId)){
                id = f.getFilmId();
            }
        }
        return id;
    }
    
    // This method searchs the list which contains Film object
    // If the object's id is equal to desired id, return this id
    public String findFilmType(LinkedList<Film> list, String inputId){
        
        String filmType = "";
        for(Film f : list){
            if(f.getFilmId().equals(inputId)){
                filmType = f.filmType;
            }
        }
        return filmType;
    }
    
    // This method searchs the list which contains Film object
    // If the object's title is equal to desired title, return this title
    public String findFilmTitle(LinkedList<Film> list, String inputID){
        
        String filmTitle = "";
        for(Film f : list){
            if(f.getFilmId().equals(inputID)){
                filmTitle = f.getFilmTitle();
            }
        }
        return filmTitle;
    }

    // Getter and setters
    public static LinkedList<Person> getDefinedPeople() {
        return definedPeople;
    }

    public static void setDefinedPeople(LinkedList<Person> definedPeople) {
        Commands.definedPeople = definedPeople;
    }

    public static LinkedList<Film> getDefinedFilms() {
        return definedFilms;
    }

    public static void setDefinedFilms(LinkedList<Film> definedFilms) {
        Commands.definedFilms = definedFilms;
    }

}
