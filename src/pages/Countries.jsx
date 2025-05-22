import React, { useEffect, useState } from 'react';
import { CountryRepository } from '../api/countries';

function CountriesPage() {
    const [countries, setCountries] = useState([]);
    const [newCountry, setNewCountry] = useState({
        name: '',
        continent: '',
    });

    const fetchData = () => {
        CountryRepository.getAll()
            .then(res => setCountries(res.data))
            .catch(err => console.error('Failed to fetch countries', err));
    };

    useEffect(() => {
        fetchData();
    }, []);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewCountry(prev => ({ ...prev, [name]: value }));
    };

    const handleCreate = (e) => {
        e.preventDefault();
        CountryRepository.create(newCountry)
            .then(() => {
                setNewCountry({ name: '', continent: '' });
                fetchData();
            })
            .catch(err => console.error('Create failed', err));
    };

    const handleDelete = (id) => {
        CountryRepository.delete(id)
            .then(() => fetchData())
            .catch(err => console.error('Delete failed', err));
    };

    return (
        <div>
            <h2>Countries</h2>

            <form onSubmit={handleCreate}>
                <input name="name" placeholder="Country Name" value={newCountry.name} onChange={handleInputChange} />
                <input name="continent" placeholder="Continent" value={newCountry.continent} onChange={handleInputChange} />
                <button type="submit">Add</button>
            </form>

            <ul>
                {countries.map(country => (
                    <li key={country.id}>
                        {country.name} ({country.continent})
                        <button onClick={() => handleDelete(country.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default CountriesPage;
