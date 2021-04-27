package pachongtest.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("http://www.xbiquge.la/1/1710/1298266.html").get();
        System.out.println(document.getElementById("content"));
    }
}
