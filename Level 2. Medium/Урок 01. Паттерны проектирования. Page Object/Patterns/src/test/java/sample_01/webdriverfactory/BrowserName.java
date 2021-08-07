package sample_01.webdriverfactory;

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
    public static sample_01.webdriverfactory.BrowserName fromString(String browserName) {
        if (browserName != null) {
            for(sample_01.webdriverfactory.BrowserName b : sample_01.webdriverfactory.BrowserName.values()) {
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
