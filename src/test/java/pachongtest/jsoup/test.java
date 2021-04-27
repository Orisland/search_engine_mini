package pachongtest.jsoup;

import com.alibaba.fastjson.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Base64;


//电影爬取已完成
public class test {
    public static void main(String[] args) throws IOException {
        JSONObject jsonObject = new JSONObject();
        String url = "https://www.ygdy8.com";
        String str = "复仇者联盟";
        String end = java.net.URLEncoder.encode(str,"GB2312");
        Document document = Jsoup.connect("http://s.ygdy8.com/plus/so1.php?typeid=1&keyword="+end).get();
        Elements table = document.getElementsByClass("co_content8").select("ul").select("table");
        for (int i=0; i<table.size(); i++){
            System.out.print(table.get(i).select("a").text()+" ");
            String temp = url+table.get(i).select("a").attr("href");
            System.out.println(temp);
            Document documenttemp = Jsoup.connect(temp).get();
            String message = documenttemp.select("#Zoom > span > p:nth-child(1)").text();
            String cili = documenttemp.select("[href^=magnet:]").attr("href");
            String thunder = documenttemp.select("a[href^=ftp://]").attr("href");
            String ftp = thunder.split("/")[2];
            String chinese = thunder.split("/")[3];
            String pack = "ftp://"+ftp+"/"+ URLEncoder.encode(chinese,"UTF-8");
            thunder = "AA"+pack+"ZZ";
            thunder = "thunder://"+Base64.getEncoder().encodeToString(thunder.getBytes());
            ftp = "ftp://"+ftp+"/"+chinese;
            String clires;
            if (cili == null || cili.equals("") || cili.equals(" ")){
                clires = "空";
            }else {
                clires = cili;
            }
            String[] strings = message.split("◎");
            for (int j=1; j<13; j++){
                System.out.println(strings[j]);
            }
            System.out.println("磁力:"+clires);
            System.out.println("迅雷:"+thunder);
            System.out.println("ftp裸链:"+ftp);
            System.out.println();
        }
    }
}
