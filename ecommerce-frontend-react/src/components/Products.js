import React, { useEffect, useState } from 'react';
import { getAllProducts } from '../services/productService';

const Products = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    getAllProducts()
      .then((data) => setProducts(data))
      .catch((err) => console.error('Error fetching products', err));
  }, []);

  return (
    <div>
      <h2>All Products</h2>
      <ul>
        {products.map((prod) => (
          <li key={prod.id}>
            {prod.name} - ₹{prod.price}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Products;
