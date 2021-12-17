package bridge;

import bridge.pages.About;
import bridge.pages.Careers;
import bridge.pages.Projects;
import bridge.pages.WebPage;
import bridge.themes.AquaTheme;
import bridge.themes.DarkTheme;
import bridge.themes.LightTheme;

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
