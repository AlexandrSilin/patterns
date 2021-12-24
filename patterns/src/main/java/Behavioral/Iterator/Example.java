package Behavioral.Iterator;

import java.util.Iterator;

public class Example {
    public static void main(String[] args) {
        StationList stations = new StationList();
        stations.addStation(new RadioStation(1.2f));
        stations.addStation(new RadioStation(3.2f));
        stations.addStation(new RadioStation(2.2f));
        Iterator<RadioStation> iterator = stations.iterator();
        iterator.remove();
        stations.addStation(new RadioStation(4.2f));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
