package Structural.bridge.pages;

import Structural.bridge.themes.Theme;

public class About extends WebPage {
    public About(Theme theme) {
        super(theme);
    }

    @Override
    public String getContent() {
        return "Page 'about' content";
    }
}
