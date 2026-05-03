# OpenCart Selenium Automation Framework

This project is a Selenium-based automation framework built using Java, Maven, and TestNG.
It automates an end-to-end user journey on the OpenCart application and integrates API and backend validation for full-stack test coverage.

---

## ERPNext API Automation

Designed and implemented end-to-end API automation for ERPNext using RestAssured, covering authentication, data validation, and transactional workflows.

### Key Implementations

* Automated Login API with session-based authentication (cookie handling)
* Validated master data APIs (Items, Customers, Warehouses)
* Created Sales Order via POST API with dynamic payload handling
* Implemented end-to-end workflow: Login → Create Order → Extract ID → Verify via GET API
* Handled backend validation constraints (customer existence, item mapping, warehouse-company alignment)
* Parsed JSON responses and performed assertions using TestNG and Hamcrest
* Debugged API failures related to permissions, invalid payloads, and business rule validations

### Technical Highlights

* Built reusable API test structure using Java + TestNG
* Used RestAssured for request chaining and response validation
* Managed session using cookies (`sid`)
* Validated API responses with status codes and JSON path assertions
* Integrated with Maven for build execution (`mvn clean test`)

### Tech Stack

* Java
* RestAssured
* TestNG
* Maven
* ERPNext REST APIs

---

## 🔄 CI/CD Integration (Jenkins)

Integrated automation tests with Jenkins for continuous execution and build validation.

### Implementation

* Configured Jenkins pipeline using `Jenkinsfile`
* Automated test execution via Maven:

  ```bash
  mvn clean test
  ```
* Enabled TestNG suite execution through Maven Surefire Plugin

### Outcome

* Automated regression execution via CI pipeline
* Reduced manual testing effort
* Ensured consistent build verification

---

## 🗄️ Database Validation (SQL)

Performed backend validation by verifying API-created data directly in the database.

### Implementation

* Connected to MySQL (ERPNext database)
* Validated Sales Order creation using SQL queries

### Sample Query

```sql
SELECT name, customer, grand_total
FROM `tabSales Order`
WHERE name = 'SAL-ORD-2026-00008';
```

### Validation Strategy

* Compared API response values with database records
* Ensured data consistency between API and database layers
* Verified critical fields:

  * Order ID
  * Customer name
  * Total amount

### Outcome

* Strengthened test reliability with backend validation
* Ensured end-to-end data integrity

---

## 🚀 Tech Stack

* Java 21
* Selenium WebDriver
* TestNG
* Maven

---

## 🧱 Framework Design

The framework follows the Page Object Model (POM) design pattern.

### Structure

* `baseopc` → Driver setup and base classes
* `pagesopc` → Page Object classes
* `utilitiesopc` → Config handling and reusable utilities
* `testsopc` → Test execution classes
* `resources` → Config and locator properties

---

## 🧪 Test Flow Covered

* Login
* Select Mac product
* Add to cart
* Checkout
* Enter shipping details
* Confirm order
* Logout

---

## ▶️ How to Run Tests

```bash
mvn clean test
```
