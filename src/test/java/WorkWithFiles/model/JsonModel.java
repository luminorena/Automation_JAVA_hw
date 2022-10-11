package WorkWithFiles.model;

import java.util.List;

public class JsonModel {
    public String name;
    public String type;
    public String description;
    public String homepage;
    public String license;
    public List<String> authors;
    public Require require;
    public String minimum_stability;

    public static class Require{
        public String php;
        public String sync;

    }




}
