# OpenCart Selenium Automation Framework

This project is a Selenium-based automation framework built using Java, Maven, and TestNG.  
It automates an end-to-end user journey on the OpenCart application.

---

## 🚀 Tech Stack
- Java 21
- Selenium WebDriver
- TestNG
- Maven

---

## 🧱 Framework Design
The framework follows the Page Object Model (POM) design pattern.

### Structure
- `baseopc` → Driver setup and base classes
- `pagesopc` → Page Object classes
- `utilitiesopc` → Config handling and reusable utilities
- `testsopc` → Test execution classes
- `resources` → Config and locator properties

---

## 🧪 Test Flow Covered
- Login
- Select Mac product
- Add to cart
- Checkout
- Enter shipping details
- Confirm order
- Logout

---

## ▶️ How to Run Tests

```bash
mvn test
