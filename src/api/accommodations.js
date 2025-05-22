import axios from 'axios';

const API_URL = 'http://localhost:8080/api/accommodations';

export const getAllAccommodations = () => axios.get(API_URL);
export const addAccommodation = (data) => axios.post(API_URL, data);
export const updateAccommodation = (id, data) => axios.put(`${API_URL}/${id}`, data);
export const deleteAccommodation = (id) => axios.delete(`${API_URL}/${id}`);
