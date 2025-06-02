// src/App.js
import React from 'react';
import Login from './components/Login';
import ProductList from './components/Products';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="container mt-5">
      <h1 className="text-center mb-4">Mini E-Commerce</h1>
      <Login />
      <hr />
      <ProductList />
    </div>
  );
}

export default App;
