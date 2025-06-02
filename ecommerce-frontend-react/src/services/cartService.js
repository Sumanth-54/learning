import apiClient from './apiClient';

const BASE_URL = 'http://localhost:8083/cart'; // Order MS

export const getCart = async () => {
  const response = await apiClient.get(`${BASE_URL}`);
  return response.data;
};
