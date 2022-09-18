import { Box } from "@mui/material";
import React, { useEffect } from "react";
import HistoryOrderCard from "../../components/HistoryOrderCard";
// import PropTypes from 'prop-types';

History.propTypes = {};

function History(props) {
  useEffect(() => {
    fetchOrdersHistory();
  }, []);

  function fetchOrdersHistory() {
    // Fetch here
  }

  var orders = [];
  for (var i = 0; i < 10; i++) {
    orders.push({
      customer: `customer name ${i + 1}`,
      restaurant: `restaurant name ${i + 1}`,
      pickUpPoint: `pick up point ${i + 1}`,
      destination: `destination ${i + 1}`,
      payment: 15000,
      total: 20000,
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
        <HistoryOrderCard key={`order-${index}`} order={order} />
      ))}
    </Box>
  );
}

export default History;
