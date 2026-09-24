# API Testing with Rest Assured

Automated API testing project for the [JSONPlaceholder](https://jsonplaceholder.typicode.com/) REST API.

The project contains automated tests for the `/users` endpoint using Java, Rest Assured, and JUnit 5.

## Technologies

- Java
- Rest Assured
- JUnit 5
- Maven
- Hamcrest
- Git

## Tested Endpoint

### GET `/users`

The following aspects of the API response are validated:

- HTTP status code is `200 OK`
- `Content-Type` header is `application/json; charset=utf-8`
- Response contains exactly 10 users

## Test Cases

| Test | Description |
|------|-------------|
| `testStatusCode200` | Verifies that the API returns HTTP status code 200 |
| `testContentTypeHeader` | Verifies the response Content-Type header |
| `testResponseBodyUserCount` | Verifies that the response contains 10 users |

## Test Execution

Tests are configured to run concurrently using JUnit 5 parallel execution.

Run all tests with Maven:

```bash
mvn test
