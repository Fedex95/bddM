import React, { useEffect, useState } from 'react';
import '../styles/Orders.css'
import '../styles/Search.css'


function ListOrders() {
    const [orders, setOrders] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");

    useEffect(() => {
        fetchOrders();
    }, []);

    const fetchOrders = async () => {
        try {
            const response = await fetch('http://localhost:8080/listoforder/get/all');
            if (response.ok) {
                const data = await response.json();
                console.log(data);
                setOrders(data);
            } else {
                console.error('Error al obtener las órdenes:', response.statusText);
            };
        } catch (error) {
            console.error('Error de red:', error);
        }
    };

    const filterListOrders = orders.filter(order =>
        order.customerName?.toLowerCase().includes(searchQuery.toLowerCase()) ||
        order.orderID?.toString().includes(searchQuery) ||
        order.state?.toLowerCase().includes(searchQuery.toLowerCase()) ||
        order.city?.toLowerCase().includes(searchQuery.toLowerCase()) ||
        order.orderDate?.toLowerCase().includes(searchQuery.toLowerCase())
    );

    const deleteOrder = async (orderID) => {
        try {
            const response = await fetch(`http://localhost:8080/listoforder/deleteList/${orderID}`, {
                method: 'DELETE',
            });
            if (response.ok) {
                alert("Orden eliminada exitosamente");
                setOrders(orders.filter(order => order.orderID !== orderID));
            } else {
                console.error('Error al eliminar la orden:', response.statusText);
            }
        } catch (error) {
            console.error('Error de red:', error);
        }
    };

    const editOrder = async (orderID) => {
        const newName = prompt("Introduce el nuevo nombre del cliente:");
        if (!newName) return;

        try {
            const response = await fetch(`http://localhost:8080/listoforder/editList/${orderID}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ customerName: newName }),
            });

            if (response.ok) {
                alert("Orden editada exitosamente");
                fetchOrders(); 
            } else {
                console.error('Error al editar la orden:', response.statusText);
            }
        } catch (error) {
            console.error('Error de red:', error);
        }
    };

    return (
        <div>
            <h1>Lista de órdenes</h1>

            {/*Barra de busqueda*/}
            <div className='search-container'>
                <input
                    type='text'
                    className='search-bar'
                    placeholder='Buscar'
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                />
            </div>

            {/* Mostrar las órdenes si existen */}
            {orders.length > 0 ? (
                <table className="orders-table">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Order Date</th>
                            <th>Customer Name</th>
                            <th>State</th>
                            <th>City</th>
                        </tr>
                    </thead>
                    <tbody>
                        {filterListOrders.map((order) => (
                            <tr key={order.orderID}>
                                <td>{order.orderID}</td>
                                <td>{order.orderDate}</td>
                                <td>{order.customerName}</td>
                                <td>{order.state}</td>
                                <td>{order.city}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            ) : (
                <p>No hay órdenes disponibles</p>
            )}
        </div>
    );
}

export default ListOrders;
