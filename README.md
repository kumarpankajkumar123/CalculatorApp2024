# Android Calculator App

Welcome to the Android Calculator App repository! This simple calculator app is designed to perform basic arithmetic calculations with a user-friendly interface.

## Features

- **Dynamic Expression Evaluation:** Utilizes the [exp4j](https://www.objecthunter.net/exp4j/) library for dynamic expression evaluation.
- **Error Handling:** Catches and displays errors such as invalid expressions or unexpected errors.
- **Clear and Backspace:** Clear the entire expression or remove the last entered character.
- **Multiple Digit Input:** Easily input multi-digit numbers for precise calculations.

## Code Snippets

### Handling Operators and Digits
# Dependency
 implementation("net.objecthunter:exp4j:0.4.8")
```java
// Method to handle digit input
public void onDigitMethod(View view) {
    // Your implementation here
}

// Method to handle operator input
public void onOperator(View view) {
    // Your implementation here
}
Evaluating Expressions
java
Copy code
// Method to evaluate expressions
public void onBrabar() {
    // Your implementation here
}

// Method to perform calculation on "=" button click
public void onEqual(View view) {
    // Your implementation here
}
```
# Video Demo

palay : https://github.com/kumarpankajkumar123/CalculatorApp2024/assets/119131154/a70a2d7b-2144-4b87-9464-4586330f367b

# Multiple Color uses For better ui

```Color Code
<color name="textColor">#FF000000</color>
    <color name="white">#FFFFFFFF</color>

    <color name="AllClearColor">#E17DF3</color>
    <color name="OperatorColor">#8BCFEF</color>
    <color name="EqualColor">#1EABEA</color>
    <color name="DigitColor">#D2E7F1</color>

    <color name="backGround">#D2F8F8</color>
    <color name="AnswerColor">#50BBEA</color>
    <color name="background_dark">#FFFFFF</color>
    <color name="background_light">#FFFF8D</color>
```
Copy code:git clone https://github.com/kumarpankajkumar123/CalculatorApp2024.git

Contributing
Contributions are welcome! If you have ideas for new features, improvements, or bug fixes, feel free to open an issue or submit a pull request.
