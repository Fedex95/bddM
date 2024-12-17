import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Navbar.css'; 

function Navbar() {
    return (
        <nav className="navbar">
            <ul className="navbar-list">
                <li className="navbar-item">
                    <Link to="/listorders" className="navbar-button">Lista de órdenes</Link>
                </li>
                <li className="navbar-item">
                    <Link to="/ordersdetails" className="navbar-button">Datos de las órdenes</Link>
                </li>
            </ul>
        </nav>
    );
}

export default Navbar;
