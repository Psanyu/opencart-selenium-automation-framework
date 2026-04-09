# OpenCart Selenium Automation Framework

A Selenium automation framework for OpenCart built using Java, Maven, and TestNG.

## Tech Stack
- Java 21
- Selenium WebDriver
- TestNG
- Maven

## Framework Structure
- `baseopc` - base setup and driver initialization
- `pagesopc` - page object classes
- `utilitiesopc` - config and reusable utilities
- `testsopc` - test execution classes
- `src/test/resources` - config and element properties

## Covered Flow
- Login
- Select Mac product
- Add to cart
- Checkout
- Shipping
- Order confirmation
- Logout

## Run
```bash
mvn test
