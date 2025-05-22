import { useEffect, useState } from 'react';
import {
    getAllAccommodations,
    addAccommodation,
    updateAccommodation,
    deleteAccommodation,
} from '../api/accommodations';

export default function AccommodationsPage() {
    const [accommodations, setAccommodations] = useState([]);
    const [formData, setFormData] = useState({
        id: null,
        name: '',
        category: '',
        numberOfRooms: 0,
        hostId: '',
    });

    useEffect(() => {
        loadAccommodations();
    }, []);

    const loadAccommodations = async () => {
        try {
            const res = await getAllAccommodations();
            setAccommodations(res.data);
        } catch (err) {
            console.error('Error fetching accommodations:', err);
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prev) => ({ ...prev, [name]: value }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            if (formData.id) {
                await updateAccommodation(formData.id, formData);
            } else {
                await addAccommodation(formData);
            }
            setFormData({ id: null, name: '', category: '', numberOfRooms: 0, hostId: '' });
            loadAccommodations();
        } catch (err) {
            console.error('Save failed:', err);
        }
    };

    const handleEdit = (acc) => {
        setFormData(acc);
    };

    const handleDelete = async (id) => {
        try {
            await deleteAccommodation(id);
            loadAccommodations();
        } catch (err) {
            console.error('Delete failed:', err);
        }
    };

    return (
        <div>
            <h2>Accommodations</h2>

            <form onSubmit={handleSubmit} style={{ marginBottom: '2rem' }}>
                <input
                    type="text"
                    name="name"
                    placeholder="Name"
                    value={formData.name}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="category"
                    placeholder="Category"
                    value={formData.category}
                    onChange={handleChange}
                />
                <input
                    type="number"
                    name="numberOfRooms"
                    placeholder="Rooms"
                    value={formData.numberOfRooms}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    name="hostId"
                    placeholder="Host ID"
                    value={formData.hostId}
                    onChange={handleChange}
                />
                <button type="submit">{formData.id ? 'Update' : 'Add'} Accommodation</button>
            </form>

            <ul>
                {accommodations.map((acc) => (
                    <li key={acc.id}>
                        {acc.name} | {acc.category} | {acc.numberOfRooms} rooms | Host ID: {acc.hostId}
                        <button onClick={() => handleEdit(acc)}>Edit</button>
                        <button onClick={() => handleDelete(acc.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}
