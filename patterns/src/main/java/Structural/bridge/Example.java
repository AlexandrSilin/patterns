package Structural.bridge;

import Structural.bridge.pages.About;
import Structural.bridge.pages.Careers;
import Structural.bridge.pages.Projects;
import Structural.bridge.pages.WebPage;
import Structural.bridge.themes.AquaTheme;
import Structural.bridge.themes.DarkTheme;
import Structural.bridge.themes.LightTheme;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<WebPage> pages = new ArrayList<>();
        pages.add(new About(new AquaTheme()));
        pages.add(new Careers(new DarkTheme()));
        pages.add(new Projects(new LightTheme()));
        for (WebPage page : pages) {
            System.out.println(page.getContent() + " with " + page.getTheme().getColor() + " theme");
        }
    }
}
