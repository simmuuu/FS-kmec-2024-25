interface GreetingProps {
  name: string;
}

function Greeting({ name }: GreetingProps) {
  return <h2>Hello, {name}! Welcome to React.</h2>;
}

function Greetings() {
  return ['Alice', 'John', 'Tejas'].map(n => <Greeting name={n} />);
}

export default Greetings;
