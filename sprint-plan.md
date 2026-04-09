# Sprint Plan - OpenCart Selenium Automation Framework

## Sprint 1 - Core Framework Setup
Delivered a working Selenium automation framework for a core OpenCart purchase journey.

### Scope
- Maven project setup
- Java 21 project alignment
- Selenium WebDriver + TestNG integration
- Page Object Model structure
- Config-driven test data and locators
- Automated E2E flow:
  - Login
  - Select Mac product
  - Add to cart
  - Checkout
  - Shipping
  - Order confirmation
  - Logout

---

## Sprint 2 - Stabilization and Reusability
Focus on reducing flaky execution and improving maintainability.

### Planned Enhancements
- Replace Thread.sleep() with WebDriverWait
- Improve synchronization handling
- Refactor repeated code into reusable utilities
- Clean package/file placement
- Improve naming and readability
- Support browser selection via config

---

## Sprint 3 - Reporting and Scalability
Focus on making the framework easier to execute, monitor, and expand.

### Planned Enhancements
- Add more business flows
- Organize execution with TestNG suites
- Add smoke/regression grouping
- Add reporting
- Add screenshot capture on failures
- Prepare for CI/CD integration
- Prepare for future BDD/API expansion
