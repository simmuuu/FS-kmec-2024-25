import { useState } from 'react';

// two input fields
// 4 buttons + - * /
// result under these. result: 3

export default function Calc() {
  const [num1, setNum1] = useState<number>(0);
  const [num2, setNum2] = useState<number>(0);
  const [result, setResult] = useState<number | string>();

  function calc(opr: string) {
    switch (opr) {
      case '+':
        setResult(num1 + num2);
        break;
      case '-':
        setResult(num1 - num2);
        break;
      case '*':
        setResult(num1 * num2);
        break;
      case '/':
        setResult(num2 === 0 ? 'cant divide num with 0 duh' : num1 / num2);
        break;
      default:
        setResult('what the sigma');
    }
  }

  return (
    <>
      <h2>Calc</h2>

      <input
        type="number"
        value={num1}
        onChange={e => setNum1(Number(e.target.value))}
        placeholder="num1"
      />
      <input
        type="number"
        value={num2}
        onChange={e => setNum2(Number(e.target.value))}
        placeholder="num2"
      />

      <button onClick={() => calc('+')}>+</button>
      <button onClick={() => calc('-')}>-</button>
      <button onClick={() => calc('*')}>*</button>
      <button onClick={() => calc('/')}>/</button>

      <h3>Result: {result}</h3>
    </>
  );
}
