// src/components/Login.js
import React, { useState } from 'react';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    console.log('Login:', { username, password });
    // TODO: Call login API
  };

  const handleRegister = () => {
    console.log('Register:', { username, password });
    // TODO: Call register API
  };

  return (
    <div className="container mt-4">
  
  
  <div className="d-flex flex-column align-items-center mb-4">
    <input
      type="text"
      className="form-control mb-2"
      placeholder="Username or email"
      style={{ maxWidth: '300px' }}
    />
    <input
      type="password"
      className="form-control mb-2"
      placeholder="Password"
      style={{ maxWidth: '300px' }}
    />
    <div className="d-flex gap-2">
      <button className="btn btn-primary btn-sm">Login</button>
      <button className="btn btn-secondary btn-sm">Register</button>
    </div>
  </div>

  <hr />
</div>

  );
};

export default Login;
