package Behavioral.Iterator;

import java.util.Iterator;

public class StationList implements Iterable<RadioStation> {
    private RadioStation[] stations;
    private int size;
    private int capacity;

    public StationList() {
        this.capacity = 10;
        stations = new RadioStation[capacity];
    }

    public StationList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0");
        }
        this.capacity = capacity;
        stations = new RadioStation[capacity];
    }

    public void addStation(RadioStation radioStation) {
        if (size == capacity) {
            capacity *= 1.5;
            RadioStation[] stations = new RadioStation[capacity];
            System.arraycopy(this.stations, 0, stations, 0, stations.length);
            this.stations = stations;
        }
        stations[size] = radioStation;
        size++;
    }

    public void removeStation(RadioStation station) {
        for (int i = 0; i < stations.length; i++) {
            if (stations[i].equals(station)) {
                size--;
                System.arraycopy(this.stations, i + 1, this.stations, i, capacity - 1);
                break;
            }
        }
    }

    public int count() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(stations[i]).append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<RadioStation> iterator() {
        return new Iterator<>() {
            private RadioStation current;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index != size;
            }

            @Override
            public RadioStation next() {
                current = stations[index];
                index++;
                return current;
            }

            @Override
            public void remove() {
                removeStation(stations[index]);
            }
        };
    }
}
