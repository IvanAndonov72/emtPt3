import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import Accommodations from './pages/Accommodations';
import Hosts from './pages/Hosts';
import Countries from './pages/Countries';
import './App.css';

function App() {
    return (
        <Router>
            <nav style={{ padding: '10px' }}>
                <Link to="/" style={{ marginRight: '10px' }}>Home</Link>
                <Link to="/accommodations" style={{ marginRight: '10px' }}>Accommodations</Link>
                <Link to="/hosts" style={{ marginRight: '10px' }}>Hosts</Link>
                <Link to="/countries">Countries</Link>
            </nav>

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/accommodations" element={<Accommodations />} />
                <Route path="/hosts" element={<Hosts />} />
                <Route path="/countries" element={<Countries />} />
            </Routes>
        </Router>
    );
}

export default App;
