package structural.bridge;

public class AboutPage extends Webpage {
    public AboutPage(Theme theme) {
        super(theme);
    }
    @Override
    public String getContent() {
        return "About page in " + theme.applyTheme();
    }
}
