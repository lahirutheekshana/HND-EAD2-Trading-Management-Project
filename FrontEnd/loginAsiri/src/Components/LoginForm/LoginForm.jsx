import React from 'react'
import "./LoginForm.css";
import { FaUserAlt } from "react-icons/fa";
import { FaLock } from "react-icons/fa";
import { useState } from 'react';
import axios from 'axios';


export default function LoginForm() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.get('http://localhost:8081/trading-app/users', {
                params: {
                    email,
                    password,
                }
            });
            if (response.data === "Login SuccessFul") {
              sessionStorage.setItem('userEmail', email);
              navigate1(1);
            } 
        } catch (error) {
            alert('Login Unsuccessful');
            console.error('Login Unsuccessful');
            // Handle login failure (e.g., show error message)
        }
    }

    function navigate1(data) {
      if (data === 1) {
        alert('Success');
        window.location.href = '/Dashboard';
        console.log('Login Success:', data);
      } 
    }

  return (
    <div className="full">
      <div className='wrapper'>
        <form onSubmit={handleSubmit}>
          <h1>Login</h1>
          <div className='input-box'>
            <input type='text' placeholder='Email' required value={email} onChange={(e) => setEmail(e.target.value)} />
            <FaUserAlt className='icon' />
          </div>
          <div className='input-box'>
            <input type='text' placeholder='Password' required value={password} onChange={(e) => setPassword(e.target.value)} />
            <FaLock className='icon' />
          </div>

          <div className="remember-forgot1">
            <a href="/Register">Forgot password</a>
          </div>
          <button type='submit'>Login</button>
          
          <div className="register-link1">
            <p>Don't have an account ?<a href="/Register">Register</a></p>
          </div>
        </form>
      </div>
    </div>

  );
};
