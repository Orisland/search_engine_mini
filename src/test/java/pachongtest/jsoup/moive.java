package pachongtest.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class moive {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.ygdy8.com/html/gndy/dyzz/20190730/58908.html").get();
        String elements = document.select("#Zoom > span > p:nth-child(1)").text();
        for (int i=0; i<elements.split("◎").length; i++){
            System.out.println(elements.split("◎")[i]);
        }
    }
}
