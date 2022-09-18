import React from "react";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import Divider from "@mui/material/Divider";
import Box from "@mui/material/Box";
import PropTypes from "prop-types";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import "./style.css"

const theme = createTheme({
  palette: {
    primary: {
      main: "#A4A4A4",
      darker: "#A4A4A4",
    },
  },
});

OrderCard.propTypes = {
  order: PropTypes.shape({
    customer: PropTypes.string,
    restaurant: PropTypes.string,
    pickUpPoint: PropTypes.string,
    destination: PropTypes.string,
    payment: PropTypes.number,
    total: PropTypes.number,
  }),
};

function formatNumber(x) {
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function OrderCard(props) {
  return (
    <Card sx={{ width: "40vw", marginBottom: "1rem" }}>
      <CardContent>
        <Typography
          sx={{
            width: "100%",
            display: "flex",
            flexDirection: "row",
            alignItems: "center",
            justifyContent: "space-around",
          }}
          variant="caption"
          color="text.secondary"
        >
          <Box
            sx={{ width: "50%", display: "flex", justifyContent: "flex-start" }}
          >
            {props.order.createdOn.substring(
              props.order.createdOn.indexOf(" "),
              props.order.createdOn.indexOf("GMT")
            )}
          </Box>
          <Box
            sx={{ width: "50%", display: "flex", justifyContent: "flex-end" }}
          >
            {props.order.customer}
          </Box>
        </Typography>
        <Divider />
        <Box
          sx={{
            width: "100%",
            display: "flex",
            flexDirection: "row",
            alignItems: "center",
            justifyContent: "space-around",
          }}
        >
          <Typography
            sx={{ width: "50%", display: "flex", justifyContent: "flex-start" }}
            variant="h6"
            color="text.secondary"
          >
            <b>{props.order.restaurant}</b>
          </Typography>
          <Typography
            sx={{ width: "50%", display: "flex", justifyContent: "flex-end" }}
            variant="body2"
            color="text.secondary"
          >
            {"2.5km"}
          </Typography>
        </Box>
        <Divider />
        <Box
          sx={{
            width: "100%",
            display: "flex",
            flexDirection: "column",
            justifyContent: "flex-start",
            alignItems: "flex-start",
            my: 1
          }}
        >
          <Typography variant="caption" color="text.secondary">
            <b>Pick Up Point</b>
          </Typography>
          <Typography variant="caption" color="text.secondary">
            12/25A Trần Xuân Soạn, P. Tân Hưng, Q. 7
          </Typography>
          <Typography variant="caption" color="text.secondary">
            <b>Destination</b>
          </Typography>
          <Typography variant="caption" color="text.secondary">
            702 Nguyễn Văn Linh, P. Tân Phong, Q.7, TP.HCM
          </Typography>
        </Box>
        <Divider />
        <Box sx={{ display: "flex"}}>
          <Typography
            sx={{ width: "50%", display: "flex", justifyContent: "flex-start", my: 1 }}
            variant="body2"
            color="text.secondary"
          >
            Payment:
            <b style={{ marginLeft: "5px" }}>
              {formatNumber(props.order.payment)}VND
            </b>
          </Typography>
          <Typography
            sx={{ width: "50%", display: "flex", justifyContent: "flex-end", my: 1 }}
            variant="body2"
            color="text.secondary"
          >
            Total:
            <b style={{ marginLeft: "5px" }}>
              {formatNumber(props.order.total)}VND
            </b>
          </Typography>
        </Box>
        <Divider />
        <ThemeProvider theme={theme}>
          <Button
            disableRipple
            size="medium"
            sx={{
              width: "100%",
              display: "flex",
              alignItems: "center",
              justifyContent: "center",
              color: "grey",
            }}
          >
            Accept order
          </Button>
        </ThemeProvider>
      </CardContent>
    </Card>
  );
}

export default OrderCard;
