package uet.dictionary.model;

public class Word {

    /**
     * Attribute.
     */
    private int id;
    private String wordTarget;
    private String wordExplain;
    private String pronounce;
    private String wordType;

    public Word(int id, String wordTarget, String wordExplain, String pronounce, String wordType) {
        this.id = id;
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
        this.pronounce = pronounce;
        this.wordType = wordType;
    }

    public Word() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWordTarget() {
        return wordTarget;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", wordTarget='" + wordTarget + '\'' +
                ", wordExplain='" + wordExplain + '\'' +
                ", pronounce='" + pronounce + '\'' +
                ", wordType='" + wordType + '\'' +
                '}';
    }
}
