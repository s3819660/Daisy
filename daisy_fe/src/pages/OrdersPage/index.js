import React, { useEffect, useState } from "react";
import { Box, Card } from "@mui/material";
import OrderCard from "../../components/OrderCard";

// import PropTypes from 'prop-types';

Orders.propTypes = {};

function Orders(props) {
  // const [selectedOrder, setSelectedOrder] = useState(-1);

  useEffect(() => {
    fetchOrders();
  }, []);

  // useEffect(() => {
  //   if (selectedOrder > -1) return;
  //   console.log("dds", selectedOrder)
  //   // TODO: Confirm order here
  // }, [selectedOrder]);

  function fetchOrders() {
    // TODO: Fetch here
    fetch("http://localhost:8080/orders/getOrders")
  }

  function handleConfirmOrder(orderId) {
    console.log("handleConfirmOrder", orderId)
  }

  var orders = [];
  for (var i = 0; i < 10; i++) {
    orders.push({
      id: i,
      customer: `customer name ${i + 1}`,
      restaurant: `restaurant name ${i + 1}`,
      pickUpPoint: `pick up point ${i + 1}`,
      destination: `destination ${i + 1}`,
      payment: 58000,
      total: 189000,
      createdOn: Date(),
    });
  }

  return (
    <Box
      sx={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        p: 2,
        m: 2,
      }}
    >
      {orders.map((order, index) => (
        <OrderCard
          key={`order-${index}`}
          order={order}
          className="order-card"
          confirmOrder={handleConfirmOrder}
          confirmButton={true}
        />
      ))}
    </Box>
  );
}

export default Orders;
