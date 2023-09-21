package com.example;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserDetailsPage {

        static WebDriver driver = HomePage.driver;
        HomePage HPage;
        static WebElement RepoFromlist;
        static WebElement DescFromList;
        static ArrayList<String> Repocontainer = new ArrayList<>();

        public UserDetailsPage (WebDriver driver){
                this.driver = driver;
                PageFactory.initElements(driver, this);

        }

        //Name        
        @FindBy(xpath = "/html/body/div[1]/div[4]/main/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/h1/span[1]")
                WebElement CompleteName;


        public void Names(){
                HPage = new HomePage(driver);
                
                String FName = CompleteName.getText();
        
                try{
                        assert FName.contains(HPage.LNAME) : " Name in HomePage & USer Details are not match";
                        System.out.println("Name in HomePage & USer Details are  match");
                }catch(AssertionError e){

                        System.out.println(e.getMessage());
                }
        }

        //BIO
        @FindBy(xpath = "/html/body/div[1]/div[4]/main/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/div")
                WebElement CompleteBio;


        public void Biography(){
                HPage = new HomePage(driver);
                
                String Bios = CompleteBio.getText();
        
                try{
                        assert Bios.contains(HPage.Biogs) : "Biography in HomePage & USer Details are not match";
                        System.out.println("Biography in HomePage & USer Details are  match / ");
                }catch(AssertionError e){

                        System.out.println(e.getMessage());
                }
        }
        //Loction
        @FindBy(xpath = "/html/body/div[1]/div[4]/main/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/ul/li[2]/span")
                WebElement CompleteLocation;


        public void Locs(){
                HPage = new HomePage(driver);
                
                String locationss = CompleteLocation.getText();
        
                try{
                        assert locationss.contains(HPage.Loc) : "Location in HomePage & USer Details are not match";
                        System.out.println("Location in HomePage & USer Details are  match");
                }catch(AssertionError e){

                        System.out.println(e.getMessage());
                }      
        }


         //#6 - overview
        

        @FindBy(xpath = "//*[@id=\"user-profile-frame\"]/div/div[1]/div/ol/li[2]/div/div/div/a")        
                WebElement Desc1;
                static String RepoDesc1;


        public void userRepo(){

                try {
            WebElement divIdentifier = driver.findElement(By.className("js-pinned-items-reorder-container"));
            List<WebElement> liElements = divIdentifier.findElements(By.className("repo"));
            List<WebElement> liDescription = divIdentifier.findElements(By.className("pinned-item-desc"));

            int listcount = Math.min(liElements.size(), liDescription.size());
            for (int i = 0; i < listcount; i++) {
                RepoFromlist = liElements.get(i);
                DescFromList = liDescription.get(i);
                System.out.println("Reposition: " + RepoFromlist.getText());
                System.out.println("Decription: " + DescFromList.getText() + "\n");
                Repocontainer.add(RepoFromlist.getText());
            }

        } catch (

        Exception e) {
            System.out.println("Object not found" + e.getMessage());
        }
    }
              
                // WebElement OverviewRepo = driver.findElement(By.className("text-bold flex-auto min-width-0"));
                // WebElement Repooverview = OverviewRepo.findElement(By.className("repo"));

                // System.out.println(Repooverview.getText());


        public void descRepo(){     

                WebElement OverviewDesc1 = driver.findElement(By.className("pinned-item-desc color-fg-muted text-small d-block mt-2 mb-3"));
                WebElement Descoverview1 = OverviewDesc1.findElement(By.className("repo"));

                System.out.println(Descoverview1.getText());
        }       
        
         // Click Repor page
        @FindBy(xpath = "/html/body/div[1]/div[4]/main/div[1]/div/div/div[2]/div/nav/a[2]")
        WebElement Repo;

        public void UserRepositories(){
        Repo.click();
}
       
}



     



   
               
       

     
                

      



