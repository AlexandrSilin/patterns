package Behavioral.state;

public class Example {
    public static void main(String[] args) {
        WritingState upperCase = new UpperCase();
        WritingState lowerCase = new LowerCase();
        TextEditor editor = new TextEditor(upperCase);
        String string = "wOrd";
        editor.type(string);
        editor.setState(lowerCase);
        editor.type(string);
    }
}
