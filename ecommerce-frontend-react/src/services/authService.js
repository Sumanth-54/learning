import apiClient from './apiClient';

const BASE_URL = 'http://localhost:8081'; // User MS

export const login = async (credentials) => {
  const response = await apiClient.post(`${BASE_URL}/login`, credentials);
  return response.data;
};

export const register = async (userData) => {
  const response = await apiClient.post(`${BASE_URL}/register`, userData);
  return response.data;
};
