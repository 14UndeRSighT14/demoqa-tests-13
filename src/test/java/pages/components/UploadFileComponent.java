package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class UploadFileComponent {
    public void uploadFile(String fileName){
        $("#uploadPicture").uploadFromClasspath("img/" + fileName);
    }
}
