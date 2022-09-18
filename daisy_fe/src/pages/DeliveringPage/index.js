import { Box } from "@mui/material";
import React, { useEffect, useState } from "react";
import OrderCard from "../../components/OrderCard";
// import PropTypes from 'prop-types';

DeliveringOrders.propTypes = {};

function DeliveringOrders(props) {
  // const [selectedOrder, setSelectedOrder] = useState(0);

  useEffect(() => {
    fetchProcessingOrders();
  }, []);

  // useEffect(() => {
  //   if (!selectedOrder) return;

  //   // TODO: Confirm pack here
  // }, [selectedOrder]);

  function fetchProcessingOrders() {
    // TODO: Fetch here
  }

  function handleCompleteOrder(orderId) {
    // TODO: complete order
    console.log("handleCompleteOrder", orderId)
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
          // confirmPack={setSelectedOrder}
          completeOrder={handleCompleteOrder}
        />
      ))}
    </Box>
  );
}

export default DeliveringOrders;
