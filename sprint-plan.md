
---

# ✅ 2. sprint-plan.md (create new file)

Create file:
👉 `sprint-plan.md`

Paste this:

```md
# Sprint Plan - OpenCart Selenium Automation Framework

---

## 🟢 Sprint 1 - Core Framework Setup

### Objective
Build a working automation framework for a business-critical user journey.

### Delivered
- Maven project setup
- Java 21 configuration
- Selenium WebDriver + TestNG integration
- Page Object Model (POM) structure
- Config-driven approach using properties files

### Automated Flow
- Login
- Select Mac product
- Add to cart
- Checkout
- Shipping
- Order confirmation
- Logout

---

## 🟡 Sprint 2 - Stability and Reusability

### Objective
Improve framework reliability and reduce flaky tests.

### Planned Enhancements
- Replace `Thread.sleep()` with `WebDriverWait`
- Improve synchronization handling
- Refactor reusable methods
- Clean code structure and package organization
- Improve naming conventions
- Add browser selection via config

---

## 🔵 Sprint 3 - Scalability and Reporting

### Objective
Prepare framework for scale and enterprise-level usage.

### Planned Enhancements
- Add multiple test scenarios
- Organize execution via TestNG suites
- Add smoke and regression grouping
- Add reporting
- Capture screenshots on failure
- Prepare for CI/CD integration
- Extend to API and BDD automation

---

## 🎯 Summary

This framework was developed iteratively:
- Sprint 1 → Functional automation
- Sprint 2 → Stability improvements
- Sprint 3 → Scalability and visibility
