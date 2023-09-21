package com.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {

    static  WebDriver driver; 
    String GetName;
    
    //#2
    @FindBy(xpath="//*[@id=\"root\"]/main/section[1]/div/form/div/input")
        WebElement Searchbar;

    
    
    public HomePage (WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
    }
    // Search Bar
    public void SetSearchBar(String Search){
        Searchbar.sendKeys("Mahmudalhakim");
    }    

    // Aditional Requirement 1
    public void ClearSearchBar(){
        Searchbar.clear();
    }   

    // Search Bar
    public void SetAGIANSearchBar(String Search){
        Searchbar.sendKeys("Mahmudalhakim");
    }    



    //#3
    @FindBy(xpath = "//*[@id=\"root\"]/main/section[1]/div/form/div/button")
        WebElement Submit;

        public void SearchButton(){
          Submit.click();

        }

    // #5

    @FindBy(xpath = "//*[@id=\"root\"]/main/section[3]/div/article[1]/header/div/h4")
            WebElement infoname;
            static String LNAME;   
            
    @FindBy(xpath = "//*[@id=\"root\"]/main/section[3]/div/article[1]/p")
            WebElement Bio;
            static String Biogs;

    @FindBy(xpath = "//*[@id=\"root\"]/main/section[3]/div/article[1]/div/p[2]")
            WebElement Location;
            static String Loc;
 


    public void userdetails(){
        System.out.println("Name: " + infoname.getText());
        LNAME = infoname.getText();
        // System.out.println("UserName: " + Username.getText());
        System.out.println("Bio: " + Bio.getText());
        Biogs = Bio.getText();
        // System.out.println("Organization: " + Organization.getText());
        System.out.println("Location: " + Location.getText());
        Loc = Location.getText();
        // System.out.println("Website: " + website.getText());
    }


    @FindBy(xpath = "//*[@id=\"root\"]/main/section[3]/div/article[1]/header/a")
    WebElement Follow;

    public void Followbutton() {
    Follow.click(); 
       
        

    }
}
    