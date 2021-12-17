package flyweight;

import java.util.List;

public class TeaMaker {
    public List<Tea> make(List<Tea> available) {
        if (available.size() < 5) {
            for (int i = available.size(); i < 10; i++) {
                available.add(new Tea());
            }
        }
        return available;
    }
}
