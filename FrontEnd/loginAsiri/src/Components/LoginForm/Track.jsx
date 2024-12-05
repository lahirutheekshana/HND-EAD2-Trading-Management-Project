import React from "react";
import axios from "axios";
import { useEffect, useState } from "react";
import "./Create.css";
import { Link, useNavigate } from "react-router-dom";

export default function Create() {
  const [Trades, setTrades] = useState([]);

  const [email, setEmail] = useState("");
  const [name, setName] = useState("");
  const [capital, setCapital] = useState("");
  const [market, setMarket] = useState("");
  const [RiskAmount, setRiskAmount] = useState("");
  const [winLoss, setWinLoss] = useState("");
  const [buySell, setBuySell] = useState("");

  const fetchData = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8085/trading-app/trades",
        {
          params: {
            email: email,
          },
        }
      );
      setTrades(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const PostData = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8085/trading-app/trades", {
          name,
          capital,
          market,
          RiskAmount,
          winLoss,
          buySell,
          email,
      })
      .then((response) => console.log("Posting Data", response))
      .catch((error) => console.log(error));
  };

  const handleUpdate = (tName) => {
    axios
      .put("http://localhost:8085/trading-app/trades", {
          name: tName,
          capital,
          market,
          RiskAmount,
          winLoss,
          buySell,
      })
      .then((response) => console.log("Data Updated", response))
      .catch((error) => console.log(error));
  };

  const handleDelete = async (tradeName) => {
    try {
      const response = await axios.delete(
        "http://localhost:8085/trading-app/trades",
        {
          params: {
            tName: tradeName,
          },
        }
      );
      console.log("Deleted:", response.data);
    } catch (error) {
      console.error("Error deleting:", error);
    }
  };

  {
    /*TRACK TRADES HTML*/
  }
  return (
    <>
      <div className="leftBar1">
        <div>
          <h2>Track Trades</h2>
          <div />
          <form action="">
            <label htmlFor="Email">Email:</label>
            <br />
            <input
              type="email"
              id="Email"
              name="Email"
              class="field"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
            <br />

            <label htmlFor="name">Trade Name:</label>
            <br />
            <input
              type="text"
              id="name"
              name="name"
              class="field"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
            />
            <br />

            <label htmlFor="Start">Capital:</label>
            <br />
            <input
              type="text"
              id="Start"
              name="Start"
              class="field"
              value={capital}
              onChange={(e) => setCapital(e.target.value)}
              required
            />
            <br />

            <label htmlFor="Risk">Market:</label>
            <br />
            <input
              type="text"
              id="Risk"
              name="Risk"
              class="field"
              value={market}
              onChange={(e) => setMarket(e.target.value)}
              required
            />
            <br />

            <label htmlFor="Reward">Risk Amount:</label>
            <br />
            <input
              type="text"
              id="Reward"
              name="Reward"
              class="field"
              value={RiskAmount}
              onChange={(e) => setRiskAmount(e.target.value)}
              required
            />
            <br />

            <label htmlFor="Win">Win/Loss:</label>
            <br />
            <input
              type="text"
              id="Win"
              name="Win"
              class="field"
              value={winLoss}
              onChange={(e) => setWinLoss(e.target.value)}
              required
            />
            <br />

            <label htmlFor="Buy">Buy/Sell:</label>
            <br />
            <input
              type="text"
              id="Buy"
              name="Buy"
              class="field"
              value={buySell}
              onChange={(e) => setBuySell(e.target.value)}
              required
            />
            <br />

            <input type="submit" onClick={PostData} value="Track" class="btn" />
            <input type="Button" onClick={fetchData} value="View" class="btn" />
          </form>
        </div>

        <div className="asiri">
          <div className="container1">
            <div className="header">
              <h2>TRACK TRADES</h2>
            </div>
            <div className="tables">
              <div class="upperBar"></div>
              <div class="Header">
                <h1>Track Trades</h1>
              </div>
              <div class="table-container">
                <table class="responsive-table">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Date</th>
                      <th>Capital </th>
                      <th> Market </th>
                      <th> Risk Amount </th>
                      <th> Win/Loss </th>
                      <th> Buy/Sell </th>
                      <th> User Id</th>
                      <th> Actions </th>
                    </tr>
                  </thead>
                  <tbody>
                    {Trades.map((trade) => (
                      <tr key={trade.id}>
                        <td>{trade.id}</td>
                        <td>{trade.name}</td>
                        <td>{trade.date}</td>
                        <td>{trade.capital}</td>
                        <td>{trade.market}</td>
                        <td>{trade.riskAmount}</td>
                        <td>{trade.winLoss}</td>
                        <td>{trade.buySell}</td>
                        <td>{trade.tuserId}</td>
                        <td>
                          <button
                            className="update-btn"
                            onClick={() => handleUpdate(trade.name)}
                          >
                            Update
                          </button>
                          <button
                            className="delete-btn"
                            onClick={() => handleDelete(trade.name)}
                          >
                            Delete
                          </button>
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
              <div class="lowerBar"></div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
