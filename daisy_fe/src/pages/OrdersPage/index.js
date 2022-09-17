import React from "react";
import { Box } from "@mui/material";
import OrderCard from "../../components/OrderCard";

// import PropTypes from 'prop-types';

Orders.propTypes = {};

function Orders(props) {
  var orders = [];
  for (var i = 0; i < 10; i++) {
    orders.push({
      customer: `customer name ${i + 1}`,
      restaurant: `restaurant name ${i + 1}`,
      pickUpPoint: `pick up point ${i + 1}`,
      destination: `destination ${i + 1}`,
      payment: 10,
      total: 20,
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
        />
      ))}
    </Box>
  );
}

export default Orders;
