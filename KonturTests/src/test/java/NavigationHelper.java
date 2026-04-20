public class NavigationHelper extends HelperBase {
    private String baseUrl;

    public NavigationHelper(ApplicationManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public void openLoginPage() {
        driver.get("https://staff-testing.testkontur.ru");
    }

    public void openNewsPage() {
        driver.get("https://staff-testing.testkontur.ru/news");
    }

    public void openCommunitiesPage() {
        driver.get("https://staff-testing.testkontur.ru/communities");
    }
}
