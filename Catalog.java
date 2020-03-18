import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String java_resources, String s) {
        name = java_resources;
        path = s;
    }
    //


    public void add(Document doc){
        documents.add(doc);
    }

    public Document findById(String id){
        return documents.stream().filter(d->d.getId().equals(id)).findFirst().orElse(null);
    }

    public Catalog(String name, String path, List<Document> documents) {
        this.name = name;
        this.path = path;
        this.documents = documents;
    }

    public Catalog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", documents=" + documents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Catalog)) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(getName(), catalog.getName()) &&
                Objects.equals(getPath(), catalog.getPath()) &&
                Objects.equals(getDocuments(), catalog.getDocuments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPath(), getDocuments());
    }
}
