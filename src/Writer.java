
public class Writer extends Artist{

    private String writingType;
    
    public Writer(String id, String name, String surname, String country, String writingType) {
        super(id ,name, surname, country);
        this.writingType = writingType;
        super.personType = "Writer";
    }

    public String getWritingType() {
        return writingType;
    }

    public void setWritingType(String writingType) {
        this.writingType = writingType;
    }
    
}
