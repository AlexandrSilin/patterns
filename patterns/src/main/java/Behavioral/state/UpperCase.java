package Behavioral.state;

import java.util.Locale;

public class UpperCase implements WritingState {
    @Override
    public String writeState(String words) {
        return words.toUpperCase(Locale.ROOT);
    }
}
