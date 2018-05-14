package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Generuj {
    public String wybranyKraj(String wybranyKraj, String wybranySezon){
        switch (wybranyKraj){
            case "Anglia":{
                String url = "http://pl.futbol24.com/national/England/Premier-League/";
                String sezon = wybranySezon;
                String urlDone = url+sezon;
                return urlDone;
            }
            case "Francja":{
                String url = "http://pl.futbol24.com/national/France/Ligue-1/";
                String sezon = wybranySezon;
                String urlDone = url+sezon;
                return urlDone;
            }
            case "Niemcy":{
                String url = "http://pl.futbol24.com/national/Germany/Bundesliga/";
                String sezon = wybranySezon;
                String urlDone = url+sezon;
                return urlDone;
            }
            case "Polska":{
                String url = "http://pl.futbol24.com/national/Poland/Ekstraklasa/";
                String sezon = wybranySezon;
                String urlDone = url+sezon;
                return urlDone;
            }
            case "Włochy":{
                String url = "http://pl.futbol24.com/national/Italy/Serie-A/";
                String sezon = wybranySezon;
                String urlDone = url+sezon;
                return urlDone;
            }
            case "Hiszpania":{
                String url = "http://pl.futbol24.com/national/Spain/Primera-Division/";
                String sezon = wybranySezon;
                String urlDone = url+sezon;
                return urlDone;
            }
        }
        return "";
    }

    public String generuj(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements table2 = doc.getElementsByClass("table2");
        String tabela = "";
        int i = 0;
        for (Element tabel2: table2){
            Elements druzyny = tabel2.getElementsByClass("team");
            for (Element druzyna: druzyny) {
                tabela += ++i +"    " + druzyna.text() + "\n";
            }
        }
        return tabela;
    }
}
