# Test Plan

## Test Strategy

### Objectives

- Validate that users can create challenges and view them in the "My Challenge" section on CTFlearner.
- Ensure users can view and update user information via the Reqres API.

### Scope

- UI testing for CTFlearner.
- API testing for Reqres.

### Approach

- Utilize Selenium for UI automation.
- Utilize RestAssured for API testing.
- Implement TestNG for test management and Maven for project management.
- Use POM (Page Object Model) for maintainable and scalable test scripts.
- Generate test reports using Allure Report.

### Environments

- QA
- Staging

## Test Cases

### User Story 1 (UI)

#### Login Test Case

**Precondition:** User is registered on CTFlearner.

**Steps:**
1. Navigate to CTFlearner login page.
2. Enter valid username and password.
3. Click on "Login" button.

**Expected Result:** User is logged in successfully.

#### Test Case 1: Create Challenge (Positive)

**Precondition:** User is logged in.

**Steps:**
1. Click on "Create Challenge".
2. Fill in challenge details.
3. Submit the challenge.
4. Navigate to "My Challenge".

**Expected Result:** Created challenge is displayed in "My Challenge".

#### Test Case 2: Create Challenge with Missing Fields (Negative)

**Precondition:** User is logged in.

**Steps:**
1. Click on "Create Challenge".
2. Submit the challenge with some fields empty.
3. Navigate to "My Challenge".

**Expected Result:** Error message is displayed and challenge is not created.

### User Story 2 (API)

#### Endpoint: POST /login (Positive)

**Steps:**
1. Send a POST request to /login with valid credentials.

**Expected Result:** Receive a valid token.

#### Endpoint: POST /login (Negative)

**Steps:**
1. Send a POST request to /login with invalid credentials.

**Expected Result:** Receive an error message.

#### Endpoint: GET /users/{id} (Positive)

**Precondition:** Valid token obtained from login.

**Steps:**
1. Send a GET request to /users/{id} with a valid user ID.

**Expected Result:** Receive user details.

#### Endpoint: GET /users/{id} (Negative)

**Precondition:** Valid token obtained from login.

**Steps:**
1. Send a GET request to /users/{id} with an invalid user ID.

**Expected Result:** Receive an error message.

#### Endpoint: PUT /users/{id} (Positive)

**Precondition:** Valid token obtained from login.

**Steps:**
1. Send a PUT request to /users/{id} with valid user details.

**Expected Result:** User information is updated successfully.

#### Endpoint: PUT /users/{id} (Negative)

**Precondition:** Valid token obtained from login.

**Steps:**
1. Send a PUT request to /users/{id} with invalid user details.

**Expected Result:** Receive an error message.
