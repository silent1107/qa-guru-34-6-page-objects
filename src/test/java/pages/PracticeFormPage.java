package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailUnput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectContainer = $("#subjectsContainer"),
            subjectInput = $("#subjectsInput"),
            subjectList = $(".subjects-auto-complete__menu-list"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateContainer = $("#state"),
            cityContainer = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    String redColorRGBCode = "rgb(220, 53, 69)";

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmailUnput.setValue(value);
        return this;
    }

    public PracticeFormPage selectGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String year, String month, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }


    public PracticeFormPage selectSubject(String value) {
        subjectContainer.click();
        subjectInput.setValue(value);
        subjectList.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage selectHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public PracticeFormPage selectState(String value) {
        stateContainer.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage selectCity(String value) {
        cityContainer.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);
        return this;
    }

    public void checkBordersColorInvalidInput() {
        checkBorderColor(firstNameInput, redColorRGBCode);
        checkBorderColor(lastNameInput, redColorRGBCode);
        checkBorderColor(userNumberInput, redColorRGBCode);
    }

    private void checkBorderColor(SelenideElement element, String value) {
        element.shouldHave(cssValue("border-color", value));

    }
}
