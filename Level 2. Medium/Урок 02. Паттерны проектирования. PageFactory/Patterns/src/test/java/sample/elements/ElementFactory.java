package sample.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PageFactory;

public class ElementFactory {
    // Логгер
    private static Logger logger = LogManager.getLogger(PageFactory.class);

    public static BaseElement getElement(WebDriver driver, ElementName element, By by) {
        switch (element) {
            case BUTTON:
                Button button = new Button(driver, by);
                return button;
            case CHECKBOX:
                CheckBox checkBox = new CheckBox(driver, by);
                return checkBox;
            case LINK:
                Link link = new Link(driver, by);
                return link;
            case RADIOBUTTON:
                RadioButton radioButton = new RadioButton(driver, by);
                return radioButton;
            case TEXTBOX:
                TextBox textBox = new TextBox(driver, by);
                return textBox;
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование элемента");
        }
    }
}
