import React from "react";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import Divider from "@mui/material/Divider";
import PropTypes from "prop-types";

OrderCard.propTypes = {
  order: PropTypes.shape({
    customer: PropTypes.string,
    restaurant: PropTypes.string,
    pickUpPoint: PropTypes.string,
    destination: PropTypes.string,
    payment: PropTypes.number,
    total: PropTypes.number,
    createdOn: PropTypes.instanceOf(Date),
  }),
};

function OrderCard(props) {
  return (
    <Card sx={{ maxWidth: "60vh", marginBottom: "1rem" }}>
      <CardContent>
        <Typography variant="body2" color="text.secondary">
          <b>created on: </b>
          {props.order.createdOn}
        </Typography>
        <Typography gutterBottom variant="h5" component="div">
          <b>customer: </b>
          {props.order.customer}
        </Typography>
        <Divider />
        <Typography variant="body2" color="text.secondary">
          <b>restaurant: </b>
          {props.order.restaurant}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          <b>payment: </b>${props.order.payment}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          <b>total: </b>${props.order.total}
        </Typography>
      </CardContent>
      <CardActions>
        <Button
          size="medium"
          sx={{
            textTransform: "none",
          }}
        >
          Accept order
        </Button>
      </CardActions>
    </Card>
  );
}

export default OrderCard;
