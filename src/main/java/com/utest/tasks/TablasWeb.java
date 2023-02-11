package com.utest.tasks;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.utest.userControls.UserControl;
import com.utest.userModels.UserModel;

public class TablasWeb {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            );
            UserModel userEntity = new UserControl().userGenerator();
            Page page = browser.newPage();
            page.navigate("http://demoqa.com/");
            page.evaluate("window.scrollBy(0, 100)");
            page.locator("//h5[normalize-space()='Elements']").click();
            page.locator("//span[normalize-space()='Web Tables']").click();
            page.locator("//button[@id='addNewRecordButton']").click();
            page.locator("//input[@id='firstName']").type(userEntity.getFirst_name());
            page.locator("//input[@id='lastName']").type(userEntity.getLast_name());
            page.locator("//input[@id='userEmail']").type(userEntity.getEmail());
            page.locator("//input[@id='age']").type(Integer.toString(userEntity.getAge()));
            page.locator("//input[@id='salary']").type(Integer.toString(userEntity.getSalary()));
            page.locator("//input[@id='department']").type(userEntity.getDepartment());
            page.locator("//button[@id='submit']").click();
            page.close();
            browser.close();

            }
        }
    }


