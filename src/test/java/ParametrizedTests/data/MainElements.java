package ParametrizedTests.data;

public enum MainElements {
    ADDRESSES ("Адреса"),
    SIGNUP ("Войти"),
    CART ("Корзина");

    private String title;

    MainElements (String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "MainElements{" +
                "title='" + title + '\'' +
                '}';
    }
}
