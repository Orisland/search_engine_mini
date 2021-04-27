package pachongtest.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

//book爬取
public class test3 {
    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("http://www.xbiquge.la/modules/article/waps.php");
        connect.data("searchkey","斗罗大陆");
        Document document = connect.get();
        System.out.println(document.select("#checkform > table > tbody"));
    }
}
