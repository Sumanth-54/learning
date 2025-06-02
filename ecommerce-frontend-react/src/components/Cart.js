import React, { useEffect, useState } from "react";
import { getCartItems, removeFromCart } from "../services/cartService";

const Cart = () => {
  const [cartItems, setCartItems] = useState([]);
  const [error, setError] = useState(null);

  const loadCart = () => {
    getCartItems()
      .then(setCartItems)
      .catch((err) => setError(err.message));
  };

  useEffect(() => {
    loadCart();
  }, []);

  const handleRemove = (id) => {
    removeFromCart(id)
      .then(() => loadCart())
      .catch((err) => setError(err.message));
  };

  if (error) return <p>Error loading cart: {error}</p>;

  if (cartItems.length === 0) return <p>Your cart is empty.</p>;

  return (
    <div>
      <h2>Your Cart</h2>
      <ul>
        {cartItems.map((item) => (
          <li key={item.id}>
            {item.product.name} - Qty: {item.quantity} - $
            {(item.product.price * item.quantity).toFixed(2)}
            <button onClick={() => handleRemove(item.id)}>Remove</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Cart;
