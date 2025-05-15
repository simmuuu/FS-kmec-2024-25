import React, { useState, useEffect } from 'react';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
  Navigate,
} from 'react-router-dom';
import EmployeeForm from './components/EmployeeForm';
import EmployeeList from './components/EmployeeList';
import AdminPanel from './components/AdminPanel';
import HRPanel from './components/HRPanel';
import LoginForm from './components/LoginForm';
import './App.css';

export interface Address {
  houseNo: string;
  buildingName: string;
  area: string;
  city: string;
  state: string;
  pincode: string;
}

export interface Employee {
  id: number;
  fullName: string;
  email: string;
  mobile: string;
  dob: string;
  aadhar: string;
  pan: string;
  address: Address;
  status: 'Pending' | 'Accepted';
}

export interface User {
  username: string;
  password: string;
  role: 'admin' | 'hr';
}

function App() {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [currentUser, setCurrentUser] = useState<User | null>(null);

  // Load initial data from localStorage
  useEffect(() => {
    try {
      const storedEmployees = localStorage.getItem('employees');
      if (storedEmployees) {
        setEmployees(JSON.parse(storedEmployees));
      }

      const storedUser = localStorage.getItem('currentUser');
      if (storedUser) {
        setCurrentUser(JSON.parse(storedUser));
      } else {
        setCurrentUser(null); // Default to null if no user
      }
    } catch (error) {
      console.error('Error loading data from localStorage:', error);
      // Reset to defaults if there's an error
      setEmployees([]);
      setCurrentUser(null);
      // Clear potentially corrupted data
      localStorage.removeItem('employees');
      localStorage.removeItem('currentUser');
    }
  }, []);

  // Save data to localStorage whenever it changes
  useEffect(() => {
    localStorage.setItem('employees', JSON.stringify(employees));
  }, [employees]);

  useEffect(() => {
    if (currentUser) {
      localStorage.setItem('currentUser', JSON.stringify(currentUser));
    }
  }, [currentUser]);

  const addEmployee = (employee: Omit<Employee, 'id' | 'status'>) => {
    const newEmployee: Employee = {
      ...employee,
      id: Date.now(),
      status: 'Pending',
    };
    setEmployees([...employees, newEmployee]);
  };

  const updateEmployeeStatus = (id: number) => {
    setEmployees(
      employees.map(employee =>
        employee.id === id ? { ...employee, status: 'Accepted' } : employee
      )
    );
  };

  const handleLogin = (user: User) => {
    setCurrentUser(user);
  };

  const handleLogout = () => {
    setCurrentUser(null);
    localStorage.removeItem('currentUser');
  };

  return (
    <Router>
      <div className="App">
        <nav
          style={{ background: '#333', padding: '15px', marginBottom: '20px' }}
        >
          <ul
            style={{
              display: 'flex',
              listStyle: 'none',
              margin: 0,
              padding: 0,
            }}
          >
            <li style={{ marginRight: '20px' }}>
              <Link to="/" style={{ color: 'white', textDecoration: 'none' }}>
                Home
              </Link>
            </li>
            <li style={{ marginRight: '20px' }}>
              <Link
                to="/register"
                style={{ color: 'white', textDecoration: 'none' }}
              >
                Register
              </Link>
            </li>
            <li style={{ marginRight: '20px' }}>
              <Link
                to="/employees"
                style={{ color: 'white', textDecoration: 'none' }}
              >
                Employees
              </Link>
            </li>
            {currentUser && (
              <li style={{ marginRight: '20px' }}>
                <Link
                  to="/dashboard"
                  style={{ color: 'white', textDecoration: 'none' }}
                >
                  {currentUser.role === 'admin' ? 'Admin' : 'HR'} Dashboard
                </Link>
              </li>
            )}
            <li style={{ marginLeft: 'auto' }}>
              {currentUser ? (
                <button
                  onClick={handleLogout}
                  style={{
                    background: 'transparent',
                    color: 'white',
                    border: '1px solid white',
                    padding: '5px 10px',
                    cursor: 'pointer',
                    borderRadius: '3px',
                  }}
                >
                  Logout ({currentUser.username})
                </button>
              ) : (
                <Link
                  to="/login"
                  style={{ color: 'white', textDecoration: 'none' }}
                >
                  Login
                </Link>
              )}
            </li>
          </ul>
        </nav>

        <div style={{ padding: '0 20px' }}>
          <Routes>
            <Route
              path="/"
              element={
                <div style={{ textAlign: 'center', marginTop: '50px' }}>
                  <h1>Welcome to Employee Management Dashboard</h1>
                  <p>Use the navigation links above to manage employees</p>
                </div>
              }
            />
            <Route
              path="/register"
              element={<EmployeeForm addEmployee={addEmployee} />}
            />
            <Route
              path="/employees"
              element={<EmployeeList employees={employees} />}
            />
            <Route
              path="/login"
              element={
                currentUser ? (
                  <Navigate to="/dashboard" />
                ) : (
                  <LoginForm onLogin={handleLogin} />
                )
              }
            />
            <Route
              path="/dashboard"
              element={
                !currentUser ? (
                  <Navigate to="/login" />
                ) : currentUser.role === 'admin' ? (
                  <AdminPanel
                    employees={employees}
                    updateEmployeeStatus={updateEmployeeStatus}
                  />
                ) : (
                  <HRPanel employees={employees} />
                )
              }
            />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
