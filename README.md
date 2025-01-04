# SauceDemo Playwright Automation 🛒
Automated test cases for SauceDemo, a demo e-commerce website. This website is designed for testing different features, like browsing products, managing the cart, and finishing the checkout process. This repository shows how I use the Playwright framework for end-to-end testing.

## Features Tested ✅
- User login functionality
- Product browsing and sorting
- Add to cart functionality
- Checkout process
- Validation for buyer information form
- Behavior of cancel and continue buttons during checkout

## Technologies Used 💻
- [Selenium](https://www.selenium.dev/): A framework for automating web browsers.
- Java: Programming language for writing test scripts.
- [JUnit](https://junit.org/): A testing framework for running tests.
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager): Manages WebDriver binaries for Selenium.
- [Cucumber](https://cucumber.io/): A tool for Behavior-Driven Development (BDD).

## Project Structure 🗂️
- `src/`: Contains the main source code, including the test scripts.
- `target/`: Contains the test execution reports, and including summaries.
- `pom.xml`: Maven configuration file for managing project dependencies and build lifecycle.

## How to Run 🚀
To run the tests in this project, follow these steps:

1. Clone this repository:
   ```bash
   git clone https://github.com/vidhapratiwi/saucedemo-selenium-automation.git
   ```
2. Navigate to the project directory:
   ```bash
   cd saucedemo-selenium-automation
   ```
3. Install dependencies and build the project:
   ```bash
   mvn install
   ```
4. Run the tests:
   ```bash
   mvn test
   ```

## Test Cases 📋
This project includes both manual and automated test cases:

- **Manual Test Cases**: Documented in a [Google Sheets file](https://docs.google.com/spreadsheets/d/1fmJJvCBhL_fqHFb_lG7ZWX6GXy_0ksuKV4jn6uNvjjA/edit?gid=0#gid=0) to plan and track test coverage before automation.
- **Automated Test Cases**: The scripts for automated tests are stored in the `src/tests/` directory.

## Related Projects 🔗
This repository is part of a collection of projects designed to showcase my QA engineering skills such as:

- [SauceDemo Playwright Automation](https://github.com/vidhapratiwi/saucedemo-playwright-automation.git): Automated tests for SauceDemo using the Playwright framework.
- [CURA Healthcare Playwright Automation](https://github.com/vidhapratiwi/cura-playwright-automation.git): Automated tests for CURA Healthcare, focusing on appointment booking functionality.

For more related projects, visit my [QA Portfolio repository](https://github.com/vidhapratiwi/QA-Portfolio.git) 🗃

## Contributing 🤝
Contributions are welcome! If you have suggestions for improving the test scripts or expanding the test coverage, feel free to open an issue or submit a pull request.

## License 📝
This project is not licensed under any specific license. Please contact the author for permission before using or modifying the code.
