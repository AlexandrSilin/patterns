package Behavioral.state;

import java.util.Locale;

public class LowerCase implements WritingState {
    @Override
    public String writeState(String words) {
        return words.toLowerCase(Locale.ROOT);
    }
}
