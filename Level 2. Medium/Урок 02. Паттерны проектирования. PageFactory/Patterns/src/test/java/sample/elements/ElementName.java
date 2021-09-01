package sample.elements;

import pages.PageName;

// Имена элементов
public enum ElementName {
    BUTTON("Кнопка"),
    CHECKBOX("Флажок"),
    LINK("Ссылка"),
    RADIOBUTTON("Переключатель"),
    TEXTBOX("Текстовое поле");

    private String elementName; // Имя элемента

    // Приватный конструктор
    private ElementName(String elementName) {
        this.elementName = elementName;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return String.valueOf(this.elementName);
    }

    // Возврат константы по строковому значению константы
    public static ElementName fromString(String elementName) {
        if (elementName != null) {
            for(ElementName e : ElementName.values()) {
                if (elementName.equalsIgnoreCase(e.elementName)) {
                    return e;
                }
            }
        }
        return null;
    }

    // Получение имени элемента
    public String getElementName() {
        return this.elementName;
    }
}
