import java.io.Serializable;

public class Tranlation implements Serializable {
    private String word;
    private Language language;
    private Status status;

    public Tranlation(String word, Language language) {
        this.word = word;
        this.language = language;
    }

    public Tranlation(String word, Status status) {
        this.word = word;
        this.status = status;
    }

    public String getWord() {
        return word;
    }

    public Language getLanguage() {
        return language;
    }

    public Status getStatus() {
        return status;
    }
}
