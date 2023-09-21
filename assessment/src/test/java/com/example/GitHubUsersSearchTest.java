package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;




public class GitHubUsersSearchTest {
    

    WebDriver driver; 
    HomePage HPage; 
    UserDetailsPage UDPage;
    UserRepositoriesPage URPage; 

    //#1

    @BeforeTest
        public void HPSETUP(){

            try {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
             WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(); 
            driver.manage().window().maximize();
            driver.get("https://gh-users-search.netlify.app/");
            pause();
    

        } catch (UnreachableBrowserException e) {
            e.printStackTrace();
        }
    }

           

        @Test
        public void GitHubTest() throws InterruptedException{
            //#2
            HPage = new HomePage(driver);
            HPage.SetSearchBar("Mahmudalhakim");
            pause();
            // Addtional Req 1
            HPage.ClearSearchBar();
            pause();
             HPage.SetAGIANSearchBar("Mahmudalhakim");
            pause();
        
            //#3
            HPage.SearchButton();
            pause();


            HPage.userdetails();
            pause();
    
            HPage.Followbutton();
            pause();
        
            //User Details
            UDPage = new UserDetailsPage(driver);
            UDPage.Names();
            UDPage.Biography();
            UDPage.Locs();

            UDPage.userRepo();
            pause();
            UDPage.UserRepositories();
            Thread.sleep(4000);
            
            

            //User Repository
                URPage = new UserRepositoriesPage(driver);
                pause();
                URPage.RepoSearchBar(); //search bar repository page
                pause();
                // URPage.Repository1(); // Click Repo Tab
                // pause();
                // URPage.Description1();  
                // pause();
                URPage.RepositoryValidation();
                pause();
            
            }
    
        
           

                     
        

       

        private void pause() {
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
        }
        
        @AfterTest
        
            public void close(){
                driver.quit();
            }

        }
        

    


