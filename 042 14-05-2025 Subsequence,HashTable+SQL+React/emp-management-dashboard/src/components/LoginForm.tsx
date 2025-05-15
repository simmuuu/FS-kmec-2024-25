import React, { useState, useEffect } from 'react';
import type { User } from '../App';

interface LoginFormProps {
  onLogin: (user: User) => void;
}

const LoginForm: React.FC<LoginFormProps> = ({ onLogin }) => {
  const [username, setUsername] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const [error, setError] = useState<string>('');
  const [users, setUsers] = useState<User[]>([]);

  // load or initialize default creds from localStorage
  useEffect(() => {
    const storedUsers = localStorage.getItem('users');

    if (storedUsers) {
      setUsers(JSON.parse(storedUsers));
    } else {
      const defaultUsers: User[] = [
        { username: 'admin', password: 'admin123', role: 'admin' },
        { username: 'hr', password: 'hr123', role: 'hr' },
      ];
      setUsers(defaultUsers);
      localStorage.setItem('users', JSON.stringify(defaultUsers));
    }
  }, []);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    setError('');

    const user = users.find(
      u => u.username === username && u.password === password
    );

    if (user) {
      onLogin(user);
    } else {
      setError('Invalid username or password');
    }
  };

  const formStyle: React.CSSProperties = {
    maxWidth: '400px',
    margin: '0 auto',
    padding: '20px',
    border: '1px solid #ddd',
    borderRadius: '5px',
    marginTop: '50px',
  };

  const inputGroupStyle: React.CSSProperties = {
    marginBottom: '15px',
  };

  const inputStyle: React.CSSProperties = {
    width: '100%',
    padding: '8px',
    boxSizing: 'border-box',
    border: '1px solid #ddd',
    borderRadius: '4px',
  };

  const errorStyle: React.CSSProperties = {
    color: 'red',
    fontSize: '14px',
    marginTop: '10px',
    textAlign: 'center',
  };

  const buttonStyle: React.CSSProperties = {
    background: '#4CAF50',
    color: 'white',
    padding: '10px 15px',
    border: 'none',
    borderRadius: '4px',
    cursor: 'pointer',
    width: '100%',
  };

  return (
    <div>
      <h2 style={{ textAlign: 'center' }}>Login</h2>
      <form onSubmit={handleSubmit} style={formStyle}>
        <div style={inputGroupStyle}>
          <label>Username</label>
          <input
            type="text"
            value={username}
            onChange={e => setUsername(e.target.value)}
            style={inputStyle}
            required
          />
        </div>

        <div style={inputGroupStyle}>
          <label>Password</label>
          <input
            type="password"
            value={password}
            onChange={e => setPassword(e.target.value)}
            style={inputStyle}
            required
          />
        </div>

        {error && <div style={errorStyle}>{error}</div>}

        <button type="submit" style={buttonStyle}>
          Login
        </button>

        <div
          style={{
            marginTop: '15px',
            textAlign: 'center',
            fontSize: '14px',
            color: '#666',
          }}
        >
          <p>Default credentials:</p>
          <p>Admin: username="admin", password="admin123"</p>
          <p>HR: username="hr", password="hr123"</p>
        </div>
      </form>
    </div>
  );
};

export default LoginForm;
