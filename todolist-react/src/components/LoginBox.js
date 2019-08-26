import React from 'react';
import axios from 'axios';
import navigate from 'react-router-dom'

export class LoginBox extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            email: "",
            password: "",
            errors: [],
        };
    }
    showValidationErr(elm, msg) {
        this.setState((prevState) => ({
            errors: [
                ...prevState.errors, {
                    elm,
                    msg
                }
            ]
        }));
    }

    clearValidationErr(elm) {
        this.setState((prevState) => {
            let newArr = [];
            for (let err of prevState.errors) {
                if (elm != err.elm) {
                    newArr.push(err);
                }
            }
            return { errors: newArr };
        });
    }

    onEmailChange(e) {
        this.setState({ email: e.target.value });
        this.clearValidationErr("email");
    }

    onPasswordChange(e) {
        this.setState({ password: e.target.value });
        this.clearValidationErr("password");
    }

    submitLogin(e) {
        console.log(this.state);

        if (this.state.username == "") {
            this.showValidationErr("username", "Username Cannot be empty!");
        }
        if (this.state.email == "") {
            this.showValidationErr("email", "Email Cannot be empty!");
        }
        if (this.state.password == "") {
            this.showValidationErr("password", "Password Cannot be empty!");
        }

        this.props.history.push('/todolist');
        
        axios.get('http://localhost:8080/api/user/login', this.state)
        .then(Response =>{
            this.props.history.push('/todolist');
        })
        .catch(error => {
            console.log(error)
        });

    }

    render() {
        let passwordErr = null,
            emailErr = null;

        for (let err of this.state.errors) {
            if (err.elm == "password") {
                passwordErr = err.msg;
            }
            if (err.elm == "email") {
                emailErr = err.msg;
            }
        }

        return (
            
            <div className="inner-container">
                <div className="header">
                    Login
                </div>
                <div className="box">

                    <div className="input-group">
                        <label htmlFor="username">Username</label>
                        <input
                            type="text"
                            name="username"
                            className="login-input"
                            placeholder="Username" 
                            onChange={this.onEmailChange.bind(this)}/>
                        
                        <small className="danger-error">{emailErr ? emailErr: ""}</small>
                    </div>

                    <div className="input-group">
                        <label htmlFor="password">Password</label>
                        <input
                            type="password"
                            name="password"
                            className="login-input"
                            placeholder="Password" 
                            onChange={this.onPasswordChange.bind(this)} />

                        <small className="danger-error">{passwordErr? passwordErr: ""}</small>
                    </div>

                    <button
                        type="button"
                        className="login-btn"
                        onClick={this
                            .submitLogin
                            .bind(this)}>Login</button>

                </div>
            </div>
        );
    }

}