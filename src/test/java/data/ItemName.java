package data;

public enum ItemName {
    DRESS ("платье"),
    TROUSERS ("брюки");

   private String title;

    ItemName (String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ItemName{" +
                "title='" + title + '\'' +
                '}';
    }
}
