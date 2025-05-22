import axios from 'axios';

const API_URL = 'http://localhost:8080/api/hosts';

const getAllHosts = () => axios.get(API_URL);
const getHost = (id) => axios.get(`${API_URL}/${id}`);
const createHost = (host) => axios.post(API_URL, host);
const updateHost = (id, host) => axios.put(`${API_URL}/${id}`, host);
const deleteHost = (id) => axios.delete(`${API_URL}/${id}`);

export const HostRepository = {
    getAllHosts,
    getHost,
    createHost,
    updateHost,
    deleteHost,
};
