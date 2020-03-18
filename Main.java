import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException, URISyntaxException, ClassNotFoundException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources", "/home/codrin/IdeaProjects/Lab5_compulsory/src/demotext.ser");
        Document doc;
        doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/exceptions_slide_en.pdf");
        doc.addTag("type","Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException, ClassNotFoundException, URISyntaxException {
        Catalog catalog = CatalogUtil.load("/home/codrin/IdeaProjects/Lab5_compulsory/src/demotext.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }
}
