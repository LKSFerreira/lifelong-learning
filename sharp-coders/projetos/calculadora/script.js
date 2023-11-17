const result = document.getElementById("result");
const keys = document.querySelector(".keys");
let operator = null;
let operand1 = null;
let operand2 = null;

function handleInput(event) {
    const value = event.target.value;

    if (Number.isInteger(parseInt(value))) {
        // input is a number
        if (operator === null) {
            // no operator has been selected yet, so update operand1
            if (operand1 === null) {
                operand1 = value;
            } else {
                operand1 += value;
            }
            result.value = operand1;
        } else {
            // an operator has been selected, so update operand2
            if (operand2 === null) {
                operand2 = value;
            } else {
                operand2 += value;
            }
            result.value = operand2;
        }
    } else {
        // input is an operator or clear button
        if (value === "C") {
            // clear button pressed, so reset all variables and clear the result field
            operator = null;
            operand1 = null;
            operand2 = null;
            result.value = "";
        } else if (value === "=") {
            // equal button pressed, so perform calculation and update result field
            if (operand1 !== null && operand2 !== null && operator !== null) {
                const num1 = parseInt(operand1);
                const num2 = parseInt(operand2);
                let resultValue;

                switch (operator) {
                    case "+":
                        resultValue = num1 + num2;
                        break;
                    case "-":
                        resultValue = num1 - num2;
                        break;
                    case "*":
                        resultValue = num1 * num2;
                        break;
                    case "/":
                        resultValue = num1 / num2;
                        break;
                }

                operator = null;
                operand1 = resultValue.toString();
                operand2 = null;
                result.value = operand1;
            }
        } else {
            // operator button pressed, so update the operator variable
            operator = value;
        }
    }
}

keys.addEventListener("click", handleInput);
