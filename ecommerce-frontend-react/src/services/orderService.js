import { apiFetch } from "./apiClient";

const BASE_URL = "http://localhost:8084/order";

export async function placeOrder(orderDetails) {
  return apiFetch(BASE_URL, {
    method: "POST",
    body: JSON.stringify(orderDetails),
  });
}
