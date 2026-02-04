package at.osbeyond.events_scraper;

public class Event {
    String whenDate;
    String whenTime;
    String name;
    String location;
    String desc;
    String source;
    String image;


    public Event(String whenDate, String whenTime, String name, String location, String desc, String source, String image) {
        this.whenDate = whenDate;
        this.whenTime = whenTime;
        this.name = name;
        this.location = location;
        this.desc = desc;
        this.source = source;
        this.image = image;
    }

    public Event(String whenDate, String name, String location, String source) {
        this(whenDate, "", name, location, "", source, "");
    }

    public String getWhenDate() {
        return whenDate;
    }

    public String getWhenTime() {
        return whenTime;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDesc() {
        return desc;
    }

    public String getSource() {
        return source;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Event{" +
                "whenDate='" + whenDate + '\'' +
                ", whenTime='" + whenTime + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", desc='" + desc + '\'' +
                ", source='" + source + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
