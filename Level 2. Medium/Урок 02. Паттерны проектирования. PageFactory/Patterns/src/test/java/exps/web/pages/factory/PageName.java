package exps.web.pages.factory;

// Имена страниц (пейдж обджектов)
public enum PageName {
    HOME_PAGE("Страница \"Home\""),
    SIGN_IN_PAGE("Страница \"Sign In\"");

    private String pageName; // Имя страницы (пейдж обджекта)

    // Приватный конструктор
    private PageName(String pageName) {
        this.pageName = pageName;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return String.valueOf(this.pageName);
    }

    // Возврат константы по строковому значению константы
    public static PageName fromString(String pageName) {
        if (pageName != null) {
            for(PageName p : PageName.values()) {
                if (pageName.equalsIgnoreCase(p.pageName)) {
                    return p;
                }
            }
        }
        return null;
    }

    // Получение имени страницы (пейдж обджекта)
    public String getPageName() {
        return this.pageName;
    }
}
