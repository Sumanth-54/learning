import React, { useState } from "react";
import { placeOrder } from "../services/orderService";
import { clearCart } from "../services/cartService";

const Checkout = ({ onOrderPlaced }) => {
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);

  const handleCheckout = async () => {
    setError(null);
    setSuccess(null);
    try {
      await placeOrder({});
      await clearCart();
      setSuccess("Order placed successfully!");
      if (onOrderPlaced) onOrderPlaced();
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div>
      <h2>Checkout</h2>
      <button onClick={handleCheckout}>Place Order</button>
      {error && <p style={{ color: "red" }}>{error}</p>}
      {success && <p style={{ color: "green" }}>{success}</p>}
    </div>
  );
};

export default Checkout;
