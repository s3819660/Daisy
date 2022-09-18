import "./App.css";
import { Routes, Route } from "react-router-dom";
import Orders from "./pages/OrdersPage";
import Delivering from "./pages/DeliveringPage";
import History from "./pages/HistoryPage";
import NavigationBar from "./components/NavigationBar";

function App() {
  return (
    <div className="App">
      <NavigationBar />
      <Routes>
        <Route path="/" element={<Orders />} />
        <Route path="/delivering" element={<Delivering />} />
        <Route path="/history" element={<History />} />
      </Routes>
    </div>
  );
}

export default App;
