package Behavioral.memento;

public class Editor {
    private String content = "";

    public void type(String words) {
        this.content += ' ' + words;
    }

    public EditorMemento save() {
        return new EditorMemento(this.content);
    }

    public void restore(EditorMemento memento) {
        this.content = memento.getContent();
    }

    @Override
    public String toString() {
        return "Editor{" +
                "content='" + content.trim() + '\'' +
                '}';
    }
}
