import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;


public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        /*try(var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog); */
        try (FileOutputStream fos = new FileOutputStream(catalog.getPath())){
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException, FileNotFoundException, ClassNotFoundException {

        try(FileInputStream fis = new FileInputStream(path)){
            ObjectInputStream in = new ObjectInputStream(fis);
            Catalog c = (Catalog) in.readObject();
            return c;
         //   fis.close();
        }
    }
    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        //...browse or open, depending of the location type web or local stuff
        File f = new File(doc.getLocation());
        if(doc.getLocation().contains("www")){ //verificam daca e website
            URI uri = new URI(doc.getLocation());
            desktop.browse(uri);
        }
        else desktop.open(f); //altfel deschidem local
    }
}
