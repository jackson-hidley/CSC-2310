import java.util.ArrayList;

public class MyDriver
{
    public static void main (String[] args) {
    Post piazza = new ProxyPiazza();

    piazza.postMessage("Jerry");
    piazza.postMessage("John");
    piazza.postMessage("Phillips");
    piazza.postMessage("Joshua");
    piazza.postMessage("Tylor");
    piazza.postMessage("Anonymous");

    }
}