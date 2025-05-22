import React, { useEffect, useState } from 'react';
import { HostRepository } from '../api/hosts';

function HostsPage() {
    const [hosts, setHosts] = useState([]);

    useEffect(() => {
        HostRepository.getAllHosts()
            .then(response => setHosts(response.data))
            .catch(error => console.error('Error fetching hosts:', error));
    }, []);

    return (
        <div>
            <h1>Hosts</h1>
            <ul>
                {hosts.map(host => (
                    <li key={host.id}>{host.name} {host.surname}</li>
                ))}
            </ul>
        </div>
    );
}

export default HostsPage;
