package CLI;

import Manager.PolygonManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class CLI {
    private PolygonManager manager;
    private Scanner scanner;

    public CLI() {
        this.manager = new PolygonManager();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        this.manager.getLines(getURLContent(getURL()));
        this.manager.transformPolygon();
        System.out.println("\nPolygon has been successfully transformed.");
        System.out.println("Perimeter: " + this.manager.getPerimeter());
        this.manager.drawPolygonPicture();
        System.out.println("\nPolygon picture has been successfully drawn, you can find it in output project directory.");
    }

    private URL getURL() {
        System.out.print("\nEnter URL with polygon data: ");
        String urlText = this.scanner.nextLine();

        try {
            return new URL(urlText);
        } catch (MalformedURLException e) {
            throw new InvalidParameterException("Specified url is invalid. " + e.getMessage());
        }
    }

    private Scanner getURLContent(URL url) {
        try {
            return new Scanner(url.openStream());
        } catch (Exception e) {
            throw new InvalidParameterException("Cannot open specified URL. " + e.getMessage());
        }
    }
}