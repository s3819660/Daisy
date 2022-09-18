import React from "react";
import { Link } from "react-router-dom";
import { AppBar, Toolbar, CssBaseline, Typography, Box } from "@mui/material";
// import PropTypes from 'prop-types';
import "./style.css"

NavigationBar.propTypes = {};

function NavigationBar(props) {
  return (
    <AppBar position="static" sx={{backgroundColor: "#F9EDAA"}}>
      <CssBaseline />
      <Toolbar >
        <Typography variant="h4" sx={{color: "black"}}>Daisy</Typography>
        <Box sx={{m: 2}}>
          <Link className="nav-link" to="/" sx={{mx: 2}} >Orders</Link>
          <Link className="nav-link" to="/delivering" sx={{mx: 2}} >Delivering</Link>
          <Link className="nav-link" to="/history" sx={{mx: 2}} >History</Link>
        </Box>
      </Toolbar>
    </AppBar>
  );
  //   return (
  //     <div>

  //       <Link to="/delivering">Delivering</Link>
  //       <Link to="/history">History</Link>
  //     </div>
  //   );
}

export default NavigationBar;
