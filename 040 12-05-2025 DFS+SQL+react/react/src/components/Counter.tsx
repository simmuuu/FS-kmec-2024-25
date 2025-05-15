import { useState } from 'react';

export default function Counter() {
  const [score, setScore] = useState(0);
  function plus() {
    setScore(score + 1);
  }

  function minus() {
    setScore(score - 1);
  }

  return (
    <>
      <h2>Counter: {score}</h2>
      <button onClick={plus}>plus</button>
      <button onClick={minus}>minus</button>
    </>
  );
}
