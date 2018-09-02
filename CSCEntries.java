/**
 * CSCEntries.java  --A program to store raw data using ENUM.
 * @author			  Ratna Lama
 * @version   		  1.0
 * @since     		  6/12/2018
 */

public enum CSCEntries {
    CSC210("", "Intro to Java.", "To Learn Java.", "Comfortable with Objects and Classes.", "Ready for CSC 220."),
    CSC220("", "Data Structures.", "Ready to create complex data structures.", "To create data structures.", ""),
    CSC340("", "= C++ version of CS210 + CSC220 + more", "A CS upper division course.", "Many hours outside of class.", ""),
    BOOK("Book","A set of pages.", "Book: To arrange something on a particular date.", "",""),
    BOOKABLE("Bookable","Can be ordered.", "", "", ""),
    BOOKBINDER("Bookbinder","A person who fastens the pages of books.", "", "",""),
    BOOKCASE("Bookcase","A piece of furniture with shelves.", "", "","");

    private String definition;
    private String description;
    private String noun;
    private String verb;
    private String adjective;

    // Private enum Class Constructor
    private CSCEntries(String definition, String description, String noun, String verb, String adjective) {
        this.definition = definition;
        this.description = description;
        this.noun = noun;
        this.verb = verb;
        this.adjective = adjective;
    } // end Constructor

    @Override
    public String toString() {
        return this.definition + "\n"
                + this.description + "\n"
                + this.noun + "\n"
                + this.verb + "\n"
                + this.adjective + "\n";

    } // end toString


    // Getters and Setters

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

} // end CSC enum Class
