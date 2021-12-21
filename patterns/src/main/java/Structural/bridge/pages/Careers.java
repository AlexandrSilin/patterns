package Structural.bridge.pages;

import Structural.bridge.themes.Theme;

public class Careers extends WebPage {
    public Careers(Theme theme) {
        super(theme);
    }

    @Override
    public String getContent() {
        return "Page 'careers' content";
    }
}
