package bridge.pages;

import bridge.themes.Theme;

public class Projects extends WebPage {
    public Projects(Theme theme) {
        super(theme);
    }

    @Override
    public String getContent() {
        return "Page 'project content";
    }
}