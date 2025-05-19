package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.time.LocalDate;

public class PracticeFormTests extends BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

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
    LocalDate today = LocalDate.now();
    String todayStr = today.getDayOfMonth() + " " + today.getMonth() + "," + today.getYear();

    @Test
    void fillStudentRegistrationFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .selectGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(year, month, day)
                .selectSubject(subject)
                .selectHobby(hobby1)
                .selectHobby(hobby2)
                .uploadPicture(uploadedPicture)
                .setCurrentAddress(address)
                .selectState(state)
                .selectCity(city)
                .clickSubmitButton()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby1 + ", " + hobby2)
                .checkResult("Picture", uploadedPicture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void fillMinimumDataTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .selectGender(gender)
                .setUserNumber(phoneNumber)
                .clickSubmitButton()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", todayStr);
    }

    @Test
    void fillWrongDataTest() {
        practiceFormPage.openPage()
                .clickSubmitButton()
                .checkBordersColorInvalidInput();
    }
}
