import Box from '@mui/material/Box';
import {useState} from 'react';
import TextField from '@mui/material/TextField';
import {Paper, Typography} from "@mui/material";
import {Button} from "@mui/material";
import './App.css';
import axios from "axios";

function Home() {
    const [input, setInput] = useState({
        username: "admin",
        password: "password"
    });

    const handleChange = (e) => {
        setInput((prevState) => ({
            ...prevState,
            [e.target.name] : e.target.value,
        }))
    };
    const handleSubmit = (e) => {
        e.preventDefault();
        let uri = "http://10.0.0.109:8080/token";
        axios.post(uri, {}, {
            auth: {
                username: input.username,
                password: input.password
            }
        })
            .then(res =>{
                localStorage.setItem('token', res.data);
                localStorage.setItem('name', input.username);
                console.log(res.data);
            })
            .catch(res =>{
                console.log(res);
            })

    }
    return (
        <nav className="Home">
            <Paper>
                <Typography variant="h4" gutterBottom>
                    Login
                </Typography>

                <form onSubmit={handleSubmit}>
                    <div>
                        <TextField name="username" value={input.username} onChange={handleChange} required id="outlined-required" label="Username"/>
                    </div>
                    <div>
                        <TextField name="password" value={input.password} onChange={handleChange} required id="outlined-required" label="Password"/>
                    </div>
                    <div>
                        <Button type="submit" variant="contained" >Login</Button>
                    </div>
                </form>
            </Paper>
        </nav>
      );
}

export default Home;
