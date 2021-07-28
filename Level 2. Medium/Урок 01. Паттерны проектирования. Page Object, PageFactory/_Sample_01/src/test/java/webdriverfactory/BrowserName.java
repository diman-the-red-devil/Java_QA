package webdriverfactory;

// Имена браузеров
public enum BrowserName {
    CHROME("chrome"),   // Google Chrome
    FIREFOX("firefox"), // Mozilla Firefox
    EDGE("edge");       // Microsoft Edge

    private String browserName; // Имя браузера

    // Приватный конструктор
    private BrowserName(String browserName) {
        this.browserName = browserName;
    }

    // Переопределенный метод
    @Override
    public String toString() {
        return String.valueOf(this.browserName);
    }

    // Возврат константы по строковому значению константы
    public static BrowserName fromString(String browserName) {
        if (browserName != null) {
            for(BrowserName b : BrowserName.values()) {
                if (browserName.equalsIgnoreCase(b.browserName)) {
                    return b;
                }
            }
        }
        return null;
    }

    public String getBrowserName() {
        return this.browserName;
    }
}
