import React from "react";
import { FaUser, FaLock } from "react-icons/fa";
import { MdEmail } from "react-icons/md";
import "./Register.css";
import axios from "axios";
import { useEffect, useState } from "react";

export default function Register() {
  const [setDate] = useState([]);

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  useEffect(() => {
    axios
      .get("http://localhost:8081/trading-app/users")
      .then((response) => {
        console.log("Response:", response.data);
        setDate(response.data);
      })
      .catch((error) => console.log(error));
  }, []);

  const PostData = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8081/trading-app/users", {
        firstName,
        lastName,
        email,
        password,
      })
      .then((response) => console.log("Posting Data", response))
      .catch((error) => console.log(error));
  };

  return (
    <div className="full">
      <div className="wrapper1">
        <form action="">
          <h1>Register</h1>
          <hr></hr>

          <div className="input-box">
            <input
              type="text"
              placeholder="frist name"
              required
              value={firstName} 
              onChange={(e) => setFirstName(e.target.value)}
            />
            <FaUser className="icon" />
          </div>
          <div className="input-box">
            <input
              type="text"
              placeholder="last name"
              required
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
            />
            <FaUser className="icon" />
          </div>

          <div className="input-box">
            <input
              type="email"
              placeholder="Email"
              required
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
            <MdEmail className="icon" />
          </div>
          <div className="input-box">
            <input
              type="password"
              placeholder=" password"
              required
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <FaLock className="icon" />
          </div>

          <button type="submit" onClick={PostData}>
            Register
          </button>

          <div className="register-linkMy">
            <p>
              Already Have An Account? <div><a href="/">log in</a></div>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
}
