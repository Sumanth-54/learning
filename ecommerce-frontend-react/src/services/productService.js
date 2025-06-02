import apiClient from './apiClient';

const BASE_URL = 'http://localhost:8082/product'; // Product MS

export const getAllProducts = async () => {
  const response = await apiClient.get(BASE_URL);
  return response.data;
};
