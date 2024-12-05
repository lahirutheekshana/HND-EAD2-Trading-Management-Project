import React from "react";
import axios from "axios";
import { useEffect, useState } from "react";
import "./Create.css";
import { Link, useNavigate } from "react-router-dom";

export default function Create() {
  const [plans, setPlans] = useState([]);


  const [name, setName] = useState("");
  const [accStart, setStart] = useState("");
  const [risk, setRisk] = useState("");
  const [riskReward, setReward] = useState("");
  const [winLoss, setWinLoss] = useState("");
  const [email, setEmail] = useState("");

  const fetchData = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8083/trading-app/plans",
        {
          params: {
            email: email,
          },
        }
      );
      setPlans(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const PostData = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8083/trading-app/plans", {
        name,
        accStart,
        risk,
        riskReward,
        winLoss,
        email,
      })
      .then((response) => alert("Plan Created Successfully"))
      .catch((error) => console.log(error));
  };

  const handleUpdate = (pName) => {
    axios
      .put("http://localhost:8083/trading-app/plans", {
          name: pName,
          accStart,
          risk,
          riskReward,
          winLoss,
      })
      .then((response) => alert("Plan Updated Successfully"))
      .catch((error) => console.log(error));
  };

  const handleDelete = async (pName) => {
    try {     
      const response = await axios.delete("http://localhost:8083/trading-app/plans", {
          params: {
            name : pName,
          },
        }
      );  
      alert("Plan Deleted Successfully")
      console.log("Deleted:", response.data);
    } catch (error) {
      console.error("Error deleting:", error);
    }
  };

  return (
    <>
      <div className="leftBar1">
        <div>
          <h2>CREATE PLAN</h2>
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

            <label htmlFor="name">Name:</label>
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

            <label htmlFor="Start">Account Start:</label>
            <br />
            <input
              type="text"
              id="Start"
              name="Start"
              class="field"
              value={accStart}
              onChange={(e) => setStart(e.target.value)}
              required
            />
            <br />

            <label htmlFor="Risk">Risk:</label>
            <br />
            <input
              type="text"
              id="Risk"
              name="Risk"
              class="field"
              value={risk}
              onChange={(e) => setRisk(e.target.value)}
              required
            />
            <br />

            <label htmlFor="Reward">Risk Reward:</label>
            <br />
            <input
              type="text"
              id="Reward"
              name="Reward"
              class="field"
              value={riskReward}
              onChange={(e) => setReward(e.target.value)}
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

            <input
              type="submit"
              onClick={PostData}
              value="Create"
              class="btn"
            />
            <input type="button" onClick={fetchData} value="View" class="btn" />
          </form>
        </div>

        <div className="asiri">
          <div className="container1">
            <div className="header">
              <h2>MANAGE PLANS</h2>
            </div>
            <div className="tables">
              <div class="upperBar"></div>
              <div class="Header">
                <h1>Manage Plans</h1>
              </div>
              <div class="table-container">
                <table class="responsive-table">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Date</th>
                      <th>Start</th>
                      <th> Risk</th>
                      <th> Reward </th>
                      <th> Win/Loss </th>
                      <th> User Id </th>
                      <th> Action </th>
                    </tr>
                  </thead>
                  <tbody>
                    {plans.map((plan) => (
                      <tr key={plan.id}>
                        <td>{plan.id}</td>
                        <td>{plan.name}</td>
                        <td>{plan.date}</td>
                        <td>{plan.accStart}</td>
                        <td>{plan.risk}</td>
                        <td>{plan.riskReward}</td>
                        <td>{plan.winLoss}</td>
                        <td>{plan.userId}</td>
                        <td>
                          <button
                            className="update-btn"
                            onClick={() => handleUpdate(plan.name)}
                          >
                            Update
                          </button>
                          <button
                            className="delete-btn"
                            onClick={() => handleDelete(plan.name)}
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


