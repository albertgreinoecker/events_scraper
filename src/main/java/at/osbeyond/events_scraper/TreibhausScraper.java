package at.osbeyond.events_scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreibhausScraper {

    public List<Event> get() throws IOException {
        ArrayList<Event> events = new ArrayList<>();
        Document doc = Jsoup.connect("https://treibhaus.at/programm")
                .userAgent("Mozilla/5.0")
                .timeout(10_000)
                .get();

        System.out.println(doc.title());

        Elements res1 = doc.select("div.event-date");
        Elements res2 = doc.select("span[itemprop=name]");

        int count = Math.min(res1.size(), res2.size());

        for (int i = 0; i < count; i++) {
            System.out.println("--------------");

            Element eventDate = res1.get(i);

            // span[itemprop=startDate]
            Element startDateEl = eventDate.selectFirst("span[itemprop=startDate]");
            String startDate = startDateEl != null ? startDateEl.text() : "";

            // link
            Element linkEl = eventDate.selectFirst("a");
            String link = linkEl != null ? linkEl.absUrl("href") : "";

            // name
            String name = res2.get(i).text();

            System.out.println(startDate);
            System.out.println(link);
            System.out.println(name);
            Event e = new Event(startDate, "", name, "Treibhaus", "", link, "");
            events.add(e);
        }
        return events;

    }
}
