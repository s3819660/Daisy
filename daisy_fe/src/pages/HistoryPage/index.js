import React, { useEffect } from "react";
import OrderCard from "../../components/OrderCard";
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
      payment: 10,
      total: 20,
      createdOn: Date(),
    });
  }

  return (
    <div>
      history
      {orders.map((order, index) => (
        <OrderCard key={`order-${index}`} order={order} />
      ))}
    </div>
  );
}

export default History;
