package bridge.pages;

import bridge.themes.Theme;

public abstract class WebPage {
    protected Theme theme;

    public WebPage(Theme theme) {
        this.theme = theme;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public abstract String getContent();
}
