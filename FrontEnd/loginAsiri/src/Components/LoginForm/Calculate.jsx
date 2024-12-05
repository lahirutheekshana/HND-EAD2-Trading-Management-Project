import React from "react";
import axios from "axios";
import { useEffect, useState } from "react";
import "./Create.css";

export default function Calculate() {
  const [incomes, setIncomes] = useState([]);

  const [totalTrades, setTrades] = useState("");
  const [planName, setName] = useState("");
  const [email, setEmail] = useState("");


  const fetchData = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8087/trading-app/incomes",
        {
        }
      );
      setIncomes(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const PostData = (e) => {
    e.preventDefault();  
    try {     
      axios.post("http://localhost:8087/trading-app/incomes", {
        totalTrades,
        planName,
        email,
      });  
      fetchData();
      alert("Income Calulated");
    } catch (error) {
      console.error("Error Posting:", error);
    }
  };
  
  const handleDelete = async () => {
    try {     
      axios.delete("http://localhost:8087/trading-app/incomes", {});  
      console.log("Deleted:");
    } catch (error) {
      alert("Refresh Page To Apply Changes")
      console.error("Error deleting:");
    }
  };


  return (
    <>
      <div className="leftBar1">
        <div>
          <h2>Calculate Income</h2>
          <div />
          <form action="">

            <label htmlFor="Email">Email:</label>
            <br />
            <input type="email" id="Email" name="Email" class="field" value={email} onChange={(e) => setEmail(e.target.value)} required />
            <br />

            <label htmlFor="name">Plan Name:</label>
            <br />
            <input type="text" id="name" name="name" class="field" value={planName} onChange={(e) => setName(e.target.value)} required />
            <br />

            <label htmlFor="Trades">Total Trades:</label>
            <br />
            <input type="text" id="Trades" name="Trades" class="field" value={totalTrades} onChange={(e) => setTrades(e.target.value)} required />
            <br />

            <input type="submit" onClick={PostData}  value="Calculate"  class="btn" />
            <input type="submit" onClick={handleDelete}  value="New"  class="btn" /> 
          </form>
        </div>

        <div className="asiri">
          <div className="container1">
            <div className="header">
              <h2>Income Calculation</h2>
            </div>
            <div className="tables">
            <div class="upperBar"></div>
        <div class="Header">
            <h1>Income Calculation</h1>
        </div>
        <div class="table-container">
            <table class="responsive-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Balance</th>
                        <th>Profit/Loss</th>
                        <th>New Balance</th>
                        <th>User Id</th>
                        <th> Plan Id</th>
                    </tr>
                </thead>
                <tbody>
                {incomes.map((income) => (
                      <tr key={income.id}>
                        <td>{income.id}</td>
                        <td>{income.balance}</td>
                        <td>{income.profitLoss}</td>
                        <td>{income.newBalance}</td>
                        <td>{income.userId}</td>
                        <td>{income.pid}</td>
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
