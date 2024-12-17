import React, { useEffect, useState } from 'react';
import '../styles/Orders.css'
import '../styles/Search.css'

function Orderdetails() {
    const [ordersD, setOrdersD] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");

    useEffect(() => {
        fetchOrdersD();
    }, []);

    const fetchOrdersD = async () => {
        try {
            const response = await fetch('http://localhost:8080/orderdetails/get/all');
            if (response.ok) {
                const data = await response.json();
                console.log(data);
                setOrdersD(data); 
            } else {
                console.error('Error al obtener las órdenes:', response.statusText);
            }
        } catch (error) {
            console.error('Error de red:', error);
        }
    };

    const filterOrders = ordersD.filter(orderD =>
        orderD.orderDetailsID.toString().includes(searchQuery) ||
        orderD.order?.orderID.toString().includes(searchQuery) ||
        orderD.amount.toString().includes(searchQuery) ||
        orderD.profit.toString().includes(searchQuery) ||
        orderD.quantity.toString().includes(searchQuery) ||
        orderD.category.toLowerCase().includes(searchQuery.toLowerCase())  ||
        orderD.subCategory.toLowerCase().includes(searchQuery.toLowerCase())
    );

    return (
        <div>
            <h1>Detalles de órdenes</h1>
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

            {/*Mostrar datos si existen*/}
            {ordersD.length > 0 ? (
                <table className="orders-table">
                    <thead>
                        <tr>
                            <th>Orders Details ID</th>
                            <th>OrderID</th>
                            <th>Amount</th>
                            <th>Profit</th>
                            <th>Quantity</th>
                            <th>Category</th>
                            <th>Sub-Category</th>
                        </tr>
                    </thead>
                    <tbody>
                        {filterOrders.map((orderD) => (
                            <tr key={orderD.orderID}>
                                <td>{orderD.orderDetailsID}</td>
                                <td>{orderD.order?.orderID}</td>
                                <td>{orderD.amount}</td>
                                <td>{orderD.profit}</td>
                                <td>{orderD.quantity}</td>
                                <td>{orderD.category}</td>
                                <td>{orderD.subCategory}</td>
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

export default Orderdetails;