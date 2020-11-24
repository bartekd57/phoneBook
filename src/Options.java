import java.util.NoSuchElementException;

public enum Options {
    ADD_CONTACT(1, "dodaj nowy wpis"),
    SEARCH_BY_NAME(2, "szukaj po nazwie"),
    SEARCH_BY_TEL(3, "szukaj po numerze telefonu"),
    DELETE(5, "usuń podany wpis"),
    EXIT(6, "wyjdź z programu");

    int id;
    String description;

    Options(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    public static Options optionFromId(int id){
        for (Options value : Options.values()) {
            if(value.getId() == id)
                return value;
        }
        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        return id + " - " + description;
    }
}
