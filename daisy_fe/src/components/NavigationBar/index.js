import React from "react";
import { Link } from "react-router-dom";
import { AppBar, Toolbar, CssBaseline, Typography } from "@mui/material";
// import PropTypes from 'prop-types';

NavigationBar.propTypes = {};

function NavigationBar(props) {
  return (
    <AppBar position="static">
      <CssBaseline />
      <Toolbar>
        <Typography variant="h4">Navbar</Typography>
        <div>
          <Link to="/">Orders</Link>
          <Link to="/delivering">Delivering</Link>
          <Link to="/history">History</Link>
        </div>
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
