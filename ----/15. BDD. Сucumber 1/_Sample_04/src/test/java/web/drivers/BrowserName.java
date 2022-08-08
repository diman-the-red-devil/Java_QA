package web.drivers;

// Имена браузеров
public enum BrowserName {
    // Имена браузеров
    CHROME("chrome"),   // Google Chrome
    FIREFOX("firefox"), // Mozilla Firefox
    EDGE("edge");       // Microsoft Edge

    private String browserName; // Имя браузера

    // Приватный конструктор
    private BrowserName(String browserName) {
        this.browserName = browserName;
    }

    // Переопределенный метод toString()
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

    // Получение имени браузера
    public String getBrowserName() {
        return this.browserName;
    }
}
