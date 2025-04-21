package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    String firstName = "Ivan";
    String lastName = "Petrov";
    String email = "ivanpetrov@gmail.com";
    String gender = "Male";
    String phoneNumber = "9039998585";
    String year = "1990";
    String month = "September";
    String day = "09";
    String subject = "Maths";
    String hobby1 = "Sports";
    String hobby2 = "Music";
    String uploadedPicture = "png-avatar.png";
    String address = "Random street, 103";
    String state = "Rajasthan";
    String city = "Jaiselmer";


    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillStudentRegistrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("input[value=" + gender + "]").ancestor(".custom-radio").click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").type(subject);
        $("#react-select-2-option-0").click();
        $("#hobbiesWrapper").$(byText(hobby1)).ancestor(".custom-checkbox").click();
        $("#hobbiesWrapper").$(byText(hobby2)).ancestor(".custom-checkbox").click();
        $("#uploadPicture").uploadFromClasspath(uploadedPicture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();


        $(byTagAndText("td", "Student Name")).sibling(0).shouldHave(exactText(firstName + " " + lastName));
        $(byTagAndText("td", "Student Email")).sibling(0).shouldHave(exactText(email));
        $(byTagAndText("td", "Gender")).sibling(0).shouldHave(exactText(gender));
        $(byTagAndText("td", "Mobile")).sibling(0).shouldHave(exactText(phoneNumber));
        $(byTagAndText("td", "Date of Birth")).sibling(0).shouldHave(exactText(day + " " + month + "," + year));
        $(byTagAndText("td", "Subjects")).sibling(0).shouldHave(exactText(subject));
        $(byTagAndText("td", "Hobbies")).sibling(0).shouldHave(exactText(hobby1 + ", " + hobby2));
        $(byTagAndText("td", "Picture")).sibling(0).shouldHave(exactText(uploadedPicture));
        $(byTagAndText("td", "Address")).sibling(0).shouldHave(exactText(address));
        $(byTagAndText("td", "State and City")).sibling(0).shouldHave(exactText(state + " " + city));
    }
}
