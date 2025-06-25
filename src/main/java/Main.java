import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Test case 1");
        testCase1();

        System.out.println("\nTest case 2");
        testCase2();

        System.out.println("\nTest case 3");
        testCase3();

        System.out.println("\nTest case 4");
        testCase4();

        System.out.println("\nTest case 5");
        testCase5();

        System.out.println("\nTest case 6");
        testCase6();

        System.out.println("\nTest case 7");
        testCase7();
    }

    // Test Case 1: User login and logout validation
    public static void testCase1() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Navigate to the homepage
            driver.get("https://automationexercise.com/");

            // Step 2: Verify the page title
            String pageTitle = driver.getTitle();
            if ("Automation Exercise".equals(pageTitle)) {
                System.out.println("Title validated: '" + pageTitle + "'");
            } else {
                System.out.println("Title does not match. Expected: 'Automation Exercise', Actual: '" + pageTitle + "'");
            }

            // Step 3: Click on the Signup/Login button
            WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Signup / Login')]")));
            signupLoginBtn.click();

            // Step 4: Verify the login section heading
            try {
                WebElement loginText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
                String actualText = loginText.getText();
                if ("Login to your account".equals(actualText)) {
                    System.out.println("Text validated: '" + actualText + "'");
                } else {
                    System.out.println("Text does not match");
                }
            } catch (Exception e) {
                System.out.println("Error validating text: " + e.getMessage());
            }

            // Step 5: Enter registered email
            String email = "test123@mail.com";
            driver.findElement(By.name("email")).sendKeys(email);

            // Step 6: Enter valid password
            String password = "pswd520";
            driver.findElement(By.name("password")).sendKeys(password);

            // Step 7: Click the login button
            driver.findElement(By.xpath("//button[text()='Login']")).click();

            // Step 8: Verify 'Delete Account' button visibility (logged-in state)
            Thread.sleep(2000);
            try {
                driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]"));
                System.out.println("Button 'Delete Account' present");
            } catch (NoSuchElementException e) {
                System.out.println("Button 'Delete Account' not present");
            }

            // Step 9: Click the logout button
            WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
            logoutBtn.click();

            // Step 10: Verify 'Delete Account' button is no longer visible (logged-out state)
            Thread.sleep(2000);
            try {
                driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]"));
                System.out.println("Button 'Delete Account'  present");
            } catch (NoSuchElementException e) {
                System.out.println("Button 'Delete Account' not present");
            }

        } catch (Exception e) {
            System.out.println("Error in Test Case 1: " + e.getMessage());
        } finally {
            // Step 11: Close the browser
            driver.quit();
        }
    }

    // Test Case 2: Invalid login attempt
    public static void testCase2() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Navigate to the homepage
        driver.get("https://automationexercise.com/");

        // Step 2: Confirm the page title
        String pageTitle = driver.getTitle();
        if ("Automation Exercise".equals(pageTitle)) {
            System.out.println("Validated title: '" + pageTitle + "'");
        } else {
            System.out.println("Title does not match, Expected: 'Automation Exercise', Actual: '" + pageTitle + "'");
        }

        // Step 3: Click on the Signup/Login button
        WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Signup / Login')]")));
        signupLoginBtn.click();

        // Step 4: Verify the login section heading
        WebElement loginText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        String actualText = loginText.getText();
        if ("Login to your account".equals(actualText)) {
            System.out.println("Validated text: '" + actualText + "'");
        } else {
            System.out.println("Text does not match");
        }

        // Step 5: Enter invalid email
        driver.findElement(By.name("email")).sendKeys("invalid@email.com");

        // Step 6: Enter incorrect password
        driver.findElement(By.name("password")).sendKeys("wrongpassword");

        // Step 7: Click the login button
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        // Step 8: Verify error message for invalid credentials
        WebElement errorMsg = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        String actualError = errorMsg.getText();
        if ("Your email or password is incorrect!".equals(actualError)) {
            System.out.println("Error message validated: '" + actualError + "'");
        } else {
            System.out.println("Error message does not match");
        }

        // Step 9: Close the browser
        driver.quit();
    }

    // Test Case 3: New user registration
    public static void testCase3() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Navigate to the homepage
            driver.get("https://automationexercise.com/");

            // Step 2: Confirm the page title
            String pageTitle = driver.getTitle();
            if ("Automation Exercise".equals(pageTitle)) {
                System.out.println("Validated title: '" + pageTitle + "'");
            } else {
                System.out.println("Title does not match, Expected: 'Automation Exercise', Actual: '" + pageTitle + "'");
            }

            // Step 3: Click on the Signup/Login button
            WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Signup / Login')]")));
            signupLoginBtn.click();

            // Step 4: Verify the new user signup section
            try {
                WebElement signupText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
                String actualText = signupText.getText();
                if ("New User Signup!".equals(actualText)) {
                    System.out.println("Validated text: '" + actualText + "'");
                } else {
                    System.out.println("Text does not match");
                }
            } catch (Exception e) {
                System.out.println("Error validating text: " + e.getMessage());
            }

            // Step 5: Enter name for new account
            driver.findElement(By.name("name")).sendKeys("Test User");

            // Step 6: Generate and enter unique email
            String uniqueEmail = "testuser" + System.currentTimeMillis() + "@example.com";
            driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(uniqueEmail);

            // Step 7: Click the signup button
            driver.findElement(By.xpath("//button[text()='Signup']")).click();

            // Step 8: Verify account information form appears
            Thread.sleep(2000);
            try {
                WebElement accountInfoText = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
                String actualText = accountInfoText.getText();
                if ("Enter Account Information".equals(actualText)) {
                    System.out.println("Text validated: '" + actualText + "'");
                } else {
                    System.out.println("Text does not match");
                }
            } catch (Exception e) {
                System.out.println("Error validating text: " + e.getMessage());
            }

            // Step 9: Fill out account details and submit
            driver.findElement(By.id("id_gender1")).click();
            driver.findElement(By.id("password")).sendKeys("password123");
            driver.findElement(By.id("days")).sendKeys("5");
            driver.findElement(By.id("months")).sendKeys("February");
            driver.findElement(By.id("years")).sendKeys("2000");
            driver.findElement(By.id("first_name")).sendKeys("Test");
            driver.findElement(By.id("last_name")).sendKeys("User");
            driver.findElement(By.id("address1")).sendKeys("520 imaginary street");
            driver.findElement(By.id("country")).sendKeys("Mexico");
            driver.findElement(By.id("state")).sendKeys("Jalisco");
            driver.findElement(By.id("city")).sendKeys("Guadalajara");
            driver.findElement(By.id("zipcode")).sendKeys("45188");
            driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
            driver.findElement(By.xpath("//button[text()='Create Account']")).click();

            // Step 10: Verify account creation success message
            try {
                WebElement createdText = driver.findElement(By.xpath("//h2[text()='Account Created!']"));
                String actualText = createdText.getText();
                if ("Account Created!".equals(actualText)) {
                    System.out.println("Validated text: '" + actualText + "'");
                } else {
                    System.out.println("Text does not match");
                }
            } catch (Exception e) {
                System.out.println("Error validating text: " + e.getMessage());
            }

            driver.findElement(By.xpath("//a[text()='Continue']")).click();

        } catch (Exception e) {
            System.out.println("Error in test case 3: " + e.getMessage());
        } finally {
            // Step 11: Close the browser
            driver.quit();
        }
    }

    // Test Case 4: Product purchase workflow
    public static void testCase4() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Navigate to the homepage
            driver.get("https://automationexercise.com/");

            // Step 2: Confirm the page title
            String pageTitle = driver.getTitle();
            if ("Automation Exercise".equals(pageTitle)) {
                System.out.println("Title validated: '" + pageTitle + "'");
            } else {
                System.out.println("Title does not match, Expected: 'Automation Exercise', Actual: '" + pageTitle + "'");
            }

            // Step 3: Click on the Products menu
            WebElement productsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Products')]")));
            productsBtn.click();

            // Step 4: Verify the products page loads correctly
            Thread.sleep(2000);
            try {
                WebElement allProductsText = driver.findElement(By.xpath("//h2[text()='All Products']"));
                String actualText = allProductsText.getText();
                if ("All Products".equals(actualText)) {
                    System.out.println("Text validated: '" + actualText + "'");
                } else {
                    System.out.println("Text does not match");
                }
            } catch (Exception e) {
                System.out.println("Error validating text: " + e.getMessage());
            }

            // Step 5: Select Women category
            WebElement womenCategory = driver.findElement(By.xpath("//a[contains(text(),'Women')]"));
            womenCategory.click();

            // Step 6: Choose Dress subcategory
            Thread.sleep(1000);
            WebElement dressCategory = driver.findElement(By.xpath("//a[contains(text(),'Dress')]"));
            dressCategory.click();

            // Step 7: Add first product to cart
            Thread.sleep(2000);
            WebElement addToCartBtn = driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));
            addToCartBtn.click();

            // Step 8: Verify product added confirmation
            Thread.sleep(2000);
            try {
                WebElement addedText = driver.findElement(By.xpath("//h4[contains(text(),'Added!')]"));
                String actualText = addedText.getText();
                if (actualText.contains("Added")) {
                    System.out.println("Product has been successfully added to the cart");
                } else {
                    System.out.println("The product was not added");
                }
            } catch (Exception e) {
                System.out.println("Error validating confirmation: " + e.getMessage());
            }

            // Step 9: Continue shopping
            WebElement continueShoppingBtn = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
            continueShoppingBtn.click();

        } catch (Exception e) {
            System.out.println("Error in test case 4: " + e.getMessage());
        } finally {
            // Step 10: Close the browser
            driver.quit();
        }
    }

    // Test Case 5: Contact form submission
    public static void testCase5() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Navigate to the homepage
            driver.get("https://automationexercise.com/");

            // Step 2: Confirm the page title
            String pageTitle = driver.getTitle();
            if ("Automation Exercise".equals(pageTitle)) {
                System.out.println("Title validated: '" + pageTitle + "'");
            } else {
                System.out.println("Title does not match, Expected: 'Automation Exercise', Actual: '" + pageTitle + "'");
            }

            // Step 3: Click on Contact Us button
            WebElement contactUsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Contact us')]")));
            contactUsBtn.click();

            // Step 4: Verify contact page loads correctly
            Thread.sleep(2000);
            try {
                WebElement contactText = driver.findElement(By.xpath("//h2[text()='Contact Us']"));
                String actualText = contactText.getText();
                if ("Contact Us".equals(actualText)) {
                    System.out.println("Text validated: '" + actualText + "'");
                } else {
                    System.out.println("Text does not match");
                }
            } catch (Exception e) {
                System.out.println("Error validating text: " + e.getMessage());
            }

            // Step 5: Fill out contact form
            driver.findElement(By.name("name")).sendKeys("User");
            driver.findElement(By.name("email")).sendKeys("test@mail.com");
            driver.findElement(By.name("subject")).sendKeys("Test Subject");
            driver.findElement(By.name("message")).sendKeys("Test message");

            // Step 7: Submit the contact form
            driver.findElement(By.name("submit")).click();

            // Step 8: Handle alert if present
            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
                System.out.println("Alert accepted");
            } catch (Exception e) {
                System.out.println("There is no alert");
            }

            // Step 9: Verify success message
            Thread.sleep(2000);
            try {
                WebElement successMsg = driver.findElement(By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]"));
                String actualText = successMsg.getText();
                if (actualText.contains("Success! Your details have been submitted successfully.")) {
                    System.out.println("Message validated");
                } else {
                    System.out.println("Message not found");
                }
            } catch (Exception e) {
                System.out.println("Error validating message: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error in test case 5: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Test Case 6: Test cases page verification
    public static void testCase6() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Navigate to the homepage
            driver.get("https://automationexercise.com/");

            // Step 2: Confirm the page title
            String pageTitle = driver.getTitle();
            if ("Automation Exercise".equals(pageTitle)) {
                System.out.println("Title validated: '" + pageTitle + "'");
            } else {
                System.out.println("Title does not match, Expected: 'Automation Exercise', Actual: '" + pageTitle + "'");
            }

            // Step 3: Click on Test Cases button
            WebElement testCasesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Test Cases')]")));
            testCasesBtn.click();

            // Step 4: Verify test cases page loads correctly
            try {
                WebElement expectedTextElement = driver.findElement(By.xpath("//b[contains(text(),'Below is the list of test Cases')]"));
                String actualText = expectedTextElement.getText();
                if (actualText.contains("Below is the list of test Cases for you to practice the Automation")) {
                    System.out.println("Text validated");
                } else {
                    System.out.println("Text does not match");
                }
            } catch (Exception e) {
                System.out.println("Error validating text: " + e.getMessage());
            }

            // Step 5: List available test cases
            try {
                List<WebElement> testCases = driver.findElements(By.xpath("//div[@class='panel panel-default']"));
                System.out.println("Number of test cases: " + testCases.size());

                System.out.println("\n--- Description of the test cases");
                for (int i = 0; i < Math.min(testCases.size(), 10); i++) {
                    try {
                        WebElement testCase = testCases.get(i);
                        WebElement titleElement = testCase.findElement(By.xpath(".//a[@data-toggle='collapse']"));
                        String title = titleElement.getText();
                        System.out.println((i + 1) + ". " + title);
                    } catch (Exception e) {
                        System.out.println((i + 1) + ". Cannot get title");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error counting the test cases: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error in test case 6: " + e.getMessage());
        } finally {
            // Step 6: Close the browser
            driver.quit();
        }
    }

    // Test Case 7: Cart and checkout verification
    public static void testCase7() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Navigate to the homepage
            driver.get("https://automationexercise.com/");

            // Step 2: Confirm the page title
            String pageTitle = driver.getTitle();
            if ("Automation Exercise".equals(pageTitle)) {
                System.out.println("Title validated: '" + pageTitle + "'");
            } else {
                System.out.println("Title does not match, Expected: 'Automation Exercise', Actual: '" + pageTitle + "'");
            }

            // Step 3: Go to cart page
            WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Cart')]")));
            cartBtn.click();

            // Log in

            // Step 4: Check for checkout button
            Thread.sleep(2000);
            try {
                WebElement checkoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]"));
                System.out.println("Button 'Proceed to checkout'  present");

                // Step 5: Proceed to checkout
                checkoutBtn.click();
                Thread.sleep(2000);

                // Step 6: Verify order review section
                try {
                    WebElement reviewText = driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]"));
                    String actualText = reviewText.getText();
                    if (actualText.contains("Review Your Order")) {
                        System.out.println("Text 'Review Your Order' validated");
                    } else {
                        System.out.println("Text 'Review Your Order' not found");
                    }
                } catch (Exception e) {
                    System.out.println("Cart may be empty");
                }

                // Step 7: Display cart items if present
                try {
                    List<WebElement> cartItems = driver.findElements(By.xpath("//tr[@id]"));
                    if (!cartItems.isEmpty()) {
                        System.out.println("\nCart __________________");
                        for (WebElement item : cartItems) {
                            try {
                                String description = item.findElement(By.xpath(".//td[@class='cart_description']")).getText();
                                String price = item.findElement(By.xpath(".//td[@class='cart_price']")).getText();
                                String quantity = item.findElement(By.xpath(".//td[@class='cart_quantity']")).getText();
                                String total = item.findElement(By.xpath(".//td[@class='cart_total']")).getText();

                                System.out.println("Description: " + description);
                                System.out.println("Price: " + price);
                                System.out.println("Quantity: " + quantity);
                                System.out.println("Total: " + total);
                                System.out.println("___");
                            } catch (Exception e) {
                                System.out.println("Was not able to obtain product details");
                            }
                        }
                    } else {
                        System.out.println("Cart is empty");
                    }
                } catch (Exception e) {
                    System.out.println("Was not able to obtain product details: " + e.getMessage());
                }

                // Step 8: Add comment to order
                try {
                    WebElement commentArea = driver.findElement(By.name("message"));
                    commentArea.sendKeys("Rating the product");
                    System.out.println("Comments");
                } catch (Exception e) {
                    System.out.println("Comment box not usable");
                }

                // Step 9: Initiate order placement
                try {
                    WebElement placeOrderBtn = driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"));
                    placeOrderBtn.click();

                    // Step 10: Verify payment button status
                    try {
                        WebElement payBtn = driver.findElement(By.xpath("//button[contains(text(),'Pay and Confirm Order')]"));
                        if (payBtn.isEnabled()) {
                            System.out.println("Button 'Pay and Confirm Order'  usable");
                        } else {
                            System.out.println("Button 'Pay and Confirm Order'  not usable");
                        }
                    } catch (NoSuchElementException e) {
                        System.out.println("Button 'Pay and Confirm Order' not found");
                    }
                } catch (Exception e) {
                    System.out.println("Could not proceed with place order: " + e.getMessage());
                }

            } catch (NoSuchElementException e) {
                System.out.println("Button 'Proceed to checkout' not  present");
            }

        } catch (Exception e) {
            System.out.println("Error in test case 7: " + e.getMessage());
        } finally {
            // Step 11: Close the browser
            driver.quit();
        }
    }
}