package Behavioral.state;

public class TextEditor {
    private WritingState state;

    public TextEditor(WritingState state) {
        this.state = state;
    }

    public void setState(WritingState state) {
        this.state = state;
    }

    public void type(String words) {
        System.out.println(state.writeState(words));
    }
}
