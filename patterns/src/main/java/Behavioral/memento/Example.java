package Behavioral.memento;

public class Example {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.type("first");
        editor.type("second");
        EditorMemento memento = editor.save();
        editor.type("third");
        System.out.println(editor);
        editor.restore(memento);
        System.out.println(editor);
    }
}
