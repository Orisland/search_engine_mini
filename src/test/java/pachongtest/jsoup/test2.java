package pachongtest.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Base64;


public class test2 {
    public static void main(String[] args) throws IOException {
        String url = "https://www.ygdy8.com/html/gndy/dyzz/20190730/58908.html";
        Document document = Jsoup.connect(url).get();
        String cili = document.select("a[href^=ftp://]").attr("href");
        String ftp = cili.split("/")[2];
        String chinese = cili.split("/")[3];
        System.out.println(chinese);
        System.out.println(ftp);
        System.out.println(cili);
        String pack = "ftp://"+ftp+"/"+ URLEncoder.encode(chinese,"UTF-8");
        cili = "AA"+pack+"ZZ";
        cili = Base64.getEncoder().encodeToString(cili.getBytes());
        System.out.println("thunder://"+cili);
    }
}
