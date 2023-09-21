package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRepositoriesPage {
    
        WebDriver driver = UserDetailsPage.driver;
        UserDetailsPage UDPage;

         public UserRepositoriesPage (WebDriver driver){
                this.driver = driver;
                PageFactory.initElements(driver, this);

        }
        

          // Repository Search
          @FindBy(name = "q")
          WebElement Reposearch;
          
          public void RepoSearchBar(){
                  Reposearch.sendKeys("JavaScript-2");
  }  

    //Repository Page
    @FindBy(css =  "#user-repositories-list > ul > li > div.col-10.col-lg-9.d-inline-block > div.d-inline-block.mb-1 > h3 > a")
                WebElement Repopage1;


        public void Repository1(){
                UDPage = new UserDetailsPage(driver);
                
                String repo1 = "test";
                
                System.out.println(Repopage1.getText());
                
        }
        
     @FindBy(css = "#user-repositories-list > ul > li:nth-child(3) > div.col-10.col-lg-9.d-inline-block > div:nth-child(2) > p")
                WebElement Desc1;

        public void Description1(){
                UDPage = new UserDetailsPage(driver);
                System.out.println(Desc1.getText());

           
                try{
                        
                        assert Desc1.isDisplayed() : "No Description Displayed";
                        // System.out.println("Description Displayed Correctly");
                }catch(AssertionError e){

                        System.out.println(e.getMessage());
                }      
                
        }


        public void RepositoryValidation(){

                WebElement Compile = driver.findElement(By.cssSelector("#user-repositories-list > ul > li:nth-child(3) > div.col-10.col-lg-9.d-inline-block > div.d-inline-block.mb-1 > h3 > a"));
                
                try{

                        assert UserDetailsPage.Repocontainer.contains(Compile.getText()) : "Reposition Not Match";
                        System.out.println("Reposition Match");

                }catch(AssertionError e){ 
                        System.out.print(Compile.getText());
                        System.out.println(e.getMessage());
                }      

                }
        }



