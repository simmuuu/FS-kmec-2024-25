import React, { type JSX } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Counter from './components/Counter';
import Greetings from './components/Greetings';
import UserTable from './components/UserTable';
import ShowHide from './components/ShowHide';
import Calc from './components/Calc';
import './App.css';

function Home(): JSX.Element {
  return (
    <div className="component-home">
      <h1>Home</h1>
    </div>
  );
}

function App(): JSX.Element {
  return (
    <div>
      <BrowserRouter>
        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/counter">Counter</Link>
            </li>
            <li>
              <Link to="/greetings">Greetings</Link>
            </li>
            <li>
              <Link to="/usertable">UserTable</Link>
            </li>
            <li>
              <Link to="/showhide">ShowHide</Link>
            </li>
            <li>
              <Link to="/calc">Calc</Link>
            </li>
          </ul>
        </nav>

        <main>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/counter" element={<Counter />} />
            <Route path="/greetings" element={<Greetings />} />
            <Route path="/usertable" element={<UserTable />} />
            <Route path="/showhide" element={<ShowHide />}></Route>
            <Route path="/calc" element={<Calc />}></Route>
          </Routes>
        </main>
      </BrowserRouter>
    </div>
  );
}

export default App;
